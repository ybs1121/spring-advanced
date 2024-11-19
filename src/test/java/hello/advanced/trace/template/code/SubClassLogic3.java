package hello.advanced.trace.template.code;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SubClassLogic3 extends AbstractTemplate2 {

    private Something something;

    @Override
    public void call() {
        log.info(something.toString());
        log.info("비지니스 로직3");
    }


}