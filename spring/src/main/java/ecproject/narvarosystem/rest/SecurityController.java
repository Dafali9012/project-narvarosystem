package ecproject.narvarosystem.rest;


import ecproject.narvarosystem.Repository.UserRepository;
import ecproject.narvarosystem.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class SecurityController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login/name")
    public User user(Principal principal) {
        User u = userRepository.findByEmail(principal.getName());
        System.out.println(u);
        return u;
    }
}