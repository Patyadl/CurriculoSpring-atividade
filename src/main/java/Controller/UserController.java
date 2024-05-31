package Controller;


import Model.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User criarUser(@RequestBody User user) {
        return userService.criarUser(user);
    }

    @PutMapping("/{id}")
    public User atualizarUser(@PathVariable Long id, @RequestBody User userDetails) throws Exception {
        return userService.atualizarUser(id, userDetails);
    }


    @DeleteMapping("/{id}")
    public void deletarUser(@PathVariable Long id) {
        userService.deletarUser(id);
    }
}