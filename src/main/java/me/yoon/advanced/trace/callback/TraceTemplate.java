package me.yoon.advanced.trace.callback;

import lombok.extern.slf4j.Slf4j;
import me.yoon.advanced.trace.TraceStatus;
import me.yoon.advanced.trace.logtrace.LogTrace;

@Slf4j
public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            //로직 호출
            T result = callback.call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
