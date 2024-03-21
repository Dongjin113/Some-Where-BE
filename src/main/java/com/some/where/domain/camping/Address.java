package com.some.where.domain.camping;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class Address {

    private String region;
    private String city;
    private Integer postNum;
    private String roadAddress;
    private String address;
}
