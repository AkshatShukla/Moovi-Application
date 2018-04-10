package com.dbms.project.moovi.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbms.project.moovi.data.entity.Critic;
import com.dbms.project.moovi.data.repository.CriticRepository;

@RestController
public class CriticService extends APICredentials {
	
	@Autowired
    private CriticRepository criticRepository;
	
	@PostMapping("/api/critic")
	public Critic createCritic(@RequestBody Critic critic) {
		return criticRepository.save(critic);
    }
	
	@GetMapping("/api/critic")
    public Iterable<Critic> findAllCritics(
    		@RequestParam(name = "username", required = false) String username) {
        if (username != null)
            return criticRepository.findCriticByUsername(username);
        return criticRepository.findAll();
    }

}
