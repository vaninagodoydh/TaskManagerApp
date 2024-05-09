package com.dh.TaskManager.service;

import com.dh.TaskManager.dto.TaskRequestDTO;
import com.dh.TaskManager.dto.TaskRequestToUpdateDTO;
import com.dh.TaskManager.dto.TaskResponseDTO;
import com.dh.TaskManager.entity.Task;

import java.util.List;

/**
 * Interfaz que define los métodos para realizar operaciones relacionadas con las tareas.
 */
public interface ITaskService {

    /**
     * Crea una nueva tarea utilizando la información proporcionada en el objeto TaskRequestDTO.
     *
     * @param taskDTO Objeto TaskRequestDTO que contiene la información de la tarea a crear.
     * @return Objeto TaskResponseDTO que representa la tarea creada.
     */
    TaskResponseDTO createTask(TaskRequestDTO taskDTO);

    /**
     * Obtiene una tarea por su identificador único.
     *
     * @param id Identificador único de la tarea a buscar.
     * @return Objeto TaskResponseDTO que representa la tarea encontrada.
     */
    TaskResponseDTO getTaskById(Long id);

    /**
     * Obtiene todas las tareas disponibles.
     *
     * @return Lista de objetos TaskResponseDTO que representan todas las tareas disponibles.
     */
    List<TaskResponseDTO> getAllTasks();

    /**
     * Actualiza una tarea existente utilizando la información proporcionada en el objeto TaskRequestToUpdateDTO.
     *
     * @param taskRequestDTO Objeto TaskRequestToUpdateDTO que contiene la información actualizada de la tarea.
     * @return Objeto TaskResponseDTO que representa la tarea actualizada.
     */
    TaskResponseDTO updateTask(TaskRequestToUpdateDTO taskRequestDTO);

    /**
     * Elimina una tarea por su identificador único.
     *
     * @param id Identificador único de la tarea a eliminar.
     */
    void deleteTaskById(Long id);
}
