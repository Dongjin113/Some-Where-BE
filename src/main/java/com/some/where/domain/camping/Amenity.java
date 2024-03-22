package com.some.where.domain.camping;

import com.some.where.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "camping_amenity")
public class Amenity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "amenity_id")
    private Long id;

    @OneToOne(fetch = LAZY, mappedBy = "amenity")
    @JoinColumn(name = "camping_id")
    private Camping camping;

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
