package bg.softuni.aop.sample;

import bg.softuni.aop.IncredibleMachine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Sample1AspectDemo implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sample1AspectDemo.class);

    private final IncredibleMachine incredibleMachine;

    public Sample1AspectDemo(IncredibleMachine incredibleMachine) {
        this.incredibleMachine = incredibleMachine;
    }

    @Override
    public void run(String... args) throws Exception {
        incredibleMachine.saySomething();
        incredibleMachine.echo("ECHOO");
        try {
            incredibleMachine.boom();
        } catch (Exception e){
            LOGGER.error("Exception form boom called!");
        }
    }
}
