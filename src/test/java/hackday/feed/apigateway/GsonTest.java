package hackday.feed.apigateway;

import com.google.gson.Gson;
import hackday.feed.apigateway.model.DefaultRes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ds on 2018-05-17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class GsonTest {

    @Test
    public void testGson() {
        String json = "{\"data\":null,\"msg\":\"3\",\"httpStatus\":\"OK\"}";

        Gson gson = new Gson();
        DefaultRes res = gson.fromJson(json, DefaultRes.class);
        res.setMsg("파싱 성공");
        System.out.println(res.toString());

    }
}
