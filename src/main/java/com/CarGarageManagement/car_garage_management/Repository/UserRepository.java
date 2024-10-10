package com.CarGarageManagement.car_garage_management.Repository;

import com.CarGarageManagement.car_garage_management.model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Repository;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

@Repository
public class UserRepository {

    private static final String COLLECTION_NAME = "users";

    public String saveUser(User user) throws InterruptedException, ExecutionException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> future = firestore.collection(COLLECTION_NAME).add(user);
        return future.get().getId();
    }

    public User getUserById(String userId) throws InterruptedException, ExecutionException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<com.google.cloud.firestore.DocumentSnapshot> future = firestore.collection(COLLECTION_NAME).document(userId).get();
        com.google.cloud.firestore.DocumentSnapshot document = future.get();

        if (document.exists()) {
            return document.toObject(User.class);
        } else {
            return null;
        }
    }

    public String deleteUser(String userId) {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = firestore.collection(COLLECTION_NAME).document(userId).delete();
        return "Deleted at: " + writeResult;
    }
}
