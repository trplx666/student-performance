package com.schoolsystem.studentperformance.service.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;


@Service
public class EntityService {

    public <T> T createEntity(JpaRepository<T, Long> repository, T entity) {
        return repository.save(entity);
    }

    public <T, ID> T findEntityByIdOrThrow(JpaRepository<T, ID> repository, ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ошибка. Entity с id = " + id + "не найден!"));
    }

    public <T> void updateEntityValue(T newValue, Consumer<T> setter) {
        Optional.ofNullable(newValue).ifPresent(setter);
    }
}
