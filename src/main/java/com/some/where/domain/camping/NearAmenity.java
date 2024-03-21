package com.some.where.domain.camping;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class NearAmenity {

    @Column(name = "near_fishing")
    private boolean fishing;

    @Column(name = "near_walk")
    private boolean walk;

    @Column(name = "near_beach")
    private boolean beach;

    @Column(name = "near_water_leisure")
    private boolean waterLeisure;

    @Column(name = "near_valley")
    private boolean valley;

    @Column(name = "near_river")
    private boolean river;

    @Column(name = "near_swimming_pool")
    private boolean swimmingPool;

    @Column(name = "near_teenager_experience")
    private boolean teenagerExperience;

    @Column(name = "near_rural_experience")
    private boolean ruralExperience;

    @Column(name = "near_children_playground")
    private boolean childrenPlayground;


}
