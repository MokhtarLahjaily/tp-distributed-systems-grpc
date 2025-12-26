package app.grpc.controller;

import app.grpc.entity.Utilisateur;
import app.grpc.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UtilisateurRepository repository;

    @PostMapping("/login")
    public String login(@RequestBody Utilisateur user) {
        Utilisateur found = repository.findByUsername(user.getUsername());
        if (found != null && found.getPassword().equals(user.getPassword())) {
            return "SUCCESS: User ID " + found.getId();
        }
        return "FAILURE";
    }
}