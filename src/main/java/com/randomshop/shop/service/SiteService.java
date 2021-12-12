package com.randomshop.shop.service;

import com.randomshop.shop.DAO.SiteSettingsDAO;
import com.randomshop.shop.DTO.SiteSettingDTO;
import com.randomshop.shop.model.SiteSetting;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@RequiredArgsConstructor
@Service
public class SiteService {

    private final SiteSettingsDAO siteSettingsDAO;

    public SiteSetting getSettings(){
        return siteSettingsDAO.findSiteSettingById(1);
    }

    public SiteSetting updateSiteSettings(SiteSettingDTO siteSetting){
        SiteSetting siteSettingToUpdate = dtoToModel(siteSetting);
        return siteSettingsDAO.updateSiteSettings(siteSettingToUpdate.getId(), siteSettingToUpdate.getSiteName(), siteSettingToUpdate.getEmail(),
                siteSettingToUpdate.getDeliveryInfo(), siteSettingToUpdate.getInfo1(), siteSettingToUpdate.getInfo2(), siteSettingToUpdate.getInfo3(),
                siteSettingToUpdate.getImgLogoName(), siteSettingToUpdate.getBanner());
    }

    private SiteSetting dtoToModel(SiteSettingDTO siteSettingDTO) {
        SiteSetting siteSetting = new SiteSetting();
        siteSetting.setSiteName(siteSettingDTO.getSiteName());
        siteSetting.setEmail(siteSettingDTO.getEmail());
        siteSetting.setDeliveryInfo(siteSettingDTO.getDeliveryInfo());
        siteSetting.setInfo1(siteSettingDTO.getInfo1());
        siteSetting.setInfo2(siteSettingDTO.getInfo2());
        siteSetting.setInfo3(siteSettingDTO.getInfo3());
        siteSetting.setImgLogoName(siteSettingDTO.getImgLogoName());
        siteSetting.setBanner(siteSettingDTO.getBanner());
        return siteSetting;
    }

}
