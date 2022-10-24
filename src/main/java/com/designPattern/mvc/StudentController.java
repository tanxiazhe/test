/**
 * 
 */
package com.designPattern.mvc;

/**
 * @author 
 *
 */
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController() {

    }

    public StudentController(Student model2, StudentView view2) {
        model = model2;
        view = view2;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo() {
        return model.getRollNo();
    }

    public void updateView() {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }

}
