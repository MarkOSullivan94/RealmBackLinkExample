package com.example.mos.realmmultilevelbacklinkexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);
        //setupRealmDB();
        queryPremierLeagueManagers();
        queryChelseaManager();
    }

    private void setupRealmDB() {
        Realm realm = Realm.getDefaultInstance();
        Manager manager1 = new Manager("1", "Antonio Conte", 48);
        Manager manager2 = new Manager("2", "Arsene Wenger", 68);
        Manager manager3 = new Manager("3", "David Moyes", 54);
        Club club1 = new Club("1", "Chelsea Football Club", 1905, manager1);
        Club club2 = new Club("2", "Arsenal Football Club", 1886, manager2);
        Club club3 = new Club("3", "Sunderland Association Football Club",1879,
                manager3);
        RealmList<Club> clubsList = new RealmList<>();
        clubsList.add(club1);
        clubsList.add(club2);
        clubsList.add(club3);
        final League league = new League("1", "Premier League", 20, clubsList);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(league);
            }
        });

    }

    // find all the Premier League managers
    private void queryPremierLeagueManagers() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Manager> realmResults = realm.where(Manager.class)
                .equalTo("managersClub.clubsLeague.name", "Premier League")
                .findAll();
        System.out.println("Amount of Premier League managers in Realm DB: " + realmResults.size());
        for (Manager manager : realmResults) {
            System.out.println(manager.toString());
        }
    }

    // find the manager of Chelsea
    private void queryChelseaManager() {
        Realm realm = Realm.getDefaultInstance();
        Manager chelseaManager = realm.where(Manager.class)
                .equalTo("managersClub.clubsLeague.name", "Premier League")
                .equalTo("managersClub.name", "Chelsea Football Club")
                .findFirst();
        System.out.println("Chelsea Manager");
        System.out.println(chelseaManager.toString());
    }
}
