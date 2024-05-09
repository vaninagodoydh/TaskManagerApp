package com.dh.TaskManager.dto;

import lombok.*;

/**
 * Representa un objeto de transferencia de datos (DTO) para representar una excepción.
 */
@Getter
@Setter
@AllArgsConstructor
public class ExceptionDTO {

    /**
     * El mensaje de la excepción.
     */
    private String message;

}
