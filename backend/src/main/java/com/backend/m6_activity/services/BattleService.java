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

    public void attackBoss(String battleId) {

        Firestore db = firebaseService.getDB();
        DocumentReference docRef = db.collection("battle").document(battleId);

        try {
            DocumentSnapshot snapshot = docRef.get().get();

            if (!snapshot.exists()) {
                System.out.println("battle doocument not found");
                return;
            }

            Battle battle = snapshot.toObject(Battle.class);

            System.out.println("Current HP: " + battle.getBoss().getHp());

            int currentHp = battle.getBoss().getHp();
            battle.getBoss().setHp(currentHp - 10);

            docRef.set(battle);

            System.out.println("New HP: " + battle.getBoss().getHp());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}