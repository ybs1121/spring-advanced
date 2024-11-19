package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate2 {

    public void execute() {

        long startTime = System.currentTimeMillis();

//        log.info("비지니스 로직 1 실행");
        call();
        long endTime = System.currentTimeMillis();

        long result = endTime - startTime;

        log.info("resultTime = {}", result);
    }

    public abstract void call();
}
