package actividad5.demo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {

    public String guardarDato() {


        try {

            // obtener instancia de Firestore
            Firestore db = FirestoreClient.getFirestore();

            // datos a guardar
            Map<String, Object> data = new HashMap<>();
            data.put("mensaje", "Conexion exitosa con Firestore");
            data.put("estado", "ok");

            // guardar en colección
            db.collection("test")
                .document("doc1")
                .set(data);

            return "Datos guardados correctamente";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al guardar datos";
        }
    }

    public String registrarUsuario(String nombre, String email, String password) {
        try {
            Firestore db = FirestoreClient.getFirestore();

            Map<String, Object> userData = new HashMap<>();
            userData.put("nombre", nombre);
            userData.put("email", email);
            userData.put("password", password);

            db.collection("users")
                    .document(email)
                    .set(userData);

            return "Usuario registrado correctamente";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al registrar usuario";
        }
    }

}