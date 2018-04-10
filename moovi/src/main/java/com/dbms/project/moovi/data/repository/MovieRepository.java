package com.dbms.project.moovi.data.repository;

import com.dbms.project.moovi.data.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long>{
}
