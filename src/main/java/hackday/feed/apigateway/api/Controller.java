package hackday.feed.apigateway.api;

import hackday.feed.apigateway.model.DefaultRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ds on 2018-05-10.
 */

@RestController
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    /**
     * API GATEWAY RUNNING TEST API
     * @return SUCCESS Message
     */
    @GetMapping("")
    public ResponseEntity<DefaultRes> runCheck(){
        logger.info("테스트 : runCheck");
        DefaultRes res = new DefaultRes();
        res.setMsg("API GATEWAY SERVER RUNNING.....");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
