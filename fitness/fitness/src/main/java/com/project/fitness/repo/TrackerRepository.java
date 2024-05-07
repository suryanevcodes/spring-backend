package com.project.fitness.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.fitness.model.Tracker;


@Repository
public interface TrackerRepository extends JpaRepository<Tracker,Integer>{
    
}
