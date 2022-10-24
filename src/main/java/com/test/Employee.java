package com.test;

public class Employee {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    // private List<RoleInfo> employeeRoles = new ArrayList<RoleInfo>();
    private boolean keyUser;

    public Employee(String firstName) {
        super();
        this.firstName = firstName;
    }

    /**
     * 
     */
    Employee() {
    }

    public Employee(String firstName, String lastName, String password, String email, boolean keyUser) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.keyUser = keyUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * public List<RoleInfo> getEmployeeRoles() {
     * return employeeRoles;
     * }
     * 
     * public void setEmployeeRoles(List<RoleInfo> employeeRoles) {
     * this.employeeRoles = employeeRoles;
     * }
     */

    public boolean isKeyUser() {
        return keyUser;
    }

    public void setKeyUser(boolean keyUser) {
        this.keyUser = keyUser;
    }

    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", email="
                + email + ", keyUser=" + keyUser + "]";
    }

}
