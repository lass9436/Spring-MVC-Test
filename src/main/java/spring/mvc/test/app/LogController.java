package spring.mvc.test.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import spring.mvc.test.config.User;

@Controller
@Slf4j
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/log")
    @ResponseBody
    public String log(@User String user) {
        log.info("controller log 호출");
        logService.log();
        return user;
    }

    @GetMapping("/logResponse")
    @ResponseBody
    public Response logResponse(@User String user) {
        log.info("controller log Response 호출");
        logService.log();
        Response response = new Response();
        response.setResult1("A");
        response.setResult2("B");
        return response;
    }

    @GetMapping("/logHtml")
    public String logHtml(@User String user) {
        log.info("controller log Html 호출");
        logService.log();
        return "/logHtmlSample.html";
    }

    @GetMapping("/logThymeleaf")
    public String logThymeleaf(@User String user) {
        log.info("controller log Thymeleaf 호출");
        logService.log();
        return "/logThymeleaf.html";
    }
}
