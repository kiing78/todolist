package fr.home.todolist.service;

import fr.home.todolist.entity.Task;
import fr.home.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImp implements TaskService<Task>{
    @Autowired
    private TaskRepository taskRepository;

//    Add a task to database
    @Override
    public void addTask(Task task) {
       taskRepository.save(task);
    }

//    return a task's list
    @Override
    public List<Task> getTasks() {
        List<Task> listTask = new ArrayList<Task>();
        for(Task tas : taskRepository.findAll()){
            listTask.add(tas);
        }
        return listTask;
    }


}
