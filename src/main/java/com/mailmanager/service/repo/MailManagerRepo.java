package com.mailmanager.service.repo;

import com.mailmanager.service.dto.AccountDetailsDto;
import com.mailmanager.service.model.AccountDetailsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MailManagerRepo extends MongoRepository<AccountDetailsModel, String> {
    List<AccountDetailsModel> findByExpiryDate(Date d);
}
