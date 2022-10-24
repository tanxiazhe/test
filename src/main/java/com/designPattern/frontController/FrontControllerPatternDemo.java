/**
 * 
 */
package com.designPattern.frontController;

/**
 * @author 
 *
 */
public class FrontControllerPatternDemo {

    public static void main(String[] args) {
        StudentView studentView = new StudentView();
        HomeView homeView = new HomeView();
        Dispatcher d = new Dispatcher(studentView, homeView);
        FrontController frontController = new FrontController(d);
        frontController.dispatchRequest(studentView);
        frontController.dispatchRequest(homeView);

    }
}
