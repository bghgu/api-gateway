package tk.bghgu.gateway.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tk.bghgu.gateway.model.DefaultRes;
import tk.bghgu.gateway.service.RestService;

/**
 * Created by ds on 2018-05-22.
 */

@Slf4j
@RestController
public class HttpController {

    @Autowired
    private RestService restService;

    @GetMapping("")
    public ResponseEntity echo() {
        return restService.restGet();
    }

    @GetMapping("/contents/{content_id}")
    public ResponseEntity<DefaultRes> getContentByContentId(@PathVariable("content_id") final String content_id) {
        log.info("content_id : " + content_id);
        DefaultRes res = new DefaultRes();
        res.setMsg(content_id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
