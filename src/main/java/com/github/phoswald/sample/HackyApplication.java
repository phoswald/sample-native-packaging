package com.github.phoswald.sample;

import java.lang.reflect.Field;
import java.time.ZonedDateTime;

public class HackyApplication {

    public static void main(String[] args) throws Exception {
        new HackyApplication().run(args);
    }

    private void run(String[] args) throws Exception {
        ZonedDateTime t = ZonedDateTime.now();
        Field f = ZonedDateTime.class.getDeclaredField("zone");
        f.setAccessible(true);
        Object zone = f.get(t);
        System.out.println("Current zone : " + zone);
    }
}
