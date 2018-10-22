/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimageviewer.ui;

import java.awt.Dimension;
import java.awt.Image;
import jimageviewer.util.JImageViewerUtils;

/**
 *
 * @author rafael
 */
public class ScaledImage {
    private Image image;

    public ScaledImage(Image image) throws NullPointerException {
        if(image == null) {
            throw new NullPointerException("Image cannot be null!");
        }
        this.image = image;
    }

    Image getScaledImage(int width, int height, boolean keepAspectRatio) throws IllegalArgumentException {
        if(width < 1 | height < 1 | this.image == null) {
            throw new IllegalArgumentException("width or height less than 1 or image is null");
        }
        Image img;
        if(keepAspectRatio) {
            Dimension d = JImageViewerUtils.scaledKeepRatio(this.image.getWidth(null), this.image.getHeight(null), width, height);
            System.out.print("CAASO: resize to: "+d);
            //img = this.image.getScaledInstance(d.width, d.height, Image.SCALE_DEFAULT);
            img = this.image.getScaledInstance(d.width, d.height, Image.SCALE_DEFAULT);

        } else {
            img = this.image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        }
        return img;
    }

    public void flush() {
        this.image.flush();
    }
}
