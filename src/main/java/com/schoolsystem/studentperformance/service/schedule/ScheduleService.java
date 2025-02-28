package com.schoolsystem.studentperformance.service.schedule;

import com.schoolsystem.studentperformance.model.DTO.schedule.ScheduleDto;
import com.schoolsystem.studentperformance.repository.lesson.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private LessonRepository lessonRepository;

    public List<ScheduleDto> getSchedule(String groupName) {
        return lessonRepository.findScheduleByGroupName(groupName);
    }
}
