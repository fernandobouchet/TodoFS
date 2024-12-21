package com.app.todoappfs.services;

import com.app.todoappfs.models.Task;
import com.app.todoappfs.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task newTask = new Task();
        newTask.setTitle(title);
        newTask.setCompleted(false);
        taskRepository.save(newTask);
    }
}
