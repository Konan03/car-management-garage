package com.CarGarageManagement.car_garage_management.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ConnectionController {

    @GetMapping("/connection")
    public String testConnection() {
        Firestore firestore = FirestoreClient.getFirestore();

        // Verificar si Firestore está inicializado
        if (firestore != null) {
            return "Conexión exitosa a Firebase.";
        } else {
            return "Error: No se pudo conectar a Firebase.";
        }
    }
}
