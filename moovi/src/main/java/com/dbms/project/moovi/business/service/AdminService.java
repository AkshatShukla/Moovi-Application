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

    @DeleteMapping("/api/delete/fan/{userId}")
    public void deleteFan(
            @PathVariable("userId") long userId){
        fanRepository.deleteById(userId);
    }
}
