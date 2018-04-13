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
        if(fanRepository.findById(fanRepository.findFanIdByUsername(username)).isPresent())
            fanRepository.deleteById(fanRepository.findFanIdByUsername(username));
    }

    @DeleteMapping("/api/delete/critic/{username}")
    public void deleteCritic(
            @PathVariable("username") String username){
        if(criticRepository.findById(criticRepository.findCriticIdByUsername(username)).isPresent())
            criticRepository.deleteById(criticRepository.findCriticIdByUsername(username));
    }

    @DeleteMapping("/api/delete/adrecruiter/{username}")
    public void deleteAdRecruiter(
            @PathVariable("username") String username){
        if(adRecruiterRepository.findById(adRecruiterRepository.findAdRecruiterIdByUsername(username)).isPresent())
            adRecruiterRepository.deleteById(adRecruiterRepository.findAdRecruiterIdByUsername(username));
    }

    @DeleteMapping("/api/delete/theatremanager/{username}")
    public void deleteTheatreManager(
            @PathVariable("username") String username){
        if(theatreManagerRepository.findById(theatreManagerRepository.findManagerIdByUsername(username)).isPresent())
            theatreManagerRepository.deleteById(theatreManagerRepository.findManagerIdByUsername(username));
    }

    @DeleteMapping("/api/delete/movie/{movieId}")
    public void deleteMovie(
            @PathVariable("movieId") long movieId){
        if(movieRepository.findById(movieId).isPresent()){
            movieRepository.deleteById(movieId);
        }
    }

    @DeleteMapping("/api/delete/actor/{actorId}")
    public void deleteActor(
            @PathVariable("actorId") long actorId){
        if(actorRepository.findById(actorId).isPresent()){
            actorRepository.deleteById(actorId);
        }
    }

    @DeleteMapping("/api/delete/review/{reviewId}")
    public void deleteReview(
            @PathVariable("reviewId") long reviewId){
        if(reviewRepository.findById(reviewId).isPresent()){
            reviewRepository.deleteById(reviewId);
        }
    }

    @PutMapping("/api/edit/fan/{username}")
    public Fan updateFan(
            @PathVariable("username") String username,
            @RequestBody Fan newFan) {
        if(fanRepository.findById(fanRepository.findFanIdByUsername(username)).isPresent()) {
            Fan fan = fanRepository.findById(fanRepository.findFanIdByUsername(username)).get();
            fan.set(newFan);
            return fanRepository.save(fan);
        }
        return null;
    }

    @PutMapping("/api/edit/critic/{username}")
    public Critic updateCritic(
            @PathVariable("username") String username,
            @RequestBody Critic newCritic) {
        if(criticRepository.findById(criticRepository.findCriticIdByUsername(username)).isPresent()) {
            Critic critic = criticRepository.findById(criticRepository.findCriticIdByUsername(username)).get();
            critic.set(newCritic);
            return criticRepository.save(critic);
        }
        return null;
    }

    @PutMapping("/api/edit/adrecruiter/{username}")
    public AdRecruiter updateAdrecruiter(
            @PathVariable("username") String username,
            @RequestBody AdRecruiter newAdrecruiter) {
        if(adRecruiterRepository.findById(adRecruiterRepository.findAdRecruiterIdByUsername(username)).isPresent()) {
            AdRecruiter adr = adRecruiterRepository.findById(adRecruiterRepository.findAdRecruiterIdByUsername(username)).get();
            adr.set(newAdrecruiter);
            return adRecruiterRepository.save(adr);
        }
        return null;
    }

    @PutMapping("/api/edit/theatremanager/{username}")
    public TheatreManager updateTheatreManager(
            @PathVariable("username") String username,
            @RequestBody TheatreManager newtheatreManager) {
        if(theatreManagerRepository.findById(theatreManagerRepository.findManagerIdByUsername(username)).isPresent()) {
            TheatreManager theatreManager = theatreManagerRepository.findById(theatreManagerRepository.findManagerIdByUsername(username)).get();
            theatreManager.set(newtheatreManager);
            return theatreManagerRepository.save(theatreManager);
        }
        return null;
    }

    @PutMapping("/api/edit/theatre/{theatreId}")
    public Theatre updateTheatre(
            @PathVariable("theatreId") long theatreId,
            @RequestBody Theatre newTheatre) {
        if(theatreRepository.findById(theatreId).isPresent()) {
            Theatre theatre = theatreRepository.findById(theatreId).get();
            theatre.set(newTheatre);
            return theatreRepository.save(theatre);
        }
        return null;
    }
}
