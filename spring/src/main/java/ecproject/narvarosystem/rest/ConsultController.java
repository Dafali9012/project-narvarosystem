package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.ConsultRepository;
import ecproject.narvarosystem.entities.Consult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consult")
public class ConsultController {
    @Autowired
    private ConsultRepository consultRepository;

    @GetMapping
    public List<Consult> consults() { return (List<Consult>) this.consultRepository.findAll();}
}
