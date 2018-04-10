package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbms.project.moovi.data.repository.ActorRepository;
import com.dbms.project.moovi.data.repository.FanRepository;

@RestController
public class ActorService extends Utils{
	
	@Autowired
    private ActorRepository actorRepository;
	
	@Autowired
    private FanRepository fanRepository;

	@PostMapping("/api/actor")
    public Actor createActor(@RequestBody Actor actor) {
	    return actorRepository.save(actor);
    }


}
