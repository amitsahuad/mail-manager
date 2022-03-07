package com.mailmanager.service.service;

import com.mailmanager.service.dto.AccountDetailsDto;
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
    public List<AccountDetailsModel> getDetailsByDate(Date from, Date to) {
        List<AccountDetailsModel> allMails = mailManagerRepo.findAll();
        List<AccountDetailsModel> filteredMails = new ArrayList<>();
        for(AccountDetailsModel dto: allMails){
            if(dto.getExpiryDate().after(from)&&dto.getExpiryDate().before(to)){
                filteredMails.add(dto);
            }
        }
        return filteredMails;
    }


    @Override
    public List<AccountDetailsModel> expireOnDate(Date d) {
        List<AccountDetailsModel> filteredMails = mailManagerRepo.findByExpiryDate(d);
        return filteredMails;
    }

    @Override
    public String add30DaysFromDate(List<String> mail) throws ParseException {
        List<AccountDetailsModel> allMails = new ArrayList<>();

        for(int i=0;i<mail.size();i++) {
            Date purchaseDate = new Date();
            purchaseDate.getTime();

            Date expiryDate = new Date();
            expiryDate.getTime();
            Calendar cal = Calendar.getInstance();
            cal.setTime(expiryDate);
            cal.add(Calendar.DATE, 30);
           


//            Date d= new SimpleDateFormat("yyyy-MM-dd").parse(expiryDate.toString());
//            Optional<AccountDetailsModel> optional = mailManagerRepo.findById(mail.get(i));
//            optional.get().setPurchaseDate(purchaseDate);
//            optional.get().setExpiryDate(d);

//            System.out.println(inActiveDate);
        }

        return null;
    }
}