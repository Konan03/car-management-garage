package com.CarGarageManagement.car_garage_management.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initialize(){
        try{
            // Carga el archivo de credenciales
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("firebase/firebase-service-account.json");

            if (serviceAccount == null) {
                throw new RuntimeException("Archivo de credenciales de Firebase no encontrado.");
            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://car-garage-management.firebaseio.com")
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        }catch (Exception e){
            throw new RuntimeException("Error al inicializar Firebase", e);
        }

    }
}
