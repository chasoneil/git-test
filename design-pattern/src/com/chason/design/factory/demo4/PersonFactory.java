package com.chason.design.factory.demo4;

public class PersonFactory implements BaseFactory {

    @Override
    public Object createProduct(String type) {

        if (type.equals("student")) {
            return new Student();
        } else if (type.equals("teacher")) {
            return new Teacher();
        }
        return null;
    }
}
