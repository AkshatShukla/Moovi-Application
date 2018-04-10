package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.Theatre;
import com.dbms.project.moovi.data.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @PostMapping("/api/theatre")
    public Theatre createTheatre(@RequestBody Theatre theatre) {
        return theatreRepository.save(theatre);
    }
}
