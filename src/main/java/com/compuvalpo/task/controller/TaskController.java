package com.compuvalpo.task.controller;

import com.compuvalpo.task.model.TaskModel;
import com.compuvalpo.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
@CrossOrigin
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @GetMapping
    public List<TaskModel> list(){
        return taskService.findAll();
    }
    @GetMapping("{id}")
    public TaskModel get(@PathVariable Integer id){
        return taskService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskModel create(@Validated @RequestBody TaskModel task){
        return taskService.create(task);
    }

    @PutMapping("{id}")
    public TaskModel update(@PathVariable Integer id,@Validated @RequestBody TaskModel task){
        return taskService.update(id,task);
    }

    @PutMapping(value = "finalizar/{id}")
    public TaskModel finalizar(@PathVariable Integer id){
        return taskService.finalizar(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        taskService.delete(id);
    }
}
