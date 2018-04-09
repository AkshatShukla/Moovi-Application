package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.Fan;
import com.dbms.project.moovi.data.repository.FanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FanService extends APICredentials{

    @Autowired
    FanRepository fanRepository;

    @PostMapping("/api/fan")
    public Fan createFan(@RequestBody Fan fan) {
        return fanRepository.save(fan);
    }

    @GetMapping("/api/fan")
    public List<Fan> findAllFans(@RequestParam(name = "username", required = false) String username) {
        if (username != null)
            return (List<Fan>) fanRepository.findFanByUsername(username);
        return (List<Fan>) fanRepository.findAll();
    }
}
