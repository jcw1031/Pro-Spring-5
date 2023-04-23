package com.woopaca.prospring.chapter2.decoupled;

import java.util.Properties;

public class MessageSupportFactory {

    private static final MessageSupportFactory instance;

    private Properties properties;
    private MessageRenderer messageRenderer;
    private MessageProvider messageProvider;

    private MessageSupportFactory() {
        properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream("/msf.properties"));
            String rendererClass = properties.getProperty("renderer.class");
            String providerClass = properties.getProperty("provider.class");

            messageRenderer = (MessageRenderer) Class.forName(rendererClass)
                    .getDeclaredConstructor().newInstance();
            messageProvider = (MessageProvider) Class.forName(providerClass)
                    .getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return messageRenderer;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
