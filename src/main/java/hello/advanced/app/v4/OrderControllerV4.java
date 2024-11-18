package hello.advanced.app.v4;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    @GetMapping("/v4/request")
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