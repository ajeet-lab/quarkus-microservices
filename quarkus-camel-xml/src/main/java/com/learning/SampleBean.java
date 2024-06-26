package com.learning;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("myBean")
public class SampleBean {

    private String say = "Hello World";

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    public String saySomething() {
        return say;
    }
}
