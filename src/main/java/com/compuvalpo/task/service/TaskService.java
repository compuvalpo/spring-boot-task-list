package com.compuvalpo.task.service;

import com.compuvalpo.task.exception.NotFoundException;
import com.compuvalpo.task.model.TaskModel;
import com.compuvalpo.task.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<TaskModel> findAll(){
        return taskRepository.findAll();
    }

    public TaskModel findById(Integer id){
        return taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Tarea no encontrada"));
    }

    public TaskModel create(TaskModel task){
        task.setFecha_creacion(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public TaskModel update(Integer id, TaskModel task){
        TaskModel taskBD = findById(id);

        taskBD.setNombre(task.getNombre());
        taskBD.setDescripcion(task.getDescripcion());
        taskBD.setEstado(task.getEstado());
        taskBD.setFecha_task(task.getFecha_task());

        return taskRepository.save(taskBD);
    }

    public TaskModel finalizar(Integer id){
        TaskModel taskBD = findById(id);

        taskBD.setEstado("Finalizada");

        return taskRepository.save(taskBD);
    }
    public void delete(Integer id){
        TaskModel taskBD = findById(id);

        taskRepository.delete(taskBD);
    }
}