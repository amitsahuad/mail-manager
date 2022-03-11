package com.mailmanager.service.api;

import com.mailmanager.service.dto.AccountDetailsDto;
import com.mailmanager.service.dto.PurchaseDate;
import com.mailmanager.service.model.AccountDetailsModel;
import com.mailmanager.service.service.MailManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AdminApi {

    @Autowired
    private MailManagerService mailManagerService;
    @GetMapping("getAllAccounts")
    public ResponseEntity<List<AccountDetailsModel>> getAllAccounts(){
        LocalDate d
                = LocalDate.now();
               System.out.println(d);

        return new ResponseEntity<>(mailManagerService.getAllMails(), HttpStatus.OK);
    }

    @PostMapping("addAccounts")
    public List<AccountDetailsDto>  addAccounts(@RequestBody  List<AccountDetailsDto> dtos){
        mailManagerService.addAccounts(dtos);
        return dtos;
    }

    @GetMapping(value="getDetailsByDate/{from}/{to}")
    public ResponseEntity<List<AccountDetailsModel>> getDetailsByDate(@PathVariable
                                                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,@PathVariable
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to){


        System.out.println(from);
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    @GetMapping(value="expireOnDate/{d}")
    public ResponseEntity<List<AccountDetailsModel>> expireOnDate(@PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate d){
        return new ResponseEntity<>(mailManagerService.expireOnDate(d), HttpStatus.OK);
    }

    @PostMapping("add30DaysFromDate")
    public List<String> add30DaysFromDate(@RequestBody List<PurchaseDate> mails) {
        List<String> updatedMails= mailManagerService.add30DaysFromDate(mails);
        return updatedMails;
    }
}
