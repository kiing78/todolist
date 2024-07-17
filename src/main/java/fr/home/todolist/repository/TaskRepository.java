package fr.home.todolist.repository;

import fr.home.todolist.entity.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    @Transactional
    @Modifying
    @Query(value="INSERT INTO TASK (task_name)\n"+
    "VALUES (:name)",nativeQuery = true)
    public void addTask(@Param("name")String nameTask);
}
