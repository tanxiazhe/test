/**
 * 
 */
package com.designPattern.proxy;

/**
 * @author 
 *
 */
public class RealImage implements Image {

    public String fileName;

    /**
     * 
     */
    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);

    }

    public void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

}
