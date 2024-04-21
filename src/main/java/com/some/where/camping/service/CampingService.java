package com.some.where.camping.service;

import com.some.where.camping.dto.response.CampingRegionCountsResponse;
import com.some.where.camping.dto.response.CampingPreViewResponse;
import com.some.where.camping.repository.*;
import com.some.where.domain.enums.Region;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CampingService {

    private final CampingRepository campingRepository;
    private final CampingCategoryRepository campingCategoryRepository;
    private final AmenityRepository amenityRepository;
    private final GlampingRepository glampingRepository;
    private final OperatePeriodRepository operatePeriodRepository;
    private final NearAmenityRepository nearAmenityRepository;

    /**
     * 지역을 통해 그 지역의 캠핑장 정보 받아와서 response 타입으로 반환
     *
     * @param region 캠핑장 정보를 볼 지역
     */
    @Transactional(readOnly = true)
    public List<CampingPreViewResponse> campingPreViewList(String region) {
        return campingRepository.findAllByRegionFetchJoinCategory(Region.getRegionByName(region))
                .stream()
                .map(camping -> CampingPreViewResponse.of(camping, camping.getCampingCategories())
                ).toList();
    }

    /**
     * 지역별 캠핑장 수 검색
     * @return
     */
    @Transactional(readOnly = true)
    public List<CampingRegionCountsResponse> campingCountsByRegion() {
        return campingRepository.findGroupByAddressRegionCounts();
    }
}
