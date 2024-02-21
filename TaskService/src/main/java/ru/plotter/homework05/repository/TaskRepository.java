package ru.plotter.homework05.repository;

import ru.plotter.homework05.model.Task;
import ru.plotter.homework05.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTaskStatus(TaskStatus taskStatus);
}
