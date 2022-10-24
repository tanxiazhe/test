package com.test.nestedclass;

import java.applet.Applet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnonymousInnerClassDemo extends Applet {

    /**
     * TODO Comment.
     *
     * @since v1.0
     */
    private static final long serialVersionUID = -2151238788988376754L;

    @Override
    public void init() {

        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {

                showStatus("Mouse Pressed!");

            }

        });

    }

    @Override
    public void showStatus(String str) {

        System.out.println(str);

    }

}