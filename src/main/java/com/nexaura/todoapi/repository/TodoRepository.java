package com.nexaura.todoapi.repository;

import com.nexaura.todoapi.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Spring Data JPA automatically provides methods like findAll(),
    // findById(), save(), deleteById()
}
