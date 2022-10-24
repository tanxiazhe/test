/**
 * 
 */
package com.test;

import java.util.List;

/**
 * @author I071030
 * 
 */
public interface EmployeeService {

    public Employee getEmployeeByUserId(Long userId);

    public List<Employee> getDeletedEmployees();

    // public List<Employee> getEmployeesByTeam(Long teamId, int $top, int $skip, String $orderby);

    public Employee getCurrentEmployee();

    // public List<EmployeeOrgParam> getEmployeeOrg(Long employeeId);

    public void verifyUserPassword(Long employeeId, String password);

    public void verifyPassword(Long userID, String password, String firstname, String lastname);

    public boolean verifyEmail(String email);

    public void validateEmail(String email);

    public boolean changeMyPassword(String oldPassword, String newPassword);

    public boolean changePassword(Long employeeId, String newPassword);

    public List<Employee> getHandoverToEmployees(Long fromEmployeeId);

    public boolean handoverTo(Long fromEmployeeId, Long toEmployeeId);

    /*
     * Get the employee by the landscape id
     * 
     * public Employee getEmployeeByLandscapeId(Long landscapeId);
     */

    public Boolean exceedMaxUsers();

    public Boolean isTechnicalSupportFlagModifiable(Long employeeId);

    public Boolean isLastTechnicalSupportUser(Long employeeId);

    public Long getPasswordRemainingExpiryDays();

    public void deleteEmployee(Long employeeId);
}
