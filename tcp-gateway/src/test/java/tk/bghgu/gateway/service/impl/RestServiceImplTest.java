package tk.bghgu.gateway.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

/**
 * Created by ds on 2018-05-22.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestServiceImplTest {

    private final static String BASE = "http://bghgu.tk:8080";

    @Test
    public void restGet() {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(restTemplate.getForEntity(BASE, String.class));
    }
}