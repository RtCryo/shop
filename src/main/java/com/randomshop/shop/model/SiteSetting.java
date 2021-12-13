package com.randomshop.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class SiteSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String siteName;
    private String email;
    private String deliveryInfo;
    private String info1;
    private String info2;
    private String info3;
    private String imgLogoName;
    @ElementCollection
    private List<String> banner;

}
