package ie.tudublin;

import processing.core.PApplet;

public class Test extends Poly{

    public Test (ProjectVisual v){
        super(v);
    }

    @Override
    public void render(){
        for (int i =0; i< v.getAudioBuffer().size(); i++){
            v.pushMatrix();
            //float c = PApplet.map(i, 0, v.getAudioBuffer().size() , 0, 255);
            float c = PApplet.map(v.getAudioBuffer().get(i), -1, 0 , 0, 255);
            v.noFill();
            v.stroke(c,255,255);
            //v.circle((v.getAudioBuffer().get(i) * 2) + v.width/2, (v.getAudioBuffer().get(i) * 2) + v.height/2, v.getAudioBuffer().get(i) * 1000);
            v.circle(v.width/2,v.height/2, v.getSmoothedAmplitude() * i*i); // Idea for potential transition between viuals
            //v.translate(v.width/2, v.height/2);
            //v.box(v.getSmoothedAmplitude() * i*i); // Idea for potential transition between viuals
            v.popMatrix();

        }
    }

}
