package com.CarGarageManagement.car_garage_management.service;

import com.CarGarageManagement.car_garage_management.Repository.UserRepository;
import com.CarGarageManagement.car_garage_management.model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String saveUser(User user) throws InterruptedException, ExecutionException {
        return userRepository.saveUser(user);
    }

    public User getUserById(String userId) throws InterruptedException, ExecutionException {
        return userRepository.getUserById(userId);
    }

    public String deleteUser(String userId) {
        return userRepository.deleteUser(userId);
    }
}
