package com.dh.TaskManager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * Representa un objeto de transferencia de datos (DTO) para actualizar una tarea.
 */
@Getter
@Setter
public class TaskRequestToUpdateDTO {

    /**
     * El identificador único de la tarea.
     */
    private Long id;

    /**
     * El título de la tarea.
     */
    private String title;

    /**
     * La descripción de la tarea.
     */
    private String description;
}
