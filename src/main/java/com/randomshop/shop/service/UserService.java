package com.randomshop.shop.service;

import com.randomshop.shop.DAO.UserDAO;
import com.randomshop.shop.DTO.UserDTO;
import com.randomshop.shop.model.Role;
import com.randomshop.shop.model.ShopUser;
import com.randomshop.shop.model.Status;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    public Optional<ShopUser> findByEmail(String email){
        return userDAO.findByEmail(email);
    }

    public ShopUser createUser(UserDTO userDTO) {
        return userDAO.save(dtoToModel(userDTO));
    }

    private ShopUser dtoToModel(UserDTO userDTO) {
        ShopUser shopUser = new ShopUser();
        shopUser.setEmail(userDTO.getEmail());
        shopUser.setEnabled(true);
        shopUser.setName(userDTO.getName());
        shopUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        shopUser.setRole(Role.USER);
        shopUser.setStatus(Status.ACTIVE);
        return shopUser;
    }
}
