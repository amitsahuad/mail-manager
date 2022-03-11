package com.mailmanager.service.service;

import com.mailmanager.service.dto.AccountDetailsDto;
import com.mailmanager.service.dto.PurchaseDate;
import com.mailmanager.service.model.AccountDetailsModel;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface MailManagerService {
    List<AccountDetailsModel> getAllMails();
    String addAccounts(List<AccountDetailsDto> dtos);
    List<AccountDetailsModel> getDetailsByDate(LocalDate from, LocalDate to);
    List<AccountDetailsModel> expireOnDate(LocalDate d);
    List<String> add30DaysFromDate(List<PurchaseDate> mail) ;
}
