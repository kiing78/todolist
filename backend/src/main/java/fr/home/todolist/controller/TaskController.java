package fr.home.todolist.controller;

import fr.home.todolist.entity.Task;
import fr.home.todolist.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;
//   Get: give a task's list
    @GetMapping(path="/tasks")
    public ResponseEntity<?> listTasks(){
        if(taskService.getTasks().size()==0){
            return ResponseEntity.status(HttpStatus.OK).body("Aucune tache");
        }
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTasks());
    }

//  Post:   Add a task to database
    @PostMapping(path="/new")
//    @Valid : permet d'activer la validation des contraintes dans l'entité Task
//    BindingResult : permet de capturer les errors
//    dans ResponseEntity, le "?" signifie que la réponse peut contenir un corps de n'importe quel type (String, int,
//    etc...)
    public ResponseEntity<?> newTask(@Valid @RequestBody Task task, BindingResult result){
        if(result.hasErrors()){
//            on créer une liste clé valeur qui seront tous les 2 des chaines de caractere
            Map<String, String> errors = new HashMap<>();
//            on parcours les éléments de result
            for (FieldError error : result.getFieldErrors()){
//                //on met dans la liste errors, les clé et valeurs (error.getField et error.getDefaultMessage)
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        taskService.addTask(task);
        return  ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

//    Delete a task in database
//    @PathVariable : permet de récupérer l'argument dans l'URI, il faut que le nom du parametre de la methode soit
//    écrit de la même façon que l'argument en URI (ici c'est id)
    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable long id){
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).body("la tache a été supprimé");
    }
}
