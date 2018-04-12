package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.Theatre;
import com.dbms.project.moovi.data.entity.TheatreManager;
import com.dbms.project.moovi.data.repository.TheatreManagerRepository;
import com.dbms.project.moovi.data.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TheatreManagerService extends Utils {

    @Autowired
    private TheatreManagerRepository theatreManagerRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @PostMapping("/api/theatremanager")
    public TheatreManager createTheatreManager(@RequestBody TheatreManager theatreManager) {
        return theatreManagerRepository.save(theatreManager);
    }

    @PostMapping("/api/manage/manager/{username}/theatre/{theatreId}")
    public void theatreManagedBy(
            @PathVariable("username") String username,
            @PathVariable("theatreId") long theatreId){
        Theatre theatre = (Theatre) theatreRepository.findTheatreById(theatreId);
        TheatreManager theatreManager = (TheatreManager) theatreManagerRepository.findManagerByUsername(username);
        theatre.setTheatreManager(theatreManager);
        theatreManagerRepository.save(theatreManager);
    }
}
