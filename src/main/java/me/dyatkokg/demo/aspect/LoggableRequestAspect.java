package me.dyatkokg.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Aspect
@Component
public class LoggableRequestAspect {

    @Around("@annotation(me.dyatkokg.demo.aspect.LoggableRequest)")
    public Object logRequestResponse(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info("#### Method: {}, requestURL: {}, body: {}", request.getMethod(), request.getRequestURI(), proceedingJoinPoint.getArgs());
        Object value = proceedingJoinPoint.proceed();
        log.info("Request result: {}", value);
        return value;
    }


}
