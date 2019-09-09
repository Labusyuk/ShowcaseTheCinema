package com.labus.mycinema;

public class Constants {

    private Constants() {
        throw new AssertionError();
    }

    public interface ConstantType {
        public String value();
    }

    public enum DATABASE implements ConstantType {
        DRIVER("jdbc"),
        DBMS("mysql"),
        HOST("localhost"),
        PORT("3306"),
        SCHEMA("cinemadb");
        private String value;
        private DATABASE(String value) {
            this.value = value;
        }
        public String value() {
            return value;
        }
    }

    public enum WEB implements ConstantType {
        CINEMANAME("Labus Cinema");
        private String value;
        private WEB(String value) {
            this.value = value;
        }
        public String value() {
            return value;
        }
    }


}