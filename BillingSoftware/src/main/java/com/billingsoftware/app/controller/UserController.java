package com.billingsoftware.app.controller;

import org.springframework.web.bind.annotation.*;

import com.billingsoftware.app.entity.User;
import com.billingsoftware.app.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/shop/{shopId}")
    public List<User> getUsersByShop(@PathVariable Long shopId) {
        return userService.getUsersByShopId(shopId);
    }

    @GetMapping("/{uid}")
    public Optional<User> getUserById(@PathVariable Long uid) {
        return userService.getUserById(uid);
    }

    @PutMapping("/{uid}")
    public User updateUser(@PathVariable Long uid, @RequestBody User userDetails) {
        Optional<User> userOpt = userService.getUserById(uid);
        if(userOpt.isPresent()) {
            User user = userOpt.get();
            user.setUserName(userDetails.getUserName());
            user.setUserContact(userDetails.getUserContact());
            user.setUserGmail(userDetails.getUserGmail());
            user.setUserAddress(userDetails.getUserAddress());
            user.setUserStatus(userDetails.getUserStatus());
            user.setRole(userDetails.getRole());
            return userService.saveUser(user);
        }
        return null;
    }

    @DeleteMapping("/{uid}")
    public String deleteUser(@PathVariable Long uid) {
        userService.deleteUser(uid);
        return "User deleted with id: " + uid;
    }
}
