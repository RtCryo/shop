package com.randomshop.shop.service;

import com.randomshop.shop.DAO.SiteSettingsDAO;
import com.randomshop.shop.DTO.SiteSettingDTO;
import com.randomshop.shop.model.SiteSetting;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class SiteService {

    private final SiteSettingsDAO siteSettingsDAO;

    public SiteSetting getSettings(){
        List<SiteSetting> siteSetting = (List<SiteSetting>) siteSettingsDAO.findAll();
        if(siteSetting.size() == 0){
            createSiteSetting();
            siteSetting = (List<SiteSetting>) siteSettingsDAO.findAll();
        }
        return siteSetting.get(0);
    }

    public void updateSiteSettings(SiteSettingDTO siteSetting){
        SiteSetting siteSettingToUpdate = dtoToModel(siteSetting);
        siteSettingsDAO.updateSiteSettings(siteSettingToUpdate.getId(), siteSettingToUpdate.getSiteName(), siteSettingToUpdate.getEmail(),
                siteSettingToUpdate.getDeliveryInfo(), siteSettingToUpdate.getInfo1(), siteSettingToUpdate.getInfo2(), siteSettingToUpdate.getInfo3(),
                siteSettingToUpdate.getImgLogoName(),siteSettingToUpdate.getBanner());
    }

    public void createSiteSetting(){
        SiteSetting siteSetting = new SiteSetting();
        siteSetting.setBanner(new ArrayList<>());
        siteSetting.setDeliveryInfo("DeliveryInfoTest!");
        siteSetting.setEmail("email@test.com");
        siteSetting.setImgLogoName("logo.png");
        siteSetting.setInfo1("info1test");
        siteSetting.setInfo2("info2test");
        siteSetting.setInfo3("info3test");
        siteSetting.setSiteName("siteNameTest");
        siteSettingsDAO.save(siteSetting);
    }

    private SiteSetting dtoToModel(SiteSettingDTO siteSettingDTO) {
        SiteSetting siteSetting = new SiteSetting();
        siteSetting.setId(siteSettingDTO.getId());
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
