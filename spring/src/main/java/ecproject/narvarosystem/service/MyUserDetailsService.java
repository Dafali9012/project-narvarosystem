package ecproject.narvarosystem.service;

import ecproject.narvarosystem.Repository.UserRepository;
import ecproject.narvarosystem.entities.CustomUserDetails;
import ecproject.narvarosystem.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public BCryptPasswordEncoder getEncoder() { return encoder; }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUsers = userRepository.findByName(name);
        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers
                .map(CustomUserDetails::new).get();
        }
//        User user = userRepository.findByName(name);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found by name: " + name);
//        }
//        return toUserDetails(user);
//    }
//    public User addUser(String name, String password){
//
//        User user = new User(name, encoder.encode(password));
//
//        try {
//
//            return userRepository.save(user);
//
//        } catch (Exception ex) {
//
//            ex.printStackTrace();
//
//        }
//
//        return null;
//
//    }
//
//    private UserDetails toUserDetails(User user) {
//        // If you have a User entity you have to
//        // use the userdetails User for this to work
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getName())
//                .password(user.getPassword())
//                .roles("USER").build();
//    }

}