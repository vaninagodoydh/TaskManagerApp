package com.dh.TaskManager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * Representa un objeto de transferencia de datos (DTO) para una solicitud de tarea.
 */
@Getter
@Setter
public class TaskRequestDTO {
    /**
     * El título de la tarea.
     * No debe estar vacío.
     */
    @NotBlank(message = "The title cannot be empty.")
    private String title;

    /**
     * La descripción de la tarea.
     * No debe estar vacía.
     */
    @NotBlank(message = "The description cannot be empty.")
    private String description;
}
