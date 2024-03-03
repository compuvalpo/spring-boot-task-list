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
				new TaskModel("Revisar BUG", "Encontrar ese esquivo BUG en el sistema UNO", "En Progreso", "04/03/2024 08:10"),
				new TaskModel("Repara Bug", "Reparar ese BUG en el sistema", "Pendiente", "04/03/2024 16:10"),
				new TaskModel("Actualizar Producción", "Actualizar Producción", "Finalizada", "05/03/2024 12:00")
			);

			taskRepository.saveAll(tasks);
		};
	}

}
