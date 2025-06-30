package com.maq.challenge;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class Startup implements ApplicationRunner {

    private static final Logger LOG = LoggerFactory.getLogger(Startup.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("##################################");
        LOG.info("# Inicializo                 ... #");
        LOG.info("##################################");

    }

}
