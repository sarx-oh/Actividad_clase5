package actividad5.demo.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import actividad5.demo.services.FirebaseService;

@RestController
public class TestDBController {
    private final FirebaseService firebaseService;

    public TestDBController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @GetMapping("/firebase-test")
    public String testFirebase() {

        firebaseService.guardarDato();
        return "Dato enviado a Firebase";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String, String> user) {
        String nombre = user.get("nombre");
        String email = user.get("email");
        String password = user.get("password");

        if (nombre == null || email == null || password == null ||
            nombre.isBlank() || email.isBlank() || password.isBlank()) {
            return "Todos los campos son obligatorios";
        }

        return firebaseService.registrarUsuario(nombre, email, password);
    }
}