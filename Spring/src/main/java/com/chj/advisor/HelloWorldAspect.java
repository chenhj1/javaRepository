package com.chj.advisor;

import net.sf.json.JSONArray;
import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by chenhaojie on 2018/02/11.
 */
public class HelloWorldAspect {
    public void beforeAdvice() {
        System.out.println("前置通知执行了");
    }

    public void afterAdvice() {
        System.out.println("后置通知执行了");
    }

    public void afterReturnAdvice(Object result) {
        System.out.println("返回通知执行了" + "运行业务方法返回的结果为" + result);
    }

    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = "";
        try {
            System.out.println("环绕通知start...");
            long start = System.currentTimeMillis();
            System.out.println("参数列表：" + JSONArray.fromObject(proceedingJoinPoint.getArgs()));
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("环绕通知end");
            System.out.println("cost：" + (end - start) + "ms");
        } catch (Throwable e) {

        }
        return result;
    }

    public void throwingAdvice(JoinPoint joinPoint, Exception e) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("异常通知执行了.");
        stringBuffer.append("方法:").append(joinPoint.getSignature().getName()).append("出现了异常.");
        stringBuffer.append("异常信息为:").append(e.getMessage());
        System.out.println(stringBuffer.toString());
    }
}
