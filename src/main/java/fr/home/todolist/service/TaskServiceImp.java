package fr.home.todolist.service;

import fr.home.todolist.entity.Task;
import fr.home.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImp implements TaskService<Task>{
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public void addTask(Task task) {
       // System.out.println("test service "+task.getTaskName());
       taskRepository.save(task);

    }
}
