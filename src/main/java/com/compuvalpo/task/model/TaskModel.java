package com.compuvalpo.task.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.format.DateTimeFormatter;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table (name="task")
@Getter
@Setter
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Debe agregar el nombre.")
    @NotBlank(message = "El campo nombre no puede estar vacio.")
    private String nombre;
    private String descripcion;
    private String estado;
    private String fecha_task;
    private LocalDateTime fecha_creacion;

    public TaskModel() {    }

    public TaskModel(String nombre, String descripcion, String estado, String fecha_task) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha_task = fecha_task;
        this.fecha_creacion = LocalDateTime.now(ZoneId.of("America/Argentina/Buenos_Aires"));
    }
}
