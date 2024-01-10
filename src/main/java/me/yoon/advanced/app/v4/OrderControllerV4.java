package me.yoon.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import me.yoon.advanced.trace.TraceStatus;
import me.yoon.advanced.trace.logtrace.LogTrace;
import me.yoon.advanced.trace.template.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {


    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId) {

        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "OK";
            }
        };

        return template.execute("OrderController.request()");
    }
}
