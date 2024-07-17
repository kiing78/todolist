package fr.home.todolist.service;

import fr.home.todolist.entity.Task;

public interface TaskService<T> {
    public void addTask(T name);
}
