package com.billingsoftware.app.jwtconfigration;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billingsoftware.app.entity.User;
import com.billingsoftware.app.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository repo, PasswordEncoder encoder, JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setUserRegisterDate(LocalDate.now());
        user.setUserStatus("Active");
        return repo.save(user);
    }

//    @PostMapping("/login")
//    public Map<String, String> login(@RequestBody Map<String, String> req) {
//        // Use "userGmail" for consistency with your entity
//        String gmail = req.get("userGmail");
//        String password = req.get("password");
//
//        var user = repo.findByUserGmail(gmail)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        if (!encoder.matches(password, user.getPassword())) {
//            throw new RuntimeException("Invalid credentials");
//        }
//
//        String token = jwtUtil.generateToken(user.getUserGmail(), user.getRole());
//        return Map.of("token", token);
//    }
//    @PostMapping("/login")
//    public Map<String, Object> login(@RequestBody Map<String, String> req) {
//        String gmail = req.get("userGmail");
//        String password = req.get("password");
//
//        var user = repo.findByUserGmail(gmail)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        if (!encoder.matches(password, user.getPassword())) {
//            throw new RuntimeException("Invalid credentials");
//        }
//
//        // Generate JWT token
//        String token = jwtUtil.generateToken(user.getUserGmail(), user.getRole());
//
//        // Prepare response
//        Map<String, Object> response = new HashMap<>();
//        response.put("token", token);
//
//        // User details
//        Map<String, Object> userDetails = new HashMap<>();
//        userDetails.put("uid", user.getUid());
//        userDetails.put("userName", user.getUserName());
//        userDetails.put("userGmail", user.getUserGmail());
//        userDetails.put("userContact", user.getUserContact());
//        userDetails.put("userAddress", user.getUserAddress());
//        userDetails.put("role", user.getRole());
//        userDetails.put("userStatus", user.getUserStatus());
//        userDetails.put("userRegisterDate", user.getUserRegisterDate());
//
//        // Shop details
//        Map<String, Object> shopDetails = new HashMap<>();
//        shopDetails.put("shopId", user.getShop().getShopId());
//        shopDetails.put("shopName", user.getShop().getShopName());
//        shopDetails.put("shopAddress", user.getShop().getShopAddress());
//        shopDetails.put("shopContact", user.getShop().getShopContact());
//
//        userDetails.put("shop", shopDetails);
//
//        response.put("user", userDetails);
//
//        return response;
//    }
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> req, HttpSession session) {
        String gmail = req.get("userGmail");
        String password = req.get("password");

        var user = repo.findByUserGmail(gmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Store user in session
        session.setAttribute("user", user);

        // Return success response
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("userName", user.getUserName());
        return response;
    }
    @GetMapping("/print-all-users")
    public void printAllUsers() {

        List<User> users = repo.findAll();

        System.out.println("----- All Users From Database -----");
        for (User u : users) {
            System.out.println("Username: " + u.getUserName());
            System.out.println("Password: " + u.getPassword());
            System.out.println("----------------------------");
        }
    }


}
