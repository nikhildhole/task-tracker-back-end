package com.tasktracker.tasktracker.repository;

import com.tasktracker.tasktracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}