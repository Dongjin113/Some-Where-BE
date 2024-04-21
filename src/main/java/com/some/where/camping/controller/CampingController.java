package com.some.where.camping.controller;

import com.some.where.camping.dto.response.CampingRegionCountsResponse;
import com.some.where.camping.dto.response.CampingPreViewResponse;
import com.some.where.camping.service.CampingService;
import com.some.where.common.exception.custom.ErrorCode;
import com.some.where.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/camping")
public class CampingController {

    private final CampingService campingService;

    /**
     * 지역별 캠핑장 조회
     * @param region 캠핑장을 조회할 지역
     */
    @GetMapping("/{region}")
    private ApiResponse<List<CampingPreViewResponse>> campingMap(
            @PathVariable("region") String region
    ) {
        log.info("method CampingService={}", campingService.getClass());
        return new ApiResponse<>(
                ErrorCode.SUCCESS, campingService.campingPreViewList(region)
        );
    }

    /**
     * 지역별 캠핑장 수 조회
     */
    @GetMapping("/region/counts")
    private ApiResponse<List<CampingRegionCountsResponse>> campingRegionCounts(
    ) {
        return new ApiResponse<>(
                ErrorCode.SUCCESS, campingService.campingCountsByRegion()
        );
    }
}
