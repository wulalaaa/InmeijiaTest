package com;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;

@Component
public class MyEbeanServerFactory implements FactoryBean<EbeanServer> {

    public EbeanServer getObject() throws Exception {
        return createEbeanServer();
    }

    public Class<?> getObjectType() {
        return EbeanServer.class;
    }

    public boolean isSingleton() {
        return true;
    }

  
    private EbeanServer createEbeanServer() {

        ServerConfig config = new ServerConfig();
        config.setName("inmeijia");
        config.loadFromProperties();
        config.setDefaultServer(true);
        return EbeanServerFactory.create(config);
    }
}
