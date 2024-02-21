package ru.plotter.homework05.service;

import ru.plotter.homework05.model.Task;
import ru.plotter.homework05.model.TaskStatus;
import ru.plotter.homework05.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        task.setCreationTime(LocalDateTime.now());
        if (task.getTaskStatus() == null) task.setTaskStatus(TaskStatus.NOT_STARTED);
        return taskRepository.save(task);
    }

    public List<Task> findByStatus(TaskStatus status) {
        return taskRepository.findByTaskStatus(status);
    }

    public Task updateTaskStatus(Long id, Task updatedTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTaskStatus(updatedTask.getTaskStatus());
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
