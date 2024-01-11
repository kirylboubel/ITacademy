package by.itacademy.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAdvice {
    @Pointcut("@annotation(by.itacademy.advice.annotation.ExecutionTime)")
    public void addExecution() {

    }

    @Around("addExecution()")
    public Object printResult(final ProceedingJoinPoint joinPoint) throws Throwable {
        final long startTime = System.nanoTime();

        final var result = joinPoint.proceed();

        final long endTime = System.nanoTime();
        System.out.println("execution time (ns) = " + (endTime - startTime));

        return result;
    }
}
