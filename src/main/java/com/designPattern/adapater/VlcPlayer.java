/**
 * 
 */
package com.designPattern.adapater;

/**
 * @author 
 *
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    /*
     * (non-Javadoc)
     * 
     * @see com.designPattern.adapater.AdvancedMediaPlayer#playVic()
     */
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.designPattern.adapater.AdvancedMediaPlayer#playMp4()
     */
    @Override
    public void playMp4(String fileName) {
        // TODO Auto-generated method stub

    }

}
