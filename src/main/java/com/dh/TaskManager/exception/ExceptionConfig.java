package com.dh.TaskManager.exception;

import com.dh.TaskManager.dto.ExceptionDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

/**
 * Manejador global de excepciones que proporciona el manejo centralizado de excepciones lanzadas por controladores
 * y otros componentes en toda la aplicación.
 */
@ControllerAdvice
public class ExceptionConfig {

    /**
     * Maneja las excepciones de tipo NotFoundException, devolviendo un ResponseEntity con un objeto ExceptionDTO
     * que contiene el mensaje de error correspondiente y un estado HTTP 404 (NOT FOUND).
     *
     * @param e La excepción NotFoundException que se está manejando.
     * @return ResponseEntity<?> ResponseEntity que contiene un objeto ExceptionDTO con el mensaje de error
     *         y un estado HTTP 404 (NOT FOUND).
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> ExceptionHandler(NotFoundException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja las excepciones de tipo MethodArgumentNotValidException, que ocurren cuando falla la validación de los argumentos de un método,
     * como en el caso de parámetros de método anotados con @Valid.
     *      *
     * Este método extrae los mensajes de error de validación de los errores de campo obtenidos de la excepción,
     * filtra los mensajes de error que no son nulos y devuelve el primer mensaje de error encontrado. Si no se encuentra ningún mensaje de error,
     * devuelve un mensaje de error genérico "Validation failed".
     *      *
     * @param e La excepción MethodArgumentNotValidException que se está manejando.
     * @return ResponseEntity<?> Un ResponseEntity que contiene un objeto ExceptionDTO con el mensaje de error obtenido de la validación,
     *         junto con un estado HTTP 400 (BAD REQUEST).
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException e){

        // Extrae los mensajes de error de validación de los errores de campo obtenidos de la excepción.
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getBindingResult().getFieldErrors().stream()

                // Mapea los mensajes de error de campo a sus mensajes predeterminados.
                .map(DefaultMessageSourceResolvable::getDefaultMessage)

                // Filtra los mensajes de error que no son nulos.
                .filter(Objects::nonNull)

                // Obtiene el primer mensaje de error encontrado. Si no se encuentra ninguno, devuelve un mensaje de error genérico.
                .findFirst()
                .orElse("Validation failed"));

        // Devuelve un ResponseEntity que contiene un objeto ExceptionDTO con el mensaje de error obtenido de la validación,
        // junto con un estado HTTP 400 (BAD REQUEST).
        return new ResponseEntity<>(exceptionDto,HttpStatus.BAD_REQUEST);
    }


}
