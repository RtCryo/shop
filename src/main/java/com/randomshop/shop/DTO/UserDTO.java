package com.randomshop.shop.DTO;

import com.randomshop.shop.model.Role;
import com.randomshop.shop.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private boolean enabled;
}
