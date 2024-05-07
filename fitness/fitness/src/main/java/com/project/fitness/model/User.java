package com.project.fitness.model;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String LastName;
    private int age;
    private double weight;
    private String email;
    private String password;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_meal" ,
                joinColumns = @JoinColumn (name = "user_id"),
                inverseJoinColumns = @JoinColumn(name ="meal_id") )
    private Set<Meal> meals;


    @ManyToMany(cascade =CascadeType.ALL)
    @JoinTable(name = "user_exercises" ,
                joinColumns = @JoinColumn(name ="user_id") ,
                inverseJoinColumns = @JoinColumn(name = "exercise_id")) 
    private Set<Exercises> exercises;
    

    @OneToMany(mappedBy = "user")
    private Set<Tracker> tracker;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_owner_id")
    private Gymowner gymowner;

}
