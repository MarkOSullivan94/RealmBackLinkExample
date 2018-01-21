package com.example.mos.realmmultilevelbacklinkexample;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Mark O'Sullivan on 20th January 2018.
 */

@RealmClass
public class League implements RealmModel {

    @PrimaryKey
    private String id;
    private String name;
    private Integer numberOfClubs;
    private RealmList<Club> leagueClubList;

    public League() {}

    public League(String id, String name, Integer numberOfClubs, RealmList<Club> leagueClubList) {
        this.id = id;
        this.name = name;
        this.numberOfClubs = numberOfClubs;
        this.leagueClubList = leagueClubList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfClubs() {
        return numberOfClubs;
    }

    public void setNumberOfClubs(Integer numberOfClubs) {
        this.numberOfClubs = numberOfClubs;
    }

    public RealmList<Club> getLeagueClubList() {
        return leagueClubList;
    }

    public void setLeagueClubList(RealmList<Club> leagueClubList) {
        this.leagueClubList = leagueClubList;
    }
}
