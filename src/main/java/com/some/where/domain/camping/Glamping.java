package com.some.where.domain.camping;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class Glamping {

    @Column(name = "glamping_bed")
    private boolean bed;

    @Column(name = "glamping_tv")
    private boolean tv;

    @Column(name = "glamping_refrigerator")
    private boolean refrigerator;

    @Column(name = "glamping_internet")
    private boolean internet;

    @Column(name = "glamping_toilet")
    private boolean toilet;

    @Column(name = "glamping_air_conditioner")
    private boolean airConditioner;

    @Column(name = "glamping_heat")
    private boolean heat;

    @Column(name = "glamping_cookware")
    private boolean cookware;

}
