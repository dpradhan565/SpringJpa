package com.cognizant.ormlearn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {

}
