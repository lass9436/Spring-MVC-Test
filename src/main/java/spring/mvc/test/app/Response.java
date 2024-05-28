package spring.mvc.test.app;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Response {
    private String result1;
    private String result2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(result1, response.result1) && Objects.equals(result2, response.result2);
    }
}
