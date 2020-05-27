package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.RoleRepository;
import ecproject.narvarosystem.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public List<Role> roleById(@PathVariable int id){
        return this.roleRepository.findAllById(Collections.singleton(id));
    }

    @PostMapping
    public Role addRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @PutMapping("/{id}")
    public Role updateRole(@PathVariable int id, @RequestBody Role role) {
        Role updatedRole = roleRepository.findAllById(Collections.singleton(id)).get(0);
        updatedRole.setName(role.getName());
        return roleRepository.save(updatedRole);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable int id) {
        roleRepository.deleteById(id);
    }
}
