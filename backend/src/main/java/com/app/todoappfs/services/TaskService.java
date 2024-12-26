package com.app.todoappfs.services;

import com.app.todoappfs.models.Task;
import com.app.todoappfs.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        task.ifPresent(value -> taskRepository.deleteById(value.getId()));
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
            task.setCompleted(!task.isCompleted());
            taskRepository.save(task);
    }
}
