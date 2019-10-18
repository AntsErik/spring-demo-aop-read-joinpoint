package ee.praktika.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order( 4 )
public class MyDemoLoggingAspect {
    @Before( "ee.praktika.aopdemo.aspect.AopExpressions.referencePointcutIgnoreGetSet()" )
    public void beforeAddAccountAdvice(){
        System.out.println( "\n======>>> Executing @Before advice on addAccount() in the DAO package" );
    }
}
