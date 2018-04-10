package com.dbms.project.moovi.data.repository;

import com.dbms.project.moovi.data.entity.Fan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FanRepository extends CrudRepository<Fan, Integer> {

    @Query("SELECT f FROM Fan f WHERE f.username=:username")
    Iterable<Fan> findFanByUsername(@Param("username") String u);
}
