package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.AdRecruiter;
import com.dbms.project.moovi.data.repository.AdRecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class AdRecruiterService extends APICredentials {

    @Autowired
    AdRecruiterRepository adRecruiterRepository;

    @PostMapping("/api/adrecruiter")
    public AdRecruiter createAdRecruiter(@RequestBody AdRecruiter adRecruiter){
        return adRecruiterRepository.save(adRecruiter);
    }

    @GetMapping("/api/adrecruiter")
    public List<AdRecruiter> findAllAdRecruiters(@RequestParam(name="username", required = false) String username){
        if(username != null)
            return (List<AdRecruiter>) adRecruiterRepository.findUserByUsername(username);
        return (List<AdRecruiter>) adRecruiterRepository.findAll();
    }

}
