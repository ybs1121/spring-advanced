package hello.advanced.app.v2;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    private String request(String itemId) {
        TraceStatus begin = null;
        try {
            begin = trace.begin("OrderControllerV2.request()");
            orderService.orderItem(itemId, begin.getTraceId());
            trace.end(begin);
            return "ok";
        } catch (Exception e) {
            trace.exception(begin, e);
            throw e;
        }
    }

}
