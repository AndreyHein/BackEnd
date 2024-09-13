package de.ait.shop42.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPLogging {
    private final Logger logger = LogManager.getLogger();

    @Before("execution(* de.ait.shop42.product.service.ProductServiceImpl.*(..))")
    public void AOPExample(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("------------------- start {}", name);
    }
}
