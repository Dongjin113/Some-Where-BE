package com.some.where.domain.camping;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class CampingCategory {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "camping_id")
    private Camping camping;

    @Enumerated(STRING)
    private CampingCategoryMenu category;
}
