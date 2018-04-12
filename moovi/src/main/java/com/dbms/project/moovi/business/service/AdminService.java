package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.AdRecruiter;
import com.dbms.project.moovi.data.entity.Admin;
import com.dbms.project.moovi.data.entity.Critic;
import com.dbms.project.moovi.data.entity.Fan;
import com.dbms.project.moovi.data.entity.Theatre;
import com.dbms.project.moovi.data.entity.TheatreManager;
import com.dbms.project.moovi.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private AdRecruiterRepository adRecruiterRepository;

    @Autowired
    private CriticRepository criticRepository;

    @Autowired
    private FanRepository fanRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private TheatreManagerRepository theatreManagerRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/admin")
    public Admin createAdmin(@RequestBody Admin admin){
        return adminRepository.save(admin);
    }

    @DeleteMapping("/api/delete/fan/{username}")
    public void deleteFan(
            @PathVariable("username") String username){
        fanRepository.deleteById(fanRepository.findFanIdByUsername(username));
    }

    @DeleteMapping("/api/delete/critic/{username}")
    public void deleteCritic(
            @PathVariable("username") String username){
        criticRepository.deleteById(criticRepository.findCriticIdByUsername(username));
    }

    @DeleteMapping("/api/delete/adrecruiter/{username}")
    public void deleteAdRecruiter(
            @PathVariable("username") String username){
        adRecruiterRepository.deleteById(adRecruiterRepository.findAdRecruiterIdByUsername(username));
    }

    @DeleteMapping("/api/delete/theatremanager/{username}")
    public void deleteTheatreManager(
            @PathVariable("username") String username){
        theatreManagerRepository.deleteById(theatreManagerRepository.findManagerIdByUsername(username));
    }
    
    @PutMapping("/api/edit/fan/{username}")
    public Fan updateFan(
            @PathVariable("username") String username,
            @RequestBody Fan newFan) {
    	Fan fan = fanRepository.findById(fanRepository.findFanIdByUsername(username)).get();
    	fan.set(newFan);
        return fanRepository.save(fan);
    }
    
    @PutMapping("/api/edit/critic/{username}")
    public Critic updateCritic(
            @PathVariable("username") String username,
            @RequestBody Critic newCritic) {
    	Critic critic = (Critic) criticRepository.findCriticByUsername(username);
    	critic.set(newCritic);
        return criticRepository.save(critic);
    }
    
    @PutMapping("/api/edit/adrecruiter/{username}")
    public AdRecruiter updateAdrecruiter(
            @PathVariable("username") String username,
            @RequestBody AdRecruiter newAdrecruiter) {
    	AdRecruiter adr = (AdRecruiter) adRecruiterRepository.findAdRecruiterByUsername(username);
    	adr.set(newAdrecruiter);
        return adRecruiterRepository.save(adr);
    }
    
    @PutMapping("/api/edit/theatremanager/{username}")
    public TheatreManager updateTheatreManager(
            @PathVariable("username") String username,
            @RequestBody TheatreManager newtheatreManager) {
    	TheatreManager theatreManager = (TheatreManager) theatreManagerRepository.findManagerByUsername(username);
    	theatreManager.set(newtheatreManager);
        return theatreManagerRepository.save(theatreManager);
    }
    
    @PutMapping("/api/edit/theatre/{theatreId}")
    public Theatre updateTheatre(
            @PathVariable("theatreId") long theatreId,
            @RequestBody Theatre newTheatre) {
    	Theatre theatre = (Theatre) theatreRepository.findTheatreById(theatreId);
    	theatre.set(newTheatre);
        return theatreRepository.save(theatre);
    }
}
