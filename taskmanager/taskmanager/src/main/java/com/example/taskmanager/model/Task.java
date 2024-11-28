package com.example.taskmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate dueDate;
    private String priority; // e.g., "HIGH", "MEDIUM", "LOW"
    private String status; // "TODO", "DONE"

    @ManyToOne
    private User user;
}