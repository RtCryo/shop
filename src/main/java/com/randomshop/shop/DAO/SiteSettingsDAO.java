package com.randomshop.shop.DAO;

import com.randomshop.shop.model.SiteSetting;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

@Transactional
public interface SiteSettingsDAO extends PagingAndSortingRepository<SiteSetting, Long> {

}
