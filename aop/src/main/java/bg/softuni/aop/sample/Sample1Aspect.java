package bg.softuni.aop.sample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@ConditionalOnProperty(
        value = "sample1.enabled",
        havingValue = "true"
)
public class Sample1Aspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sample1Aspect.class);

    @Pointcut("execution(* bg.softuni.aop.IncredibleMachine.*(..))")
    void onAllIncredibleMachineMethods(){}

    @Pointcut("execution(* bg.softuni.aop.IncredibleMachine.echo(..))")
    void onEchoCalled(){}

    @Before("onAllIncredibleMachineMethods()")
    public void beforeEachMethod(JoinPoint jp){
        LOGGER.info("Before calling method {} with arguments {}",
                jp.getSignature(),
                Arrays.asList(jp.getArgs()));
    }

    @AfterThrowing
            (pointcut = "execution(* bg.softuni.aop.IncredibleMachine.boom(..))",
            throwing = "error")
    public void afterThrowing(JoinPoint jp, Throwable error){
        LOGGER.error("Ups, I think that the method {} threw Exception and exception is:",
                jp.getSignature(),
                error);
    }
}
