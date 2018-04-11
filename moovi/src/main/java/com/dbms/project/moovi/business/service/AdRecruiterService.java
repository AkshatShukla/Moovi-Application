package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.Actor;
import com.dbms.project.moovi.data.entity.AdRecruiter;
import com.dbms.project.moovi.data.repository.ActorRepository;
import com.dbms.project.moovi.data.repository.AdRecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdRecruiterService extends Utils {

    @Autowired
    private AdRecruiterRepository adRecruiterRepository;
    
    @Autowired
    private ActorRepository actorRepository;

    @PostMapping("/api/adrecruiter")
    public AdRecruiter createAdRecruiter(@RequestBody AdRecruiter adRecruiter){
        return adRecruiterRepository.save(adRecruiter);
    }

    @GetMapping("/api/adrecruiter")
    public List<AdRecruiter> findAllAdRecruiters(@RequestParam(name="username", required = false) String username){
        if(username != null)
            return (List<AdRecruiter>) adRecruiterRepository.findAdRecruiterByUsername(username);
        return (List<AdRecruiter>) adRecruiterRepository.findAll();
    }

    @PostMapping("api/recruit/adrecruiter/{username}/actor/{actorId}")
    public void AdRecruiterRecruitsActor(
            @PathVariable("username") String username,
            @PathVariable("actorId") long actorId){

		Actor actor = (Actor) actorRepository.findActorById(actorId);
        AdRecruiter adRecruiter = (AdRecruiter) adRecruiterRepository.findAdRecruiterByUsername(username);
        adRecruiter.recruitsActor(actor);
        adRecruiterRepository.save(adRecruiter);
    }
}
