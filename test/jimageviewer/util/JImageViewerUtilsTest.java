/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimageviewer.util;

import java.awt.Dimension;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author rafael
 */
public class JImageViewerUtilsTest extends TestCase {
    public JImageViewerUtilsTest(String testName) {
        super(testName);
    }

    @Before
    protected void setUp() throws Exception {

    }

    //Test ScaledKeepRatio

    //smaller region
    @Test
    public void testScaledKeepRatioSmaller1(){
        assertEquals(JImageViewerUtils.scaledKeepRatio(1920, 1080, 1300, 720), new Dimension(1280, 720));
    }
    @Test
    public void testScaledKeepRatioSmaller2(){
        assertEquals(JImageViewerUtils.scaledKeepRatio(1280, 720, 853, 853), new Dimension(853, 480));
    }
    @Test
    public void testScaledKeepRatioSmaller3(){
        assertEquals(JImageViewerUtils.scaledKeepRatio(600, 400, 400, 400), new Dimension(400, 267));
    }
    @Test
    public void testScaledKeepRatioSmaller5(){
        assertEquals(JImageViewerUtils.scaledKeepRatio(1080, 1920, 500, 500), new Dimension(281, 500));
    }

    //bigger region
    @Test
    public void testScaledKeepRatioBigger1(){
        assertEquals(JImageViewerUtils.scaledKeepRatio(1280, 720, 1920, 2000), new Dimension(1920, 1080));
    }
    @Test
    public void testScaledKeepRatioBigger2(){
        assertEquals(JImageViewerUtils.scaledKeepRatio(720, 1280, 2000, 1920), new Dimension(1080, 1920));
    }
    @Test
    public void testScaledKeepRatioBigger3(){
        assertEquals(JImageViewerUtils.scaledKeepRatio(1280, 720, 1920, 1920), new Dimension(1920, 1080));
    }
    @Test
    public void testScaledKeepRatioBigger4(){
        assertEquals(JImageViewerUtils.scaledKeepRatio(720, 1280, 1920, 1920), new Dimension(1080, 1920));
    }

    //exceptions
    @Test(expected = IllegalArgumentException.class)
    public void testScaledKeepRatioException1(){
        JImageViewerUtils.scaledKeepRatio(0, 720, 1920, 1920);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testScaledKeepRatioException2(){
        JImageViewerUtils.scaledKeepRatio(1280, 0, 1920, 1920);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testScaledKeepRatioException3(){
        JImageViewerUtils.scaledKeepRatio(1280, 720, 0, 1920);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testScaledKeepRatioException4(){
        JImageViewerUtils.scaledKeepRatio(1280, 720, 1920, 0);
    }

}
