package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.AdRecruiter;
import com.dbms.project.moovi.data.repository.AdRecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AdRecruiterService extends APICredentials {

    @Autowired
    AdRecruiterRepository adRecruiterRepository;

    @PostMapping
    public AdRecruiter createAdRecruiter(@RequestBody AdRecruiter adRecruiter){
        return adRecruiterRepository.save(adRecruiter);
    }
}
