package tk.bghgu.gateway.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tk.bghgu.gateway.service.RestService;

/**
 * Created by ds on 2018-05-22.
 */

@Service
public class RestServiceImpl implements RestService {

    private final static String BASE = "http://bghgu.tk:8080";

    public ResponseEntity restGet() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(BASE, String.class);
    }
}
