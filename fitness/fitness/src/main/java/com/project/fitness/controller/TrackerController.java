package com.project.fitness.controller;

import com.project.fitness.model.User;
import com.project.fitness.service.TrackerService;
import com.project.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class TrackerController {
    @Autowired
    private final TrackerService trackerService;
    @Autowired
    private final UserService userService;

    public TrackerController(TrackerService trackerService, UserService userService) {
        this.trackerService = trackerService;
        this.userService = userService;
    }

    @PostMapping("/{userId}/calculateTotalCalories")
    public ResponseEntity<String> calculateAndSaveTotalCalories(@PathVariable int userId) {
        // Fetch user from the database
        User user = userService.getUserById(userId);
        if (user == null) {
            // Handle user not found scenario
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        trackerService.calculateAndSaveTotalCalories(user);
        
        return ResponseEntity.ok("Total calories calculated and saved successfully for user with ID: " + userId);
    }
}


    