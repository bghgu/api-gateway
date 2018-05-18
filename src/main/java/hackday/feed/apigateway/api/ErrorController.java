package hackday.feed.apigateway.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ds on 2018-05-18.
 */

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
