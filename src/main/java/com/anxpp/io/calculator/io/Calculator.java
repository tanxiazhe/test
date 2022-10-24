package com.anxpp.io.calculator.io;

import java.io.UnsupportedEncodingException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public final class Calculator {
    private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

    public static Object cal(String expression) throws ScriptException {
        return jse.eval(expression);
    }

    public static String calculateExpression(byte[] bytes) {
        String expression = null;
        try {
            expression = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        return calculateExpression(expression);

    }

    public static String calculateExpression(String expression) {
        System.out.println("服务器收到消息：" + expression);
        // 处理数据
        String result = null;
        try {
            result = cal(expression).toString();
        } catch (Exception e) {
            result = "计算错误：" + e.getMessage();
        }
        return result;
    }
}