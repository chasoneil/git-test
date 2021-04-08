package com.chason.rpc.service;

/**
 * 具体实现类
 */
public class StringServiceImpl implements StringService {

    @Override
    public String lower(String string) {
        if (string != null) {
            return string.toLowerCase();
        }
        return null;
    }

    @Override
    public String upper(String string) {
        if (string != null) {
            return string.toUpperCase();
        }
        return null;
    }
}
