package board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// SpringBoot에서는 @EnableAspectJAutoProxy 어노테이션을 추가하지 않아도 자동으로 AOP 설정을 활성화
@Aspect
@Slf4j
@Component      
public class LoggerAspect {
    @Pointcut("execution(* board..controller..*.*(..))" 
    						+ "|| execution(* board..service..*.*(..))" 
    						+  "|| execution(* board..repository..*.*(..))" 
    						+ "|| execution(* board..common..*.*(..))")
    private void loggerTarget() {
        
    }
    
    @Around("loggerTarget()")
    public Object logPrinter(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        
  
        
        log.debug(" >>> "  + " " + className + "." + methodName);
        return joinPoint.proceed();
    }
}


