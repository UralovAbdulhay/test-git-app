package com.example.repository;

import com.example.entity.Count;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CounterRepository extends JpaRepository<Count,Long> {

    Optional<Count> findBySession(String session);
}
