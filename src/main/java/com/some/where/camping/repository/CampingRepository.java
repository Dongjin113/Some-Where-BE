package com.some.where.camping.repository;

import com.some.where.domain.camping.Camping;
import com.some.where.domain.camping.CampingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampingRepository extends JpaRepository<Camping, Long>, CampingRepositoryCustom {


}
