package com.randomshop.shop.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SiteSettingDTO {

    private long id;
    private String siteName;
    private String email;
    private String deliveryInfo;
    private String info1;
    private String info2;
    private String info3;
    private String imgLogoName;
    private List<BannerDTO> banner;

}
