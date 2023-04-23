package com.woopaca.prospring.chapter2.decoupled;

public class HelloWorldDecoupled {

    public static void main(String... args) {
        MessageRenderer messageRenderer =
                MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider messageProvider =
                MessageSupportFactory.getInstance().getMessageProvider();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }
}
