package com.randomshop.shop.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class MessageDTO implements Serializable {
    private String message;
}
