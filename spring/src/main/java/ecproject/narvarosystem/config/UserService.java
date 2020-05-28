package ecproject.narvarosystem.config;

import ecproject.narvarosystem.Repository.UserRepository;
import ecproject.narvarosystem.entities.User;
import ecproject.narvarosystem.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    @Autowired

    private UserRepository userRepository;

    @Autowired

    private MyUserDetailsService myUserDetailsService;


    public User findCurrentUser() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByEmail(email);

    }


    public User registerUser(User user) {

        return myUserDetailsService.addUser(user.getEmail(), user.getPassword());

    }

}