package com.maq.challenge.config;

import com.maq.challenge.service.DinosaurService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class SchedulerConfig {

    private final DinosaurService dinosaurService;

    @Autowired
    public SchedulerConfig(DinosaurService dinosaurService) {
        this.dinosaurService = dinosaurService;
    }


    @Scheduled(cron = "0 0/10 * * * *") //todos los dias a la 1:00 AM
    public void performDinosaurStatusCheck() {
        log.info("Chequeando dinosaurios exitintos...");
        dinosaurService.checkDinosaurStatus();
    }

}
