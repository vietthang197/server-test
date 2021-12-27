package vn.neo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author thanglv on 12/27/2021
 * @project server-test
 */
@RestController
public class HomeController {
    private Logger logger = LogManager.getLogger();

    @PostMapping(produces = {MediaType.APPLICATION_XML_VALUE})
    public Mono<String> test(@RequestBody String httpReq) {
        logger.info("Request: {}", httpReq);
        return Mono.justOrEmpty(httpReq).then(Mono.just("OK"));
    }
}
