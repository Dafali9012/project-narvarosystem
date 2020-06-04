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
//        if (message.getDate() != null)toUpdate.setDate(message.getDate());
//        if (message.getMessage() != null)toUpdate.setMessage(message.getMessage());
//        if (message.getSubject() != null)toUpdate.setSubject(message.getSubject());
//        if (message.getSender_id() != -1)toUpdate.setSender_id(message.getSender_id());
//        if (message.getReceiver_id() != -1)toUpdate.setReceiver_id(message.getReceiver_id());


        return messageRepository.save(toUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable int id) {
        messageRepository.deleteById(id);
    }
}
