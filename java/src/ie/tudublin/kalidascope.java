package ie.tudublin;
import java.util.ArrayList;

import com.jogamp.opengl.util.packrect.Rect;

import ddf.minim.analysis.BeatDetect;
import processing.core.PApplet;
import processing.core.PVector;

public class kalidascope extends Poly
{
    float start = v.millis();

    public kalidascope(ProjectVisual v) {
        super(v);
    }

    @Override
    public void render()
    {
        v.background(0);
        v.stroke(255);

        middle();
    }

   

    void middle()
    {
        float sw = 0.7f;
        v.translate(v.width/2, v.height/2);
        int count = 0;

        

        for(int i = 0; i < 2000;i+=60)
        {
            //rotate entire shape
            
            float radius = 100+i;
            //map of bluish pinkish colours
            v.rotate(PApplet.radians(v.frameCount));
            float c = PApplet.map(count, 0, v.getAudioBuffer().size() , 200, 400);
            
            v.beginShape();
            
            
            //create pentagons
            for(float a = 0; a < v.TWO_PI; a+=v.TWO_PI/8)
            {
                float x = radius * v.cos(a);
                float y =  radius * v.sin(a);
                //changes stroke weight on beat
                if(v.beat.isHat())
                {
                    v.strokeWeight(sw);
                    sw+=0.02;
                }
               
                v.noFill();
                v.stroke(c, 150, 200);
                v.vertex(x*v.getSmoothedAmplitude(), y*v.getSmoothedAmplitude());
                //v.circle(x*v.getSmoothedAmplitude()+100, y*v.getSmoothedAmplitude()+100, 20);
                //v.rect(x*v.getSmoothedAmplitude()+100, y*v.getSmoothedAmplitude()+100, 20,20);
                count++;
            }
            
            v.endShape();
        }

        
    }

   
}

