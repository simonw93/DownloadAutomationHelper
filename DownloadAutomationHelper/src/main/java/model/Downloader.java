/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import main.Constants;

/**
 *
 * @author simon
 */
public class Downloader {
    
    public Downloader () {
        initializeFilesystem();
    }
    
    public void downloadFile (String pUrl, String pTargetFile) throws MalformedURLException, IOException {
    System.out.println("Trying to download from "+pUrl+" into file "+pTargetFile);
    URL website = new URL(pUrl);
    ReadableByteChannel rbc = Channels.newChannel(website.openStream());
    FileOutputStream fos = new FileOutputStream(new File(pTargetFile));
    long transferedBytes = fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    System.out.println("Success! "+transferedBytes+" Bytes were downloaded.");
    }
    
    /**
     * Used to initialize the needed folders.
     */
    private void initializeFilesystem() {
        File downloadDir = new File(Constants.DLFOLDER);
        File picDir = new File(Constants.PICFOLDER);
        File vidDir = new File(Constants.VIDFOLDER);
        File soundDir = new File(Constants.SNDFOLDER);
        File otherDir = new File(Constants.OTHERFOLDER);
        
        if (!downloadDir.exists() && !picDir.exists() && !vidDir.exists() && !soundDir.exists() && !otherDir.exists()) {
        if (downloadDir.mkdirs()) {
            System.out.println("Successfully initialized main folder!");
        }
        else {
            System.out.println("Error while trying to initialize main folder!");
        }
        
        if (picDir.mkdir()) {
            System.out.println("Successfully initialized pictures folder!");
        }
        else {
            System.out.println("Error while trying to initialize picture folder!");
        }
        
        if (vidDir.mkdir()) {
            System.out.println("Successfully initialized video folder!");
        }
        
        else {
            System.out.println("Error while trying to initialize video folder!");
        }
        
        if (soundDir.mkdir()) {
            System.out.println("Successfully initialized sound folder!");
        }
        
        else {
            System.out.println("Error while trying to initialize sound folder!");
        }
        
        if (otherDir.mkdir()) {
            System.out.println("Successfully initialized other folder!");
        }
        else {
            System.out.println("Error while trying to initialize other folder!");
        }
      }
        else {
            System.out.println("Folders already exist.");
        }
    }
}
