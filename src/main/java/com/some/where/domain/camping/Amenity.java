package com.some.where.domain.camping;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class Amenity {

    @Column(name = "amenities_electric")
    private String electric;

    @Column(name = "amenities_hot_water")
    private String hotWater;

    @Column(name = "amenities_wifi")
    private String wifi;

    @Column(name = "amenities_firewood")
    private String firewood;

    @Column(name = "amenities_walk")
    private String walk;

    @Column(name = "amenities_water_park")
    private String waterPark;

    @Column(name = "amenities_playground")
    private String playGround;

    @Column(name = "amenities_mart")
    private String mart;

    @Column(name = "amenities_toilet")
    private Integer toilet;

    @Column(name = "amenities_shower_room")
    private Integer showerRoom;

    @Column(name = "amenities_sink")
    private Integer sink;

    @Column(name = "amenities_fire_extinguisher")
    private Integer fireExtinguisher;

}
