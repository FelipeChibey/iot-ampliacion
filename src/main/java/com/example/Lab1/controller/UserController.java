package com.example.Lab1.controller;

import com.example.Lab1.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
  private List<User> users = new ArrayList<>();

  @PostMapping
  public User createUser(@RequestBody User user) {
    users.add(user);
    return user;
  }

  @GetMapping
  public List<User> getUsers() {
    return users;
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    return users.stream()
      .filter(user -> user.getId().equals(id))
      .findFirst()
      .orElse(null);
  }

  @PutMapping("/{id}")
  public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
    User user = users.stream()
      .filter(u -> u.getId().equals(id))
      .findFirst()
      .orElse(null);

    if (user != null) {
      user.setName(userDetails.getName());
    }

    return user;
  }

  @DeleteMapping("/{id}")
  public String deleteUser(@PathVariable Long id) {
    users.removeIf(user -> user.getId().equals(id));
    return "User with id " + id + " has been deleted";
  }
}
