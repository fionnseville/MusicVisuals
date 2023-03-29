package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Circle extends Poly {

    PVector position;// controls position of the circle
    PVector mov;// controls movement of the circle
    float rot;// rotation
    float cx;
    float cy;
    
    public Circle(ProjectVisual v, float rot,float cx, float cy){
        super(v);
        position = new PVector(cx,cy);
        mov = new PVector(0,-1);
        rot = 0.1f;
    }

    float lerpedBuffer[];
    
    @Override
    public void render(){
        v.background(0);
        for(int i = 0 ; i < v.getAudioBuffer().size() ; i ++)
        {
            float c = PApplet.map(v.getAudioBuffer().get(i), -1, 1, 0, 255);
            
            v.stroke(c,255,255);
            v.fill(c,255,255);
            v.pushMatrix();
            v.translate(position.x,position.y);
            v.rotate(rot);
            v.circle(position.x,position.y,v.getSmoothedAmplitude()*500);
            v.popMatrix();
        }
    }

    public void move(){
        mov.x = PApplet.sin(rot);
        mov.y = -PApplet.cos(rot);

        position.add(PVector.mult(mov, 5));

        if(position.x < 0 || position.x > v.width || position.y < 0 || position.y > v.height)
        {
           v.circles.remove(this);
        }
    }
}
