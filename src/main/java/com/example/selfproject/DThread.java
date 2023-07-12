package com.example.selfproject;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class DThread extends Thread{

    FileInfo fileInfo;
    String downloadPath;
    public DThread (FileInfo fileInfo, String downloadPath){
        this.fileInfo = fileInfo;
        this.downloadPath = downloadPath;
    }
    @Override
    public void run() {
        System.out.println("Downloading Started...");
        fileInfo.setStatus("Downloading");
        //Download Logic
        try{
            String u = fileInfo.getUrl();
            URL link = new URL(u);
//            Path path = Paths.get("E:\\" + u.substring(u.lastIndexOf("/")));
            Path path = Paths.get(downloadPath);
            InputStream in = new BufferedInputStream(link.openStream());
            FileOutputStream out = new FileOutputStream(path.toFile());

            long filesize = link.openConnection().getContentLengthLong();
            long downloadedBytes = 0;

            byte[] buffer = new byte[1024];
            int bytesread;

            while((bytesread = in.read(buffer, 0 , buffer.length)) != -1){
                out.write(buffer, 0, bytesread);
                downloadedBytes += bytesread;

                double per = (double) downloadedBytes/filesize;
                fileInfo.setProgress(per);
                DecimalFormat df = new DecimalFormat("0.00");
                fileInfo.setPercentage(Double.parseDouble(df.format(per * 100)));
            }

            System.out.println("Downloaded");
            fileInfo.setStatus("Completed");
        }catch(Exception e){
            fileInfo.setStatus("Failed");
            e.printStackTrace();
        }
    }
}
