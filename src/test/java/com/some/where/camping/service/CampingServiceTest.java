package com.some.where.camping.service;

import com.some.where.camping.dto.response.CampingPreViewResponse;
import com.some.where.camping.repository.CampingRepository;
import com.some.where.domain.camping.Camping;
import com.some.where.domain.embedded.Address;
import com.some.where.domain.embedded.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CampingServiceTest {

    @Autowired
    private CampingRepository campingRepository;
    @Autowired
    private CampingService campingService;

    @Test
    @Transactional
    @DisplayName("캠핑장 데이터 지역으로 조회하기")
    public void campingPreviewList() {
        //given
        String region = "서울";
        List<Camping> campingList = IntStream.range(0, 10).mapToObj(
                index -> new Camping("서울캠핑장" + index,
                        new Location(13.12, 12.12),
                        new Address("서울", "강서구", 1235, "도로명", "주소"),
                        "홈페이지 URL", "사유지",
                        "12-123-1234", "서브소개", "소개"
                )).toList();
        campingRepository.saveAll(campingList);

        //when
        List<CampingPreViewResponse> result = campingService.campingPreViewList(region);

        //then
        assertThat(result.size()).isEqualTo(10);
        assertThat(result.get(0).getCampingId()).isEqualTo(1);
        assertThat(result.get(0).getPlaceName()).isEqualTo("서울캠핑장0");
        assertThat(result.get(0).getAddress().getRegion()).isEqualTo("서울");
        assertThat(result.get(0).getAddress().getCity()).isEqualTo("강서구");
        assertThat(result.get(0).getSubIntro()).isEqualTo("서브소개");
    }
}