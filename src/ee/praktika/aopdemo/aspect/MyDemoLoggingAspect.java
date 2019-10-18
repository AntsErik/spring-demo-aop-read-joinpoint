package ee.praktika.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ee.praktika.aopdemo.Account;

@Aspect
@Component
@Order( 4 )
public class MyDemoLoggingAspect {
    @Before( "ee.praktika.aopdemo.aspect.AopExpressions.referencePointcutIgnoreGetSet()" )
    public void beforeAddAccountAdvice( JoinPoint theJoinPoint ){
        System.out.println( "\n======>>> Executing @Before advice on addAccount() in the DAO package" );

        //display the method signature
        MethodSignature methodSignature = (MethodSignature)theJoinPoint.getSignature();

        System.out.println( "Method: " + methodSignature );

        //display the method arguments that are being passed in

        //get the arguments
        Object[] args = theJoinPoint.getArgs();

        //looping through the arguments and printing them out
        for( Object tempArg : args ) {
            System.out.println( tempArg );

            if( tempArg instanceof Account ) {
                //downcast and print Account specific stuff
                Account theAccount = (Account)tempArg;

                System.out.println( "Account name: " + theAccount.getName() );
                System.out.println( "Level name: " + theAccount.getLevel() );
            }
        }
    }
}
