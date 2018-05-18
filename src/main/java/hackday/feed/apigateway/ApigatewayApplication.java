package hackday.feed.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ApigatewayApplication {

//    @Bean
//    public PostFilter postFilter() {
//        return new PostFilter();
//    }
//
//    @Bean
//    public RouteFilter routeFilter() {
//        return new RouteFilter();
//    }
//
//    @Bean
//    public PreFilter preFilter() {
//        return new PreFilter();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ApigatewayApplication.class, args);
    }
}
