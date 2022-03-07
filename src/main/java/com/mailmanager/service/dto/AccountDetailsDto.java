package com.mailmanager.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetailsDto {
    private String email;
    private Date purchaseDate;
    private Date expiryDate;
    private String resellerName;
}