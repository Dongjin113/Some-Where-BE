package com.some.where.camping.service;

import com.some.where.camping.dto.response.CampingPreViewResponse;
import com.some.where.camping.repository.*;
import com.some.where.domain.camping.Camping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
     * @param region 캠핑장 정보를 볼 지역
     */
    @Transactional(readOnly = true)
    public List<CampingPreViewResponse> campingPreViewList(String region) {
        return findAllByRegion(region).stream()
                .map(CampingPreViewResponse::of)
                .collect(Collectors.toList());
    }

    /**
     * 지역을 통해 그 지역의 캠핑장 정보 받아오기
     * @param region 캠핑장 정보를 볼 지역
     */
    private List<Camping> findAllByRegion(String region) {
        return campingRepository.findAllByAddressRegion(region);
    }
}
