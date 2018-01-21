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
public class Manager implements RealmModel {

    @PrimaryKey
    private String id;
    private String name;
    private Integer age;
    @LinkingObjects("manager")
    private final RealmResults<Club> managersClub = null;

    public Manager() {
    }

    public Manager(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", clubRealmResults=" + managersClub +
                '}';
    }
}
