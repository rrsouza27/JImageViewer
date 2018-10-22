/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimageviewer.ui;

import java.awt.Image;
import java.awt.Toolkit;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author rafael
 */
public class ScaledImageTest {

    public ScaledImageTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getScaledImage method, of class ScaledImage.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructor1() {
       ScaledImage image = new ScaledImage(null);
    }

    //getScaled
    @Test(expected = IllegalArgumentException.class)
    public void testGetScaledException1() {
       ScaledImage image = new ScaledImage(Toolkit.getDefaultToolkit().getImage("/home/rafael/Desktop/test.gif"));
       image.getScaledImage(0, 0, true);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetScaledException2() {
       ScaledImage image = new ScaledImage(Toolkit.getDefaultToolkit().getImage("/home/rafael/Desktop/test.gif"));
       image.getScaledImage(50, 0, true);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetScaledException3() {
       ScaledImage image = new ScaledImage(Toolkit.getDefaultToolkit().getImage("/home/rafael/Desktop/test.gif"));
       image.getScaledImage(0, 50, true);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetScaledException4() {
       ScaledImage image = new ScaledImage(Toolkit.getDefaultToolkit().getImage("/home/rafael/Desktop/test.gif"));
       image.getScaledImage(0, 0, false);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetScaledException5() {
       ScaledImage image = new ScaledImage(Toolkit.getDefaultToolkit().getImage("/home/rafael/Desktop/test.gif"));
       image.getScaledImage(50, 0, false);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetScaledException6() {
       ScaledImage image = new ScaledImage(Toolkit.getDefaultToolkit().getImage("/home/rafael/Desktop/test.gif"));
       image.getScaledImage(0, 50, false);
    }
    @Test
    public void testGetScaled1() {
       ScaledImage image = new ScaledImage(Toolkit.getDefaultToolkit().getImage("/home/rafael/Desktop/test.gif"));
       Image awtImage = image.getScaledImage(50, 50, false);
       assertNotNull(awtImage);
    }
    @Test
    public void testGetScaled2() {
       ScaledImage image = new ScaledImage(Toolkit.getDefaultToolkit().getImage("/home/rafael/Desktop/test.gif"));
       Image awtImage = image.getScaledImage(50, 50, true);
       assertNotNull(awtImage);
    }
}
