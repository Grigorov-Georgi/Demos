package bg.softuni.aop.sample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
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
}
