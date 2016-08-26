/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsex2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author przyg
 */
public class UrlThread1 extends Thread {

    private String url;
    
    public UrlThread1(String url) {                
        this.url = url;
    }

    
    @Override
    public void run() {
        try {
            sleep(2000);
            System.out.println(getBytesFromUrl(url).length);
        } catch (IOException ex) {
            Logger.getLogger(UrlThread1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(UrlThread1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static byte[] getBytesFromUrl(String url) throws IOException {
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.connect();
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try {
            InputStream is = connection.getInputStream();
            byte[] bytebuff = new byte[4096];
            int read;
            while ((read = is.read(bytebuff)) > 0) {
                bis.write(bytebuff, 0, read);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return bis.toByteArray();
    }
}
