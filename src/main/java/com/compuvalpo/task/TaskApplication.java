package com.compuvalpo.task;

import com.compuvalpo.task.model.TaskModel;
import com.compuvalpo.task.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(TaskRepository taskRepository){
		return args -> {
			List<TaskModel> tasks = Arrays.asList(
				new TaskModel("Responder Email", "Responder los Email pendientes", "Pendiente", LocalDateTime.now()),
				new TaskModel("Revisar sistema de Tareas", "Revisar sistema de Tareas", "Pendiente", LocalDateTime.now()),
				new TaskModel("Revisar BUG", "Encontrar ese BUG en el sistema", "En Progreso", LocalDateTime.now()),
				new TaskModel("Repara Bug", "Reparar ese BUG en el sistema", "Pendiente", LocalDateTime.now()),
				new TaskModel("Actualizar Producción", "Actualizar Producción", "Finalizada", LocalDateTime.now())
			);

			taskRepository.saveAll(tasks);
		};
	}

}
