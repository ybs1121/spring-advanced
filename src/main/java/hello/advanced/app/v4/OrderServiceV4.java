package hello.advanced.app.v4;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;


    public void orderItem(String itemId) {
        TraceStatus begin = null;
        try {
            begin = trace.begin("OrderServiceV2.orderItem()");
            orderRepository.save(itemId);
            trace.end(begin);
        } catch (Exception e) {
            trace.exception(begin, e);
            throw e;
        }

    }


}
