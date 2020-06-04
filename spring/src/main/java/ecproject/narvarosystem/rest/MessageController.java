package ecproject.narvarosystem.rest;

import ecproject.narvarosystem.Repository.MessageRepository;
import ecproject.narvarosystem.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public Message message(@RequestBody Message message) {
        return messageRepository.save(message);
    }
    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageRepository.deleteById(id);
    }
}
