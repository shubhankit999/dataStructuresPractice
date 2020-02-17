package DemoAnnotation.readreplica;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * author: Koushik
 * Date: July 2019
 * This module will help to to route between Master DB and Slave DB
 * Use Annotation @ReadFromReplica over any method to expose to read from slave DB.
 */


@Aspect
@Component
@Order(0)
public class ReadOnlyRouteInterceptor {

    @Around("@annotation(readFromReplica)")
    public Object proceed(ProceedingJoinPoint pjp, ReadFromReplica readFromReplica) throws Throwable {
        try {
            RoutingDataSource.setReplicaRoute();
            return pjp.proceed();
        } catch(Throwable t) {
            System.out.println("Error while reading from replica db Error message: {}" + t.getMessage());
            throw t;
        } finally {
            RoutingDataSource.clearReplicaRoute();
        }
    }
}
