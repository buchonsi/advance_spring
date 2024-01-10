package me.yoon.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import me.yoon.advanced.trace.TraceId;
import me.yoon.advanced.trace.TraceStatus;
import me.yoon.advanced.trace.hellotrace.HelloTraceV2;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId) {


        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderRepository.request()");

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
