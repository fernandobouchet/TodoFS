package com.app.todoappfs.repository;

import com.app.todoappfs.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
