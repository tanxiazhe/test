/**
 * 
 */
package com.concurrent;

/**
 * @author 
 *
 */
public class SynchronizedObject {

    private String username = "a";
    private String password = "aa";

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    synchronized public void printString(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.password = password;
    }
}
