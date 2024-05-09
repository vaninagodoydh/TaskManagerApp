package com.dh.TaskManager.exception;

/**
 * Excepción lanzada cuando una entidad no se encuentra en el sistema.
 */
public class NotFoundException extends RuntimeException {

    /**
     * Crea una nueva instancia de NotFoundException con el mensaje especificado.
     *
     * @param message El mensaje que describe la excepción.
     */
    public NotFoundException(String message) {
        super(message);
    }
}
