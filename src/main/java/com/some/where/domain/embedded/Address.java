package com.some.where.domain.embedded;

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

    public Address(String region, String city, Integer postNum, String roadAddress, String address) {
        this.region = region;
        this.city = city;
        this.postNum = postNum;
        this.roadAddress = roadAddress;
        this.address = address;
    }
}
