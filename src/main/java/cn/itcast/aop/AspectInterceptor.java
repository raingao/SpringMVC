package cn.itcast.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by gaoyu on 2017/6/5.
 * Wish you a good day~
 */

@Aspect
@Component
public class AspectInterceptor {

    /**
     * 配置一个切入点
     * 后面的通知直接引入切入点
     */
    @Pointcut(value = "execution(public * cn.itcast.controller.*.*(..))")
    private void pointcut() {
    }

    @Before(value = "pointcut()")
    public void methodBefore(JoinPoint joinPoint) {
        System.out.println("前置通知：@before" + Arrays.toString(joinPoint.getArgs()));
    }

    @Around(value = "pointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("进入环绕方法@Around");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("退出环绕法法");
        return object;
    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        System.out.println("@AfterThrowing" + Arrays.toString(joinPoint.getArgs()));
    }

    @After(value = "pointcut()")
    public void after() {
        System.out.println("@After后置通知");
    }

    @AfterReturning(value = "pointcut()")
    public void afterReturning() {
        System.out.println("执行后@AfterReturning");
    }
}
