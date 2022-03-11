package com.mailmanager.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Data
@Document(collection =  "details")
public class AccountDetailsModel {
    @Id
    private String email;
    private LocalDate purchaseDate;
    private LocalDate expiryDate;
    private String resellerName;
}
