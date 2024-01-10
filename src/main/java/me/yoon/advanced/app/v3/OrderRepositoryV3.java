package me.yoon.advanced.app.v3;

import lombok.RequiredArgsConstructor;
import me.yoon.advanced.trace.TraceId;
import me.yoon.advanced.trace.TraceStatus;
import me.yoon.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemId) {


        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.request()");

            //저장로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
