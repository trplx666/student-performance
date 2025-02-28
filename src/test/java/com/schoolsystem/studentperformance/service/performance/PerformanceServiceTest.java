package com.schoolsystem.studentperformance.service.performance;

import com.schoolsystem.studentperformance.model.performance.Performance;
import com.schoolsystem.studentperformance.repository.performance.PerformanceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PerformanceServiceTest {
    @Mock
    private PerformanceRepository performanceRepository;

    @InjectMocks
    private PerformanceService performanceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testGetStudentAverageGradeBySubject() {
        Performance p1 = new Performance(null, null, 5, 40, "Отлично выполненная кр");
        Performance p2 = new Performance(null, null, 3, 30, "Удовлетворительно выполненная проверочная работа");

        when(performanceRepository.findByStudentIdAndLessonSubjectId(1L, 2L))
                .thenReturn(List.of(p1, p2));

        Double result = performanceService.getStudentAverageGradeBySubject(1L, 2L);

        // Ожидаемое значение: (5×40 + 4×20 + 3×10) / (40+20+10) = 4.28
        assertEquals(4.14, result, 0.01);

        verify(performanceRepository, times(1))
                .findByStudentIdAndLessonSubjectId(1L, 2L);
    }
}