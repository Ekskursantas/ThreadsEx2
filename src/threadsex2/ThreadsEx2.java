/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsex2;

/**
 *
 * @author przyg
 */
public class ThreadsEx2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UrlThread1 thread1 = new UrlThread1("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
        UrlThread1 thread2 = new UrlThread1("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
        UrlThread1 thread3 = new UrlThread1("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");
        thread1.run();
        thread2.run();
        thread3.run();
    }
    
}
