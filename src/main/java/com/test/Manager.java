
package com.test;

/**
 * @author 
 *
 */
class Manager extends Employee {
    private String bonus;

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    /**
     * 
     */
    public Manager() {
    }

    @Override
    public String toString() {
        return "Manager [bonus=" + bonus + ", getBonus()=" + getBonus() + ", getFirstName()=" + getFirstName()
                + ", getLastName()=" + getLastName() + ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail()
                + ", isKeyUser()=" + isKeyUser() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + "]";
    }

}
