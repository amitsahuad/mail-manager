package com.mailmanager.service.service;

import com.mailmanager.service.dto.AccountDetailsDto;
import com.mailmanager.service.model.AccountDetailsModel;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface MailManagerService {
    List<AccountDetailsModel> getAllMails();
    String addAccounts(List<AccountDetailsDto> dtos);
    List<AccountDetailsModel> getDetailsByDate(Date from, Date to);
    List<AccountDetailsModel> expireOnDate(Date d);
    String add30DaysFromDate(List<String> mail) throws ParseException;
}
