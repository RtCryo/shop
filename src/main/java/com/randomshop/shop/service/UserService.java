package com.randomshop.shop.service;

import com.randomshop.shop.DAO.UserDAO;
import com.randomshop.shop.DTO.UserDTO;
import com.randomshop.shop.model.Role;
import com.randomshop.shop.model.ShopUser;
import com.randomshop.shop.model.Status;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public UserDTO findUserProfileByEmail(String email){
        return userDAO.findByEmail(email).map((user) -> {
            UserDTO dto = new UserDTO();
            dto.setName(user.getName());
            dto.setAddress(user.getAddress());
            dto.setEmail(user.getEmail());
            return dto;
        }).orElse( new UserDTO());
    }

    public void createUser(UserDTO userDTO) {
        userDTO.setRole(Role.USER);
        userDTO.setStatus(Status.ACTIVE);
        userDTO.setEnabled(true);
        userDAO.save(dtoToModel(userDTO));
    }

    public List<ShopUser> findAllUser(){
        return (List<ShopUser>) userDAO.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void deleteUser(UserDTO userDTO){
        userDAO.delete(userDAO.findById(userDTO.getId()).orElseThrow(() -> new UsernameNotFoundException("User doesn't exists")));
    }

    public ShopUser updateUser(UserDTO userDTO){
        ShopUser updUser = userDAO.findById(userDTO.getId()).map(user -> {
            user.setEmail(userDTO.getEmail());
            user.setStatus(userDTO.getStatus());
            user.setRole(userDTO.getRole());
            user.setName(userDTO.getName());
            user.setAddress(userDTO.getAddress());
            user.setCart(userDTO.getCart());
            user.setWishList(userDTO.getWishList());
            return user;
        }).orElse(dtoToModel(userDTO));
        userDAO.save(updUser);
        return updUser;
    }

    private ShopUser dtoToModel(UserDTO userDTO) {
        ShopUser shopUser = new ShopUser();
        shopUser.setEmail(userDTO.getEmail());
        shopUser.setEnabled(userDTO.isEnabled());
        shopUser.setName(userDTO.getName());
        shopUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        shopUser.setRole(userDTO.getRole());
        shopUser.setStatus(userDTO.getStatus());
        shopUser.setId(userDTO.getId());
        shopUser.setAddress(userDTO.getAddress());
        shopUser.setCart(userDTO.getCart());
        shopUser.setWishList(userDTO.getWishList());
        return shopUser;
    }
}
