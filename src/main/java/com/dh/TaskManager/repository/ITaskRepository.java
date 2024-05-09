package com.dh.TaskManager.repository;

import com.dh.TaskManager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Task.
 */
@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {
}
