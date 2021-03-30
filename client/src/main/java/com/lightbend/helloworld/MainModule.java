package com.lightbend.helloworld;

import com.google.inject.AbstractModule;
import com.lightbend.helloworld.helloworld.HelloWorldService;
import com.lightbend.lagom.javadsl.client.ServiceClientGuiceSupport;

public class MainModule extends AbstractModule implements ServiceClientGuiceSupport {
    @Override
    protected void configure() {
        bindClient(HelloWorldService.class);
    }
}
