package me.yoon.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import me.yoon.advanced.trace.TraceStatus;
import me.yoon.advanced.trace.logtrace.LogTrace;
import me.yoon.advanced.trace.template.AbstractTemplate;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {

        AbstractTemplate<Void> abstractTemplate = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                //저장로직
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생");
                }
                sleep(1000);
                return null;
            }
        };
        abstractTemplate.execute("OrderRepository.request()");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
