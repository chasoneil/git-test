package com.chason.design.factory.demo3;

public class CarFactory {

    public static Car getCar (String type) {

        if (type.equals("suv")) {
            return new SUV();
        } else if (type.equals("trunk")) {
            return new Trunk();
        }
        return null;
    }

}
