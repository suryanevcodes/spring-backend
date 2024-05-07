package com.project.fitness.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gymowner implements users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String gymname;
    private String ownerName;
    private String location;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "gymowner" ,cascade = CascadeType.ALL)
    private Set<User> users;

}
