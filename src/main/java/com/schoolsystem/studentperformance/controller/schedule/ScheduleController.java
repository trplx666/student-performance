package com.schoolsystem.studentperformance.controller.schedule;

import com.schoolsystem.studentperformance.model.DTO.schedule.ScheduleDto;
import com.schoolsystem.studentperformance.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController()
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getSchedule(@PathVariable String groupName) {
        List<ScheduleDto> schedule = scheduleService.getSchedule(groupName);
        return ResponseEntity.ok(schedule);
    }
}
