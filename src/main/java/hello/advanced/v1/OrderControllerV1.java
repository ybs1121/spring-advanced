package hello.advanced.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;
    private final HelloTraceV1 trace;

    @GetMapping("/v1/request")
    private String request(String itemId) {
        TraceStatus begin = null;
        try {
            begin = trace.begin("OrderControllerV2.request()");
            orderService.orderItem(itemId);
            trace.end(begin);
            return "ok";
        } catch (Exception e) {
            trace.exception(begin, e);
            throw e;
        }
    }

}
