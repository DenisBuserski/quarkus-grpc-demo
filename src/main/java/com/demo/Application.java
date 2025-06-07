package com.demo;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Application {
    public static void main(String[] args) {
        Quarkus.run(args);
//        Quarkus.run(HelloApplication.class, args);
    }

//    public static class HelloApplication implements QuarkusApplication {
//        @Override
//        public int run(String... args) throws Exception {
//            System.out.println("Business logic");
//            Quarkus.waitForExit();
//            return 0;
//        }
//    }
}
