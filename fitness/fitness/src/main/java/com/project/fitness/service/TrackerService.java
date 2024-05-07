package com.project.fitness.service;

import com.project.fitness.dto.trackerRequest;
import com.project.fitness.model.Exercises;
import com.project.fitness.model.Meal;
import com.project.fitness.model.Tracker;
import com.project.fitness.model.User;
import com.project.fitness.repo.TrackerRepository;
import com.project.fitness.repo.UserRepository;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackerService {
    double totalCalories = 0;
    @Autowired
    private final TrackerRepository trackerRepository;
    @Autowired
    private final UserRepository userRepository;
    public TrackerService(TrackerRepository trackerRepository, UserRepository userRepository) {
        this.trackerRepository = trackerRepository;
        this.userRepository = userRepository;
    }

    public Tracker create(trackerRequest request) {
        User user = userRepository.findById(request.getUserid())
                                   .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Tracker tracker = Tracker.builder()
                                .date(request.getDate())
                                .time(request.getTime())
                                .user(user)
                                .build();

        return trackerRepository.save(tracker);
    }

    public void calculateAndSaveTotalCalories(User user) {
        

        for (Meal meal : user.getMeals()) {
            double mealCalories = Double.parseDouble(meal.getCalories());
            double mealQuantity = Double.parseDouble(meal.getQuantity());
            totalCalories += mealCalories * mealQuantity;
        }

        for (Exercises exercise : user.getExercises()) {
            double calPerRep = Double.parseDouble(exercise.getCalPerRep());
            double reputation = Double.parseDouble(exercise.getReputations());
            totalCalories -= calPerRep * reputation;
        }

       Set <Tracker> tracker = user.getTracker();
        if (tracker == null) {
        Tracker  newTracker = Tracker.builder()
                             .user(user)
                             .totalCalories(totalCalories)
                             .build();
        trackerRepository.save(newTracker);
        } 
    }
}
