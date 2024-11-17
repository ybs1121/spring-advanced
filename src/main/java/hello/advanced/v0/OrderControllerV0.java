package hello.advanced.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderControllerV0 {

    private final OrderServiceV0 orderService;


    @GetMapping("/v0/request")
    private String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

}
