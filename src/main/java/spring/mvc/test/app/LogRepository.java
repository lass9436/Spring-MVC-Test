package spring.mvc.test.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class LogRepository {
    public void log() {
        log.info("repository log 호출");
    }
}
