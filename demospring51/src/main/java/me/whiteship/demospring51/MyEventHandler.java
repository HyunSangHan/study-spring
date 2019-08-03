package me.whiteship.demospring51;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler {

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE + 2 )
    public void handle(MyEvent myEvent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("받았다. 데이터는 " + myEvent.getData());
    }

    @EventListener
    @Async
    public void handle(ContextRefreshedEvent myEvent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextRefreshEvent");
    }

    @EventListener
    @Async
    public void handle(ContextClosedEvent myEvent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextClosedEvent");
    }
}
