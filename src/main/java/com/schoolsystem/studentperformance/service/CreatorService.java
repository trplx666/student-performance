package com.schoolsystem.studentperformance.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatorService {

    public <T> T createEntity(JpaRepository<T, Long> repository, T entity) {
        return repository.save(entity);
    }
}