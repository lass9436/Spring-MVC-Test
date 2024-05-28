package spring.mvc.test.mvc.log;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import spring.mvc.test.app.Response;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LogTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void log() {
        ResponseEntity<String> response = restTemplate.getForEntity("/log", String.class);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("lass");
    }

    @Test
    public void logResponse() {
        ResponseEntity<Response> response = restTemplate.getForEntity("/logResponse", Response.class);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        Response result = new Response();
        result.setResult1("A");
        result.setResult2("B");
        assertThat(response.getBody()).isEqualTo(result);
    }

    @Test
    public void logHtml() {
        ResponseEntity<String> response = restTemplate.getForEntity("/logHtml", String.class);
    }

    @Test
    public void logThymeleaf() {
        ResponseEntity<String> response = restTemplate.getForEntity("/logThymeleaf", String.class);
    }
}