package com.jurin_n.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jurin_n.entity.Team;

@Stateless
public class TeamService {
	@PersistenceContext
	private EntityManager em;
	  
	public void createTeam(Team t){
		em.persist(t);
	}
}
