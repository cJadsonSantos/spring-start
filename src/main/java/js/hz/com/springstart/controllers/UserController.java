package js.hz.com.springstart.controllers;

import js.hz.com.springstart.entities.User;
import js.hz.com.springstart.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository repository) {
        this.userRepository = repository;
    }

    @GetMapping
    public List<User> findAll(Model model) {
        var users = userRepository.findAll();

        model.addAttribute("users", users);

        return users;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElse(null);
    }

    @PostMapping
    public User insert(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping(value = "/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }
}
