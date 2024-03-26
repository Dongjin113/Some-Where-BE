package com.some.where.camping.repository;

import com.some.where.domain.camping.Camping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampingRepository extends JpaRepository<Camping, Long>, CampingRepositoryCustom {

    List<Camping> findAllByAddressRegion(String region);

}
