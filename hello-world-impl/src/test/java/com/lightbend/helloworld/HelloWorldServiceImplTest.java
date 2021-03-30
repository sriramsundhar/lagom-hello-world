package com.lightbend.helloworld;

import com.lightbend.helloworld.helloworld.HelloWorldService;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.*;

public class HelloWorldServiceImplTest {

    @Test
    public void helloWorldShouldReturnTheExpectedResults() throws Exception {
        withServer(defaultSetup(), server -> {
            HelloWorldService helloWorldService = server.client(HelloWorldService.class);
            String result = helloWorldService.helloWorld().invoke()
                    .toCompletableFuture()
                    .get(5, TimeUnit.SECONDS);
            assertEquals("Hello world", result);
        });
//        HelloWorldService helloWorldService = new HelloWorldServiceImpl();

    }

}