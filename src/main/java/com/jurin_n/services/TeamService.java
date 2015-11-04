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
		String id = t.getId()+"@createTeam";
		t.setId(id);
		em.persist(t);
	}
	
	public void createTeam2(Team t){
		String id = t.getId()+"@createTeam2";
		t.setId(id);
		em.persist(t);
	}
}
