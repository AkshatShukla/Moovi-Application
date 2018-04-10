package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.TheatreManager;
import com.dbms.project.moovi.data.repository.TheatreManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreManagerService extends Utils {

    @Autowired
    private TheatreManagerRepository theatreManagerRepository;

    @PostMapping("/api/critic")
    public TheatreManager createTheatreManager(@RequestBody TheatreManager theatreManager) {
        return theatreManagerRepository.save(theatreManager);
    }
}
