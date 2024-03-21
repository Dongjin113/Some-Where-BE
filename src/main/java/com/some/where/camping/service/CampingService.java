package com.some.where.camping.service;

import com.some.where.camping.repository.CampingCategoryRepository;
import com.some.where.camping.repository.CampingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CampingService {

    private final CampingRepository campingRepository;
    private final CampingCategoryRepository campingCategoryRepository;

}
