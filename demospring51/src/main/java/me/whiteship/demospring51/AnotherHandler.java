package me.whiteship.demospring51;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {

    @EventListener
    public void handle(MyEvent myEvent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("어나더핸들러 순차 실행" + myEvent.getData());
    }
}
