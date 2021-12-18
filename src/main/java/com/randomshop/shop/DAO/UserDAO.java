package com.randomshop.shop.DAO;

import com.randomshop.shop.model.ShopUser;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserDAO extends PagingAndSortingRepository<ShopUser, Long> {
    Optional<ShopUser> findByEmail(String email);
}
