package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.ECpersonnelRepository;
import ecproject.narvarosystem.entities.ECpersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ecpersonnel")
public class EcpersonnelController {
    @Autowired
    private ECpersonnelRepository eCpersonnelRepository;

    @GetMapping
    public List<ECpersonnel> eCpersonnels(){return (List<ECpersonnel>) this.eCpersonnelRepository.findAll();}


}
