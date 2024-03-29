package me.yoon.advanced;

import me.yoon.advanced.trace.logtrace.FieldLogTrace;
import me.yoon.advanced.trace.logtrace.LogTrace;
import me.yoon.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
//        return new FieldLogTrace();
        return new ThreadLocalLogTrace();
    }
}
