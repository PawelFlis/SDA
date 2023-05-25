package com.example.SDA.scheduler;

import com.example.SDA.tour.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduledTask {

    private final TourService tourService;

    @Scheduled(fixedRate = 250000, initialDelay = 100000)
    public void tourTasks(){
        tourService.deactiveExpiredTours();
    }
}
