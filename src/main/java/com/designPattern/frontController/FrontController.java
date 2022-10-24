/**
 * 
 */
package com.designPattern.frontController;

/**
 * @author 
 *
 */
public class FrontController {
    private final Dispatcher dispatcher;

    public FrontController(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public boolean isAuthenticUser() {
        System.out.println("User is authenticated successfully.");
        return true;
    }

    public void trackRequest(Object request) {
        System.out.println("Page requested: " + request);
    }

    public void dispatchRequest(Object request) {
        // 记录每一个请求
        trackRequest(request);
        // 对用户进行身份验证
        if (isAuthenticUser()) {
            dispatcher.dispatch(request);
        }
    }
}
