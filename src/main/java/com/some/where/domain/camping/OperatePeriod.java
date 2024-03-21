package com.some.where.domain.camping;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class OperatePeriod {

    @Column(name = "weekday_operate")
    private boolean weekday;

    @Column(name = "weekend_operate")
    private boolean weekend;

    @Column(name = "spring_operate")
    private boolean spring;

    @Column(name = "summer_operate")
    private boolean summer;

    @Column(name = "autumn_operate")
    private boolean autumn;

    @Column(name = "winter_operate")
    private boolean winter;

}
