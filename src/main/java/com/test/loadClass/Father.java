/**
 * 
 */
package com.test.loadClass;

/**
 * @author 
 *
 */
public class Father {
    String name;

    static {
        System.out.println("father static.");
    }

    Father() {
        System.out.println("Father default constructor.");
    }

    Father(String name) {
        // System.out.println("Father constructor.");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Son [name=" + name + "]";
    }

    public void queryBOs(String filter, String orderBy, Integer limit, Integer offset) {
        this.queryBOs(filter, null, orderBy, limit, offset);
    }

    /***
     * 
     * @param filter
     * @return
     */
    public void queryBOs(String filter, String search, String orderBy, Integer limit, Integer offset) {
        System.out.println("2");
    }

}
