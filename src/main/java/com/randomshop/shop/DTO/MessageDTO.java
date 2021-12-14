package com.randomshop.shop.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class MessageDTO implements Serializable {
    private String message;
}
