package me.yoon.advanced;

import me.yoon.advanced.proxy.config.AppV1Config;
import me.yoon.advanced.proxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
@Import({AppV1Config.class, AppV2Config.class})
@SpringBootApplication(scanBasePackages = "me.yoon.advanced.proxy.app")      //지정해 주지 않으면 현재 위치 하위의 모든 클래스를 componentScan을 한다. 현재는 중복된 이름이 빈으로 등록되어있으므로 범위를 축소해서 수동 등록한다.
public class AdvancedSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedSpringApplication.class, args);
    }

}
