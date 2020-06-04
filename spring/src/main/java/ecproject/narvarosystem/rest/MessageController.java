package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.MessageRepository;
import ecproject.narvarosystem.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public List<Message> messages(){
        return (List<Message>) this.messageRepository.findAll();
    }
    @GetMapping("{id}")
    public Iterable<Message> messages(@PathVariable int id){
        return messageRepository.findAllById(Collections.singleton(id));
    }

    @PostMapping
    public Message message(@RequestBody Message message) {
        return messageRepository.save(message);
    }
    @PutMapping("{id}")
    public Message  updateMessage(@PathVariable int id, @RequestBody Message message ) {
        Message toUpdate = messageRepository.findAllById((Collections.singleton(id))).get(0);
        if (message.getSeen() != null)toUpdate.setSeen(message.getSeen());

        return messageRepository.save(toUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable int id) {
        messageRepository.deleteById(id);
    }
}
