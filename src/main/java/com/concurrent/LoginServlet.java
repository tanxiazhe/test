/**
 * 
 */
package com.concurrent;

/**
 * @author 
 *
 */
public class LoginServlet {

    private static String usernameRef;
    private static String passwordRef;

    synchronized private static void doPost(String username, String password) {
        usernameRef = username;
        passwordRef = password;

        if (username.equals("a")) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("username = " + usernameRef + " password = " + passwordRef);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LoginServlet loginServlet = new LoginServlet();
        ALogin a = loginServlet.new ALogin();
        a.start();

        BLogin b = loginServlet.new BLogin();
        b.start();

    }

    class ALogin extends Thread {
        @Override
        public void run() {
            LoginServlet.doPost("a", "aa");
        }
    }

    class BLogin extends Thread {
        @Override
        public void run() {
            LoginServlet.doPost("b", "bb");
        }
    }

}
