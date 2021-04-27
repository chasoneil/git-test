package com.chason.design.factory.demo4;

public class CarFactory implements BaseFactory {


    @Override
    public Object createProduct(String type) {

        if (type.equals("suv")) {
            return new SUV();
        } else if (type.equals("trunk")) {
            return new Trunk();
        }
        return null;
    }

}
