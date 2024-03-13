package dio.web.api.controller;

import dio.web.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dio.web.api.model.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public User getOneUserById(@PathVariable("id") Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping("/username/{username}")
    public User getOneUserByUsername(@PathVariable("username") String username) {
        return userRepository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }

    @PostMapping()
    public void postUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
