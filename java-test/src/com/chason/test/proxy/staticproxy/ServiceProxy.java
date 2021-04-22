package com.chason.test.proxy.staticproxy;

public class ServiceProxy implements Service {

    private Service service;

    public ServiceProxy (Service service) {
        this.service = service;
    }

    @Override
    public String update() {
        String result = "";
        String suffix = "before ";
        result += suffix;
        result += service.update();
        result += " after";
        return result;
    }
}
