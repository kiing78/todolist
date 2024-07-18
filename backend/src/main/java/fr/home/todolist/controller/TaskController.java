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
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<?> listTasks(){
        if(taskService.getTasks().size()==0){
            return ResponseEntity.status(HttpStatus.OK).body("Aucune tache");
        }
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTasks());
    }



//    @PostMapping("/addTask")
//    public String createTask(@ModelAttribute("taskName")Task task, BindingResult result, ModelMap model){
//        if(result.hasErrors()){
//            return "error";
//        }
//        //on lie le nom du champ du formulaire à l'attribut de la classe Task
//       model.addAttribute("name", task.getTaskName());
//       return "good";
//    }
    @PostMapping("/new")
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
        //System.out.println("test controller "+task.getTaskName());
        taskService.addTask(task);
        return  ResponseEntity.status(HttpStatus.CREATED).body(task);

    }

}
