package hackday.feed.apigateway.filter;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import hackday.feed.apigateway.model.DefaultRes;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_RESPONSE_FILTER_ORDER;

/**
 * Created by ds on 2018-05-17.
 */

@Slf4j
public class PostFilter extends ZuulFilter {

    //private static final Logger logger = LoggerFactory.getLogger(PostFilter.class);

    /**
     * 필터 타입
     * @return
     */
    @Override
    public String filterType() {
        return "post";
    }

    /**
     * 필터 실행 순서
     * @return
     */
    @Override
    public int filterOrder() {
        //499
        return SEND_RESPONSE_FILTER_ORDER - 1;
    }

    /**
     * 필터 실행 조건
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 필터 실행
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        try (final InputStream responseDataStream = ctx.getResponseDataStream()) {
            final String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));

            Gson gson = new Gson();
            DefaultRes res = gson.fromJson(responseData, DefaultRes.class);
            res.setMsg("파싱 성공");
            ctx.setResponseBody(res.toString());

        } catch (IOException e) {

        }
        return null;
    }
}
