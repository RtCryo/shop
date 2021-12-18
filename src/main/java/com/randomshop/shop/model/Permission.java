package com.randomshop.shop.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Permission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    ADMIN_WRITE("admin:write");

    private final String permissions;

}
