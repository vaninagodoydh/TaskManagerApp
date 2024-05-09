package com.dh.TaskManager.dto;

import lombok.*;

/**
 * Representa un objeto de transferencia de datos (DTO) que contiene la respuesta de una tarea.
 */
@Getter
@Setter
public class TaskResponseDTO {
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
