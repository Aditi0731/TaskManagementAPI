package com.example.taskmanager.service;

import com.example.taskmanager.model.SubTask;
import com.example.taskmanager.repository.SubTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTaskService {
    @Autowired
    private SubTaskRepository subTaskRepository;

    public SubTask createSubTask(SubTask subTask) {
        return subTaskRepository.save(subTask);
    }

    public List<SubTask> getAllSubTasks() {
        return subTaskRepository.findAll();
    }

    public SubTask updateSubTask(Long id, SubTask subTaskDetails) {
        SubTask subTask = subTaskRepository.findById(id).orElseThrow(() -> new RuntimeException("SubTask not found"));
        subTask.setTitle(subTaskDetails.getTitle());
        subTask.setStatus(subTaskDetails.getStatus());
        return subTaskRepository.save(subTask);
    }

    public void deleteSubTask(Long id) {
        subTaskRepository.deleteById(id);
    }
}