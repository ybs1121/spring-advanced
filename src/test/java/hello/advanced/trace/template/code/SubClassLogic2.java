package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic2 extends AbstractTemplate2 {

    @Override
    public void call() {
        log.info("비지니스 로직2");
    }
}