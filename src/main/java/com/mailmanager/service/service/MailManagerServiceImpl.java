package com.mailmanager.service.service;

import com.mailmanager.service.dto.AccountDetailsDto;
import com.mailmanager.service.dto.PurchaseDate;
import com.mailmanager.service.model.AccountDetailsModel;
import com.mailmanager.service.repo.MailManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class MailManagerServiceImpl implements MailManagerService{
    @Autowired
    private MailManagerRepo mailManagerRepo;

    @Override
    public List<AccountDetailsModel> getAllMails() {
        List<AccountDetailsModel> allMails = mailManagerRepo.findAll();
        return allMails;
    }

    @Override
    public String addAccounts(List<AccountDetailsDto> dtos) {
        for(AccountDetailsDto dto: dtos){
            AccountDetailsModel model = new AccountDetailsModel();
            model.setEmail(dto.getEmail());
            model.setExpiryDate(dto.getExpiryDate());
            model.setPurchaseDate(dto.getPurchaseDate());
            mailManagerRepo.save(model);
        }
        return "SUCCESS";
    }

    @Override
    public List<AccountDetailsModel> getDetailsByDate(LocalDate from, LocalDate to) {
        List<AccountDetailsModel> allMails = mailManagerRepo.findAll();
        List<AccountDetailsModel> filteredMails = new ArrayList<>();
        for(AccountDetailsModel dto: allMails){
            if(dto.getExpiryDate().isAfter(from)&&dto.getExpiryDate().isBefore(to)){
                filteredMails.add(dto);
            }
        }
        return filteredMails;
    }


    @Override
    public List<AccountDetailsModel> expireOnDate(LocalDate d) {
        List<AccountDetailsModel> filteredMails = mailManagerRepo.findByExpiryDate(d);
        return filteredMails;
    }

    @Override
    public String add30DaysFromDate(List<PurchaseDate> mail)  {
        List<AccountDetailsModel> allMails = new ArrayList<>();
        for(int i=0;i<mail.size();i++) {
            Optional<AccountDetailsModel> optional = mailManagerRepo.findById(mail.get(i).getMail());
            optional.get().setPurchaseDate(mail.get(i).getPurchaseDate());
            optional.get().setExpiryDate(mail.get(i).getPurchaseDate().plusDays(30));
            AccountDetailsModel accountDetailsModel = optional.get();
            mailManagerRepo.save(accountDetailsModel);
            System.out.print(accountDetailsModel);
        }
        return "SUCCESS";
    }
}