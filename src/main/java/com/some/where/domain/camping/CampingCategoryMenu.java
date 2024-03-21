package com.some.where.domain.camping;

import lombok.Getter;

@Getter
public enum CampingCategoryMenu {

    NORMAL("일반야영장"),
    CAR("자동차야영장"),
    CARAVAN("카라반"),
    GLAMPING("글램핑");

    private final String Name;

    CampingCategoryMenu(String name) {
        Name = name;
    }
}
