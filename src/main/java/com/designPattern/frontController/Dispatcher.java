/**
 * 
 */
package com.designPattern.frontController;

/**
 * @author 
 *
 */
public class Dispatcher {

    private StudentView studentView;
    private HomeView homeView;

    public Dispatcher(StudentView studentView, HomeView homeView) {
        this.studentView = studentView;
        this.homeView = homeView;

    }

    public void dispatch(Object o) {
        if (o instanceof StudentView) {
            studentView = (StudentView) o;
            studentView.show();
        } else if (o instanceof HomeView) {
            homeView = (HomeView) o;
            homeView.show();
        }

    }
}
