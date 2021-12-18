package com.randomshop.shop.controller;

import com.randomshop.shop.model.SiteSetting;
import com.randomshop.shop.service.SiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/settings")
public class SettingsController {

    private final SiteService siteService;

    @GetMapping
    public ResponseEntity<SiteSetting> settings(){
        return new ResponseEntity<>(siteService.getSettings(), HttpStatus.OK);
    }

}
