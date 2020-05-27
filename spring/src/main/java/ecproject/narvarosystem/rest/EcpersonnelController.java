package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.ECpersonnelRepository;
import ecproject.narvarosystem.entities.ECpersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/personnel")
public class EcpersonnelController {
    @Autowired
    private ECpersonnelRepository eCpersonnelRepository;

    @GetMapping
    public List<ECpersonnel> eCpersonnel() {
        return eCpersonnelRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<ECpersonnel> eCpersonnelById(@PathVariable int id) {
        return eCpersonnelRepository.findAllById(Collections.singleton(id));
    }

    @PostMapping
    public ECpersonnel addEcPersonnel(@RequestBody ECpersonnel eCpersonnel) {
        return eCpersonnelRepository.save(eCpersonnel);
    }

    @DeleteMapping("/{id}")
    public void deleteEcPersonnel(@PathVariable int id) {
        eCpersonnelRepository.deleteById(id);
    }
}
