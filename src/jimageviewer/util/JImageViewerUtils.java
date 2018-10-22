/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimageviewer.util;

import java.awt.Dimension;

/**
 *
 * @author rafael
 */
public class JImageViewerUtils {
    public static Dimension scaledKeepRatio(int origWidth, int origHeight, int newWidth, int newHeight) {

        int retWidth = 0;
        int retHeight = 0;
        double ratio = (double) origWidth/origHeight;

        if(newWidth > newHeight) {
            retWidth = newWidth;
            retHeight = (int) Math.round(newWidth/ratio);
            if(retHeight > newHeight) {
                retHeight = newHeight;
                retWidth = (int) Math.round(newHeight*ratio);
            }
        } else {
            retHeight = newHeight;
            retWidth = (int) Math.round(newHeight*ratio);
            if(retWidth > newWidth) {
                retWidth = newWidth;
                retHeight = (int) Math.round(newWidth/ratio);
            }
        }

        System.out.println("scaledKeepRatio: origWidth: "+origWidth+" origHeight: "+origHeight+ " retWidth: "+retWidth+" retHeight: "+retHeight);

        return new Dimension(retWidth, retHeight);
    }
}
