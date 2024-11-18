package hello.advanced.app.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;


    public void orderItem(String itemId, TraceId traceId) {
        TraceStatus begin = null;
        try {
            begin = trace.beginSync(traceId, "OrderServiceV2.orderItem()");
            orderRepository.save(itemId, begin.getTraceId());
            trace.end(begin);
        } catch (Exception e) {
            trace.exception(begin, e);
            throw e;
        }

    }


}
