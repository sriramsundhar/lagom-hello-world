package com.lightbend.helloworld;

import com.lightbend.helloworld.helloworld.HelloWorldService;
import com.lightbend.lagom.javadsl.client.integration.LagomClientFactory;

import javax.inject.Inject;
import java.net.URI;

public class Main {
    private final HelloWorldService helloWorldService;

    @Inject
    public Main(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public static void main (String... args) {
        try (LagomClientFactory clientFactory = LagomClientFactory
                .create("client", LagomClientFactory.class.getClassLoader())) {
            HelloWorldService helloWorldService = clientFactory.createClient(HelloWorldService.class, new URI("http://localhost:9000"));
//        helloWorldService.helloWorld().invoke()
//                .thenApply()
            String result = helloWorldService.helloWorld().invoke().toCompletableFuture().get();
            System.out.println(result);
        } catch ( Exception e) {
            System.out.println(e);
        }

    }


}
