package com.dh.TaskManager.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa una tarea en el sistema.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {
    /**
     * El identificador único de la tarea.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
