package com.dbms.project.moovi.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dbms.project.moovi.data.repository.ActorRepository;
import com.dbms.project.moovi.data.repository.FanRepository;

@RestController
public class ActorService extends APICredentials{
	
	@Autowired
    private ActorRepository actorRepository;
	
	@Autowired
    private FanRepository fanRepository;
	
	
	
	

}
