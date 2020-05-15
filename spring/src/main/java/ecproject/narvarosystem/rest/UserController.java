package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.UserRepository;
import ecproject.narvarosystem.config.MyUserDetailsService;
import ecproject.narvarosystem.entities.User;
import org.apache.catalina.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private Authenticator authManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @GetMapping
    public List<User> users(){
        return (List<User>) this.userRepository.findAll();
    }
    @GetMapping("{id}")
    public Iterable<User> userById(@PathVariable long id){
        return this.userRepository.findAllById(Collections.singleton(id));
    }
    @PostMapping
    public User addUser(@RequestBody User user) {
        user.setPassword(myUserDetailsService.getEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @GetMapping("/all")
    public String hello() {
        return "Hello Youtube";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedHello() {
        return "Secured Hello";
    }

    @GetMapping("/secured/alternate")
    public String alternate() {
        return "alternate";
    }

}
