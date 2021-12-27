package com.randomshop.shop.DTO;

import com.randomshop.shop.model.Product;
import com.randomshop.shop.model.Role;
import com.randomshop.shop.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String address;
    private List<Product> cart;
    private List<Product> wishList;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private boolean enabled;
}
