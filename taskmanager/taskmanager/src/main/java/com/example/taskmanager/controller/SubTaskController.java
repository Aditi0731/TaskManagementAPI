package com.example.taskmanager.controller;

import com.example.taskmanager.model.SubTask;
import com.example.taskmanager.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subtasks")
public class SubTaskController {
    @Autowired
    private SubTaskService subTaskService;

    @PostMapping
    public ResponseEntity<SubTask> createSubTask(@RequestBody SubTask subTask) {
        return ResponseEntity.ok(subTaskService.createSubTask(subTask));
    }

    @GetMapping
    public ResponseEntity<List<SubTask>> getAllSubTasks() {
        return ResponseEntity.ok(subTaskService.getAllSubTasks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubTask> updateSubTask(@PathVariable Long id, @RequestBody SubTask subTaskDetails) {
        return ResponseEntity.ok(subTaskService.updateSubTask(id, subTaskDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubTask(@PathVariable Long id) {
        subTaskService.deleteSubTask(id);
        return ResponseEntity.noContent().build();
    }
}