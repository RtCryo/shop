package com.randomshop.shop.DAO;

import com.randomshop.shop.model.SiteSetting;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SiteSettingsDAO extends PagingAndSortingRepository<SiteSetting, Long> {

    @Modifying
    @Query("update SiteSetting u set u.siteName = :siteName, u.email = :email, u.deliveryInfo = :deliveryInfo, " +
            "u.info1 = :info1, u.info2 = :info2, u.info3 = :info3, u.imgLogoName = :imgLogoName, u.banner = :banner where u.id = :id")
    void updateSiteSettings(@Param(value = "id") long id,
                        @Param(value = "siteName") String siteName,
                        @Param(value = "email") String email,
                        @Param(value = "deliveryInfo") String deliveryInfo,
                        @Param(value = "info1") String info1,
                        @Param(value = "info2") String info2,
                        @Param(value = "info3") String info3,
                        @Param(value = "imgLogoName") String imgLogoName,
                        @Param(value = "banner") List<String> banner);

}
