/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimageviewer.managers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public class ImageManager {
    String path;
    ArrayList<String> imagesList;
    int currentIndex;
    public ImageManager() {
        this.imagesList = new ArrayList<>();
        this.currentIndex = -1;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void load(){
        Logger logger = Logger.getLogger(ImageManager.class.getName());
        File folder = new File(this.path);
        if(!folder.exists()) {
            throw new IllegalArgumentException("Directory does not exist!");
        }
        for (File child : folder.listFiles()) {
            if(child.isFile() && child.canRead()) {
                try{
                    String contentType = Files.probeContentType(Paths.get(child.getAbsolutePath()));
                    if(contentType != null && contentType.startsWith("image/")) {
                        this.imagesList.add(child.getAbsolutePath());
                    }
                    logger.log(Level.INFO, "CAASO: probe: {0}", Files.probeContentType(Paths.get(child.getAbsolutePath())));
                } catch(IOException ex) {
                    logger.log(Level.INFO, "CAASO: probe: {0}", ex);
                }

            }
        }
    }

    public String getNext() {
        if(this.imagesList.isEmpty()) {
            return null;
        }
        this.currentIndex++;
        if(this.currentIndex < 0 || this.currentIndex >= this.imagesList.size()) {
            this.currentIndex = 0;
        }
      //  System.out.println("getNext: "+this.currentIndex);
        return this.imagesList.get(this.currentIndex);
    }

    public String getPrevious() {
        if(this.imagesList.isEmpty()) {
            return null;
        }

        this.currentIndex--;
        if(this.currentIndex < 0 || this.currentIndex >= this.imagesList.size()) {
            this.currentIndex = this.imagesList.size()-1;
        }

   //     System.out.println("getPrevious: "+this.currentIndex);

        return this.imagesList.get(this.currentIndex);
    }
}
