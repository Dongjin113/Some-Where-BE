package com.some.where.camping.dto.response;

import com.some.where.domain.camping.Camping;
import com.some.where.domain.embedded.Address;
import com.some.where.domain.embedded.Location;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CampingPreViewResponse {

    private Long campingId;
    private String placeName;
    private Address address;
    private Location location;
    private String phoneNum;
    private String homePage;
    private String subIntro;

    @Builder
    public CampingPreViewResponse(
            Long campingId, String placeName, Address address,
            Location location, String phoneNum, String homePage, String subIntro
    ) {
        this.campingId = campingId;
        this.placeName = placeName;
        this.address = address;
        this.location = location;
        this.phoneNum = phoneNum;
        this.homePage = homePage;
        this.subIntro = subIntro;
    }

    public static CampingPreViewResponse of(Camping camping) {
        return CampingPreViewResponse.builder()
                .campingId(camping.getId())
                .placeName(camping.getPlaceName())
                .address(camping.getAddress())
                .location(camping.getLocation())
                .phoneNum(camping.getPhoneNum())
                .homePage(camping.getHomePage())
                .subIntro(camping.getSubIntro())
                .build();
    }

}
