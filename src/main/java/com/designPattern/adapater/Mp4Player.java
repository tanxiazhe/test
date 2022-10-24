/**
 * 
 */
package com.designPattern.adapater;

/**
 * @author 
 *
 */
public class Mp4Player implements AdvancedMediaPlayer {

    /*
     * (non-Javadoc)
     * 
     * @see com.designPattern.adapater.AdvancedMediaPlayer#playVic()
     */
    @Override
    public void playVlc(String fileName) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.designPattern.adapater.AdvancedMediaPlayer#playMp4()
     */
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }

}
