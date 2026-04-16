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

    public Battle getBattle(String battleId) {
        try {
            Firestore db = getDB();

            DocumentSnapshot snapshot = db.collection("battle")
                    .document(battleId)
                    .get()
                    .get();

            if (snapshot.exists()) {
                return snapshot.toObject(Battle.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}