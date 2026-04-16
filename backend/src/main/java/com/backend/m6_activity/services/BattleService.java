package com.backend.m6_activity.services;

import com.backend.m6_activity.models.Battle;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BattleService {

    @Autowired
    private FirebaseService firebaseService;

    public void attackBoss(String battleId, String type) {
        Firestore db = firebaseService.getDB();
        DocumentReference docRef = db.collection("battle").document(battleId);

        try {
            DocumentSnapshot snapshot = docRef.get().get();
            if (!snapshot.exists()) {
                System.out.println("battle doocument not found");
                return;
            }
            Battle battle = snapshot.toObject(Battle.class);

            int damage = 0;
            boolean hit = false;

            double roll = Math.random();

            switch (type.toLowerCase()) {
                case "green":
                    hit = roll < 0.9;
                    damage = 15;
                    break;
                case "water":
                    hit = roll < 0.5;
                    damage = 35;
                    break;
                case "red":
                    hit = roll < 0.3;
                    damage = 75;
                    break;
            }

            if (hit) {
                int newHp = battle.getBoss().getHp() - damage;
                battle.getBoss().setHp(Math.max(newHp, 0));
            }

            docRef.set(battle);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetBattle(String battleId) {
        Firestore db = firebaseService.getDB();
        DocumentReference docRef = db.collection("battle").document(battleId);

        try {
            DocumentSnapshot snapshot = docRef.get().get();
            Battle battle = snapshot.toObject(Battle.class);

            battle.getBoss().setHp(600);

            docRef.set(battle);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}