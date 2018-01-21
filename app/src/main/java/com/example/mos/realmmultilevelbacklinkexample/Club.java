package com.example.mos.realmmultilevelbacklinkexample;

import io.realm.RealmModel;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Mark O'Sullivan on 20th January 2018.
 */
@RealmClass
public class Club implements RealmModel {

    @PrimaryKey
    private String id;
    private String name;
    private Integer yearFounded;
    private Manager manager;
    @LinkingObjects("leagueClubList")
    private final RealmResults<League> clubsLeague = null;

    public Club() {}

    public Club(String id, String name, Integer yearFounded, Manager manager) {
        this.id = id;
        this.name = name;
        this.yearFounded = yearFounded;
        this.manager = manager;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(Integer yearFounded) {
        this.yearFounded = yearFounded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
