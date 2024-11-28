package com.example.taskmanager.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String status; // 0 for "TODO", 1 for "DONE"

    @ManyToOne
    private Task task;
}