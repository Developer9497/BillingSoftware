package com.billingsoftware.app.service;

import org.springframework.stereotype.Service;

import com.billingsoftware.app.entity.User;
import com.billingsoftware.app.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create or Update user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get users by shop
    public List<User> getUsersByShopId(Long shopId) {
        return userRepository.findByShopId(shopId);
    }

    // Get user by id
    public Optional<User> getUserById(Long uid) {
        return userRepository.findById(uid);
    }

    // Delete user
    public void deleteUser(Long uid) {
        userRepository.deleteById(uid);
    }
}
