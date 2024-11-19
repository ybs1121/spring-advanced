package hello.advanced.trace.template;

import hello.advanced.trace.template.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {

        long startTime = System.currentTimeMillis();

        log.info("비지니스 로직 1 실행");

        long endTime = System.currentTimeMillis();

        long result = endTime - startTime;

        log.info("resultTime = {}", result);
    }

    private void logic2() {

        long startTime = System.currentTimeMillis();

        log.info("비지니스 로직 2실행");

        long endTime = System.currentTimeMillis();

        long result = endTime - startTime;

        log.info("resultTime = {}", result);
    }

    /**
     * 템플릿 메서드 패턴 적용
     */
    @Test
    void templateMethodV1() {
        AbstractTemplate2 template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate2 template2 = new SubClassLogic2();
        template2.execute();

        AbstractTemplate2 template3 = new SubClassLogic3(new Something("A"));
        template3.execute();
    }

    @Test
    void templateMethodV2() {
        AbstractTemplate2 template1 = new AbstractTemplate2() {
            @Override
            public void call() {
                log.info("비지니스 로직 1 실행");
            }
        };

        template1.execute();
    }
}
