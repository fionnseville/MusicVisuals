package ie.tudublin;

import processing.core.PApplet;

public class Spiral extends Poly{

    public Spiral(ProjectVisual v){
        super(v);
    }


    @Override
    public void render(){
        v.calculateAverageAmplitude();
       v.background(0);
        v.noFill();
        v.stroke(PApplet.map(v.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        v.circle(v.width /2,v.height /2, 500);

    }

}
