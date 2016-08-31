package com.jurin_n.domain.team;

public class TeamService {
    public Team getTeams() {
        return new Team("2", "test2");
    }

    public Team getTeam() {
        return new Team("1", "test1");
    }
}
