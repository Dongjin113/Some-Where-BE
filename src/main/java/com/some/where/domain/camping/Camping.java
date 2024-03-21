package com.some.where.domain.camping;

import com.some.where.domain.BaseEntity;
import com.some.where.domain.embedded.Address;
import com.some.where.domain.embedded.Location;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@NoArgsConstructor(access = PROTECTED)
public class Camping extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "camping_id")
    private Long id;
    private String placeName;
    @Embedded
    private Location location;
    @Embedded
    private Address address;
    private String homePage;
    private String owner;
    private String phoneNum;
    private String subIntro;
    private String introduce;

    @OneToOne
    private OperatePeriod operatePeriod;
    @OneToOne
    private Amenity amenity;
    @OneToOne
    private NearAmenity nearAmenity;
    @OneToOne
    private Glamping glamping;

    @OneToMany(mappedBy = "camping")
    private List<CampingCategory> campingCategories = new ArrayList<>();

}
