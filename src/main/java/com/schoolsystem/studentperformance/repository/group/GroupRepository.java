package com.schoolsystem.studentperformance.repository.group;

import com.schoolsystem.studentperformance.model.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
