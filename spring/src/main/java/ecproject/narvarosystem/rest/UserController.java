package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.UserRepository;
import ecproject.narvarosystem.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;



    @GetMapping()
    public List<User> users(){
        return (List<User>) this.userRepository.findAll();
    }
    @GetMapping("{id}")
    public Iterable<User> userById(@PathVariable long id){
        return this.userRepository.findAllById(Collections.singleton(id));
    }
   // @PostMapping
    //public User addUser(@RequestBody User user) {
     //   user.setPassword(myUserDetailsService.getEncoder().encode(user.getPassword()));
      //  return userRepository.save(user);
    //}
}
