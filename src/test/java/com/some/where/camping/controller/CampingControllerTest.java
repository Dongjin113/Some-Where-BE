package com.some.where.camping.controller;

import com.some.where.camping.dto.response.CampingPreViewResponse;
import com.some.where.camping.service.CampingService;
import com.some.where.common.ControllerTest;
import com.some.where.domain.camping.Camping;
import com.some.where.domain.embedded.Address;
import com.some.where.domain.embedded.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Transactional
class CampingControllerTest extends ControllerTest {

    @MockBean
    private CampingService campingService;

    @Test
    @DisplayName("지역이름으로 지역 캠핑장 조회하기")
    void campingPreViewList() throws Exception {
        final String region = "서울";
        List<CampingPreViewResponse> campingList = IntStream.range(0, 3).mapToObj(
                index -> CampingPreViewResponse.of(
                        new Camping("서울캠핑장" + index,
                                new Location(13.12, 12.12),
                                new Address("서울", "강서구", 1235, "도로명", "주소"),
                                "홈페이지 URL", "사유지",
                                "12-123-1234", "서브소개", "소개"
                        ))).toList();
        when(campingService.campingPreViewList(region)).thenReturn(campingList);

        mockMvc.perform(get("/api/camping/{region}", region)
                        .contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.status.code").value("200"))
                .andExpect(jsonPath("$.status.message").value("OK"))
                .andExpect(jsonPath("$.data[0].placeName").value("서울캠핑장0"))
                .andExpect(jsonPath("$.data[0].location.lat").value(13.12))
                .andExpect(jsonPath("$.data[0].location.lng").value(12.12))
                .andExpect(jsonPath("$.data[0].address.region").value("서울"))
                .andExpect(jsonPath("$.data[0].address.city").value("강서구"))
                .andExpect(jsonPath("$.data[0].address.postNum").value(1235))
                .andExpect(jsonPath("$.data[0].address.roadAddress").value("도로명"))
                .andExpect(jsonPath("$.data[0].address.address").value("주소"))
                .andExpect(jsonPath("$.data[0].homePage").value("홈페이지 URL"))
                .andExpect(jsonPath("$.data[0].phoneNum").value("12-123-1234"))
                .andExpect(jsonPath("$.data[0].subIntro").value("서브소개"))
                .andDo(document("camping-preview",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("region").description("캠핑장 정보를 볼 지역을 요청합니다")
                        ),
                        responseFields(
                                fieldWithPath("status.code").description("상태 코드"),
                                fieldWithPath("status.message").description("상태 메시지"),
                                fieldWithPath("data[0].campingId").description("캠핑장 id값"),
                                fieldWithPath("data[0].placeName").description("캠핑장 이름"),
                                fieldWithPath("data[0].location.lat").description("위도"),
                                fieldWithPath("data[0].location.lng").description("경도"),
                                fieldWithPath("data[0].address.region").description("지역"),
                                fieldWithPath("data[0].address.city").description("군,구"),
                                fieldWithPath("data[0].address.postNum").description("우편 번호"),
                                fieldWithPath("data[0].address.roadAddress").description("도로명 주소"),
                                fieldWithPath("data[0].address.address").description("지번 주소"),
                                fieldWithPath("data[0].homePage").description("캠핑장 홈페이지"),
                                fieldWithPath("data[0].phoneNum").description("캠핑장 번호"),
                                fieldWithPath("data[0].subIntro").description("캠핑장 간단 소개")
                        )));
    }
}