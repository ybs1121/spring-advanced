package hello.advanced.app.v4;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV4 {

    private final LogTrace  trace;

    public void save(String itemId) {
        // 저장로직

        TraceStatus begin = null;
        try {
            begin = trace.begin( "OrderRepositoryV1.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            trace.end(begin);
        } catch (Exception e) {
            trace.exception(begin, e);
            throw e;
        }


    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
