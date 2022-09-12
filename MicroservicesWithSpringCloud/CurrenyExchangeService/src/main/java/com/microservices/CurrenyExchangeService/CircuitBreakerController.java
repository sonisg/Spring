package com.microservices.CurrenyExchangeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/sample")
    //@Retry(name="default", fallbackMethod = "hardCode")
   // @CircuitBreaker(name="default", fallbackMethod = "hardCode")
    @RateLimiter(name="default")
    public String sampleApi(){
        logger.info("Sample Api Call Received");
//        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:99", String.class);
//        return responseEntity.getBody();
        return "Sample Api";
    }

    public String hardCode(Exception ex){
        return "Fallback Response";
    }
}
