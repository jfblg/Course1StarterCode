package module3;

import processing.core.PApplet;
import processing.core.PImage;

public class MyPAplet extends PApplet {

    private String URL = "http://...";
    private PImage img;

    public void setup() {
        size(500, 500);
        background(0,0,0);
//        stroke(0);
//        img = loadImage("palmTrees.jpg", "jpg");
//        img.resize(0, height);
//        image(img, 0, 0); // display image
//        backgroundImg.resize(0, height);

    }

    public void draw() {
//        background(153);
//        line(0,0, width, height);
//        fill(255,209,0);
//        ellipse(width/2, height/2, width/2, height/2);
//        fill(0,0,0);
//        ellipse(120,130,50,70);
//        ellipse(280,130,50,70);
//
//        noFill();
//        arc(200, 280, 75, 75,0, PI);

        int[] color = sunColorSec(second());
        fill(color[0], color[1], color[2]);
        ellipse(width/4, height/5, width/4, height/5);

    }

    public int[] sunColorSec(float seconds) {
        int[] rgb = new int[3];
        float diffFrom30 = Math.abs(30-seconds);
        float ratio = diffFrom30/30;
        rgb[0] = (int)(255*ratio);
        rgb[1] = (int)(255*ratio);
        rgb[2] = 0;

        return rgb;
    }
}
