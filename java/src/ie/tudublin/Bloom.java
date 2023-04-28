package ie.tudublin;

import processing.core.PApplet;

public class Bloom extends Poly{

    float angle = 0.1f;
    float x;
    float y;


    public Bloom(ProjectVisual v){
        super(v);
    }

    @Override
    public void render() {
        
        v.colorMode(PApplet.RGB);
        v.background(0);
        v.strokeWeight(10); // 25

        v.translate(v.width/2 + x, v.height/2 + y);

        v.pushMatrix();
        for(int i = 0; i < 400; i++){
            v.fill(v.getAudioBuffer().get(i)*i*i,10,255);
            v.fill(v.getAudioBuffer().get(i)*i*i,50,100);
            //v.fill(v.getAudioBuffer().get(i)*i*i,v.getAudioBuffer().get(i)*i*i*i,v.getAudioBuffer().get(i)*i*i);
            v.scale(0.95f);
            v.rotate(PApplet.radians(angle));
            //v.rect(v.getSmoothedAmplitude()*5000,v.getSmoothedAmplitude()*5000,v.getSmoothedAmplitude()*5000,v.getSmoothedAmplitude()*5000);
            v.rect(0,0,v.getSmoothedAmplitude()*5000,v.getSmoothedAmplitude()*5000);
            //v.rect(0,0,700,700);
            //v.rect(v.getSmoothedAmplitude()*5000,v.getSmoothedAmplitude()*5000,700,700);
            
            
        }
        v.popMatrix();

        /*v.pushMatrix();
        for(int i = 0; i < 200; i++){
            v.fill(v.getAudioBuffer().get(i),50,100);
            v.scale(0.98f);
            v.rotate(PApplet.radians(angle));

            v.rect(0,0,v.getSmoothedAmplitude()*5000,v.getSmoothedAmplitude()*5000);
            
        }
        v.popMatrix();
        */
        
        

        //x += (PApplet.map(v.getSmoothedAmplitude(), 0, 1.0f, 0, 2f));
        //y += (PApplet.map(v.getSmoothedAmplitude(), 0, 1.0f, 0, 2f));
        angle+=(PApplet.map(v.getAmplitude(), 0, 1.0f, 0, 2f));

    }
    
}
