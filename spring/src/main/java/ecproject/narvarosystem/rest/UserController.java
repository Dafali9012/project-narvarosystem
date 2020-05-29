package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.UserRepository;
import ecproject.narvarosystem.entities.User;
import ecproject.narvarosystem.service.MyUserDetailsService;
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

    @GetMapping("/{id}")
    public Iterable<User> userById(@PathVariable int id){
        return userRepository.findAllById(Collections.singleton(id));
    }

    @GetMapping("/role/{id}")
    public Iterable<User> userByRoleId(@PathVariable int id){
        return userRepository.findAllByRoleId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        user.setPassword(myUserDetailsService.getEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id,@RequestBody User user) {
        User updatedUser = userRepository.findAllById(Collections.singleton(id)).get(0);
        if(user.getFirst_name()!=null)updatedUser.setFirst_name(user.getFirst_name());
        if(user.getLast_name()!=null)updatedUser.setLast_name(user.getLast_name());
        if(user.getPhone_number()!=null)updatedUser.setPhone_number(user.getPhone_number());
        if(user.getSsn()!=null)updatedUser.setSsn(user.getSsn());
        if(user.getEmail()!=null)updatedUser.setEmail(user.getEmail());
        if(user.getPassword()!=null)updatedUser.setPassword(user.getPassword());
        if(user.getRole_id()!=null)updatedUser.setRole_id(user.getRole_id());
        return userRepository.save(updatedUser);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin/all")
    public String securedHello() {
        return "Secured Hello Admin";
    }

    @GetMapping("/admin/alternate")
    public String alternate() {
        return "alternate";
    }

}
