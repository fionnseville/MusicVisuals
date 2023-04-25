package ie.tudublin;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.BeatDetect;
import processing.core.PApplet;

public class Cubesquared extends Poly{
    public Cubesquared (ProjectVisual v){
        super(v);
    }

    
    int off_max = 450;
    int yo,xo,zo;
    Minim minim;
    AudioPlayer player;
    BeatDetect beat;
    int beatcount =0;
    @Override
    public void render() {
        
       v.colorMode(PApplet.RGB); 
       v.background(0);
       v.translate( v.width/2, v.height/2, -off_max*1.3f);
       v.rotateY(v.frameCount*0.01f);
       v.rotateX(v.frameCount*0.01f);
       v.rotateZ(v.frameCount*0.01f);

       if(beat.isOnset()){
        beatcount++;
       }
       int BeatType=1;
       if(beatcount %10 == 0){
        BeatType = (int)v.random(1,2);
    }
      
       for (xo = -off_max;xo<=off_max ; xo +=50) {
        for(yo = -off_max;yo<=off_max; yo +=50){
            for(zo=-off_max;zo<=off_max;zo+=50){
                v.pushMatrix();
                v.translate(xo, yo , zo);
                v.rotateY(v.frameCount*0.2f);
                v.rotateX(v.frameCount*0.2f);
                v.rotateZ(v.frameCount*0.2f);
                
                

                switch (BeatType) {
                    case 1:
                        v.stroke(zo, yo, xo, off_max);
                        v.strokeWeight(5);
                        break;
                
                    case 2:
                        v.stroke(0);
                        v.strokeWeight(5);
                        v.fill(zo,yo,xo,off_max);
                        break;
                }
                //float c = PApplet.map(zo, 0, v.//getAudioBuffer().size(),0,150);
                //v.fill(c,255,255);
                v.box(v.getSmoothedAmplitude()*200);
                //v.sphere(v.getSmoothedAmplitude());;
                v.popMatrix();
            }
        }
       }
       
    }
}
