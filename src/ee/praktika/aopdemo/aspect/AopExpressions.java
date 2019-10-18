package ee.praktika.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut( "execution(* ee.praktika.aopdemo.dao.*.*(..))" )
    public void referencePointcut(){
    }

    //creating pointcut for getter methods
    @Pointcut( "execution(* ee.praktika.aopdemo.dao.*.get*(..))" )
    public void referenceGettersPointcut(){
    }

    //creating pointcut for setter methods
    @Pointcut( "execution(* ee.praktika.aopdemo.dao.*.set*(..))" )
    public void referenceSettersPointcut(){
    }

    //creating pointcut: include package, but exclude all .get and.set methods.
    @Pointcut( "referencePointcut() && !(referenceGettersPointcut() || referenceSettersPointcut())" )
    public void referencePointcutIgnoreGetSet(){
    }

}
