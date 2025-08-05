package com.sqewes.ciphering.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;

import java.io.IOException;
import java.io.InputStream;

public class FirebaseConfig {

    @PostConstruct
    public void init() throws IOException {
        InputStream serviceAccount = getClass().getResourceAsStream("/firebase/serviceAccountKey.json");

        FirebaseOptions options = null;
        if (serviceAccount != null) {
            options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
        }

        if (FirebaseApp.getApps().isEmpty() && options != null) {
            FirebaseApp.initializeApp(options);
        }
    }

}
