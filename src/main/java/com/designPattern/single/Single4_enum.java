package com.designPattern.single;

public enum Single4_enum {
    INSTANCE;

    private Single4_enum() {
        System.out.println("here");
    }

    public static void main(String[] args) {
        System.out.println(Single4_enum.INSTANCE);
    }
}
