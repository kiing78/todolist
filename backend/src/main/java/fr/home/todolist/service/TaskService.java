package fr.home.todolist.service;

import fr.home.todolist.entity.Task;

import java.util.List;

public interface TaskService<T> {
    public void addTask(T name);
    public List<T> getTasks();
}
