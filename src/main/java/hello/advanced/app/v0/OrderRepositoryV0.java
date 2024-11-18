package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV0 {

    public void save(String itemId) {
        // 저장로직

        if(itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생!");
        }

        sleep(1000);
    }

    private void sleep(int mills){
        try {
            Thread.sleep(mills);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
