package com.backend.m6_activity.services;

import com.backend.m6_activity.models.Battle;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {

    public Firestore getDB() {
        return FirestoreClient.getFirestore();
    }

    public void listenToBattle(String battleId) {
        Firestore db = getDB();

        db.collection("battle")
          .document(battleId)
          .addSnapshotListener((snapshot, error) -> {

              if (error != null) {
                  error.printStackTrace();
                  return;
              }

              if (snapshot != null && snapshot.exists()) {
                  Battle battle = snapshot.toObject(Battle.class);

                  System.out.println("Boss HP: " + battle.getBoss().getHp());
              }
          });
    }
}