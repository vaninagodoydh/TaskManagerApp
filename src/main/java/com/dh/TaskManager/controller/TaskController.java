package com.dh.TaskManager.controller;

import com.dh.TaskManager.dto.TaskRequestDTO;
import com.dh.TaskManager.dto.TaskRequestToUpdateDTO;
import com.dh.TaskManager.dto.TaskResponseDTO;
import com.dh.TaskManager.exception.NotFoundException;
import com.dh.TaskManager.service.ITaskService;
import com.dh.TaskManager.service.impl.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con las tareas.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final ITaskService taskService;

    /**
     * Constructor de la clase TaskController que realiza la inyección de dependencias del servicio de tareas.
     *
     * @param taskService La implementación concreta del servicio de tareas que se utilizará en el controlador.
     *                    Aunque se utiliza la interfaz ITaskService como atributo, se pasa la implementación
     *                    concreta del servicio al constructor, siguiendo el principio de inversión de dependencias.
     */
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     Crea una nueva tarea utilizando los datos proporcionados en el objeto TaskRequestDTO.
     *
     * @param taskDTO El objeto TaskRequestDTO que contiene los datos de la tarea a crear.
     * @return ResponseEntity<TaskResponseDTO> ResponseEntity que contiene el objeto TaskResponseDTO creado,
     *          con un estado HTTP 201 (CREATED) si la tarea se crea correctamente.
     */
    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@Valid @RequestBody TaskRequestDTO taskDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(taskDTO));
    }

    /**
     * Obtiene una tarea específica por su identificador.
     *
     * @param id El identificador único de la tarea.
     * @return ResponseEntity<TaskResponseDTO> Un ResponseEntity que contiene el objeto TaskResponseDTO correspondiente
     *         a la tarea solicitada, con un estado HTTP 200 (OK) si se encuentra la tarea, o estado HTTP 404 (NOT FOUND)
     *         si no se encuentra.
     * @throws NotFoundException Si no se encuentra ninguna tarea con el identificador proporcionado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    /**
     * Obtiene todas las tareas disponibles.
     *
     * @return ResponseEntity<List<TaskResponseDTO>> Un ResponseEntity que contiene una lista de TaskResponseDTO,
     *          con un estado HTTP 200 (OK) si se obtienen las tareas correctamente.
     */
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    /**
     * Actualiza una tarea existente utilizando los datos proporcionados en el objeto TaskRequestToUpdateDTO.
     *
     * @param taskRequestDTO El objeto TaskRequestToUpdateDTO que contiene los datos actualizados de la tarea.
     * @return ResponseEntity<TaskResponseDTO> Un ResponseEntity que contiene el objeto TaskResponseDTO actualizado,
     *          con un estado HTTP 200 (OK) si la tarea se actualiza correctamente.
     * @throws NotFoundException Si no se encuentra ninguna tarea con el identificador proporcionado.
     */
    @PutMapping
    public ResponseEntity<TaskResponseDTO> updateTask(@Valid @RequestBody TaskRequestToUpdateDTO taskRequestDTO) {
        return ResponseEntity.ok(taskService.updateTask(taskRequestDTO));
    }

    /**
     * Elimina una tarea específica por su identificador.
     *
     * @param id El identificador único de la tarea a eliminar.
     * @return ResponseEntity<Void> Un ResponseEntity sin contenido y con un estado HTTP 204 (NO CONTENT)
     *         si la tarea se elimina correctamente.
     * @throws NotFoundException Si no se encuentra ninguna tarea con el identificador proporcionado.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
