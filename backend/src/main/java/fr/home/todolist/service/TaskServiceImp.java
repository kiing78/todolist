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
    @Override
    public void addTask(Task task) {
       // System.out.println("test service "+task.getTaskName());
       taskRepository.save(task);

    }

    @Override
    public List<Task> getTasks() {
//      on met les éléments dans une list
        List<Task> listTask = new ArrayList<Task>();
        for(Task tas : taskRepository.findAll()){
            listTask.add(tas);
        }

        return listTask;
    }


}
