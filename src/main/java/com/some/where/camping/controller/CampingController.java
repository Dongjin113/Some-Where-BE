package com.some.where.camping.controller;

import com.some.where.camping.service.CampingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CampingController {

    private final CampingService campingService;

}
