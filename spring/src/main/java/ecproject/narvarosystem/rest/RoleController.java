package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.RoleRepository;
import ecproject.narvarosystem.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;



    @GetMapping()
    public List<Role> roles(){
        return (List<Role>) this.roleRepository.findAll();
    }
    @GetMapping("{id}")
    public Iterable<Role> roleById(@PathVariable long id){
        return this.roleRepository.findAllById(Collections.singleton(id));
    }
}
