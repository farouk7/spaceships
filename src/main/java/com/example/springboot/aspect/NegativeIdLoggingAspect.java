package com.example.springboot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NegativeIdLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(NegativeIdLoggingAspect.class);

    // Intercepta los métodos con @GetMapping o cualquier otro tipo de método que reciba un 'id' negativo
    @Before("execution(* com.example.springboot.controller.SpaceShipController.*(..)) && args(id,..)")
    public void logNegativeIdRequest(Long id) {
        if (id != null && id < 0) {
            logger.warn("Intento de acceso a una nave con un id negativo: {}", id);
        }
    }
}
