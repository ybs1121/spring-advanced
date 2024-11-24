package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    void callbackV1() {
        TimeLogTemplate template1 = new TimeLogTemplate();
        template1.execute(() -> log.info("비지니스 로직1 실행"));


        TimeLogTemplate template2 = new TimeLogTemplate();
        template2.execute(() -> log.info("비지니스 로직2 실행"));
    }
}
