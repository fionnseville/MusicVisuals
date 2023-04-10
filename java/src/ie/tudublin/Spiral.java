package ie.tudublin;

import processing.core.PApplet;

public class Spiral extends Poly{

   float theta;
   float radius;

    public Spiral(ProjectVisual v){
        super(v);
    }

   

    @Override
    public void render(){
        //NOTE: ON BEAT SWITCH BETWEEN FILL AND NOFILL
        for(int i = 0; i< v.getAudioBuffer().size(); i++){
            v.pushMatrix();
            v.noFill();
            float c = PApplet.map(i, 0, v.getAudioBuffer().size() , 0, 255);
            //v.fill(c,255,255);
            v.stroke(c,255,255);
            theta = PApplet.map(i, 0, v.getAudioBuffer().size(),0 , PApplet.TWO_PI*10);
            radius = PApplet.map(i, 0, v.getAudioBuffer().size(), 100, 1000);
            float x = PApplet.sin(theta) * radius; // calculates the x co-ordinate of the next circle within the spiral
            float y = PApplet.cos(theta) * radius; // calculates the y co-ordinate of the next circle within the spiral
            //v.circle(x+v.width/2, y+v.height/2, v.getAudioBuffer().get(i) * 150);
            v.circle(x+v.width/2, y+v.height/2, v.getSmoothedAmplitude()* 1000);
            //v.square(x + v.width/2, y + v.height/2, v.getSmoothedAmplitude() * 1000);
           //v.line(x+v.width/2 , y + v.height/2, x+v.width/2 * i, y + v.height/2 * i);
           //v.translate(x + v.width/2, y + v.height/2);
           //v.box(v.getSmoothedAmplitude() * 1000);
            v.popMatrix();
        }

    }

}
