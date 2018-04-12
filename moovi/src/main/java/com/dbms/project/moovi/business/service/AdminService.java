package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.Admin;
import com.dbms.project.moovi.data.entity.Fan;
import com.dbms.project.moovi.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
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

    @DeleteMapping("/api/delete/theatre/{username}")
    public void deleteTheatre(
            @PathVariable("username") String username){
        theatreRepository.deleteById(theatreManagerRepository.findManagerIdByUsername(username));
    }
}
