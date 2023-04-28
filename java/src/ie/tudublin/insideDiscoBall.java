package ie.tudublin;
import java.util.ArrayList;

import com.jogamp.opengl.util.packrect.Rect;

import ddf.minim.analysis.BeatDetect;
import processing.core.PApplet;
import processing.core.PVector;

public class insideDiscoBall extends Poly
{
    public insideDiscoBall(ProjectVisual v) {
        super(v);
    }

    @Override
    public void render()
    {
        v.background(0);
        v.stroke(255);

        //triangles();
        //circles();
        test();

    }

    void test()
    {
        
    }

    void circles()
    {
        //random colours
        float hue = v.random(255);
        float sat = v.random(255);
        float bri = v.random(255);
        float frames = v.frameCount / 40.0f;
        int i = -1000;//starts off screen so there's an even bounce accross the wave
        float a = 0;
        
        while(i < v.width)
        {
            float j = v.map(v.sin(a * v.getSmoothedAmplitude()), -1, 1, 20, 250);
            v.stroke(hue+i, sat+i, bri+i);
            v.rotateX(frames);
            v.circle(i, j + 350, 5);
            i += 1;
            a += 0.09;
        }
    }

    //FINISHED
    void triangles()
    {
        //random colours
        float hue = v.random(255);
        float sat = v.random(255);
        float bri = v.random(255);

        //triangles roate and line up every orbit
        for(int i = 0; i < v.getAudioBuffer().size();i++)
        {
            v.noFill();
            v.stroke(hue+i, sat+i, bri+i);
            v.rotate(v.radians(v.frameCount));
            v.translate(v.getAudioBuffer().size(), 0);
            v.triangle(900+i, 100+i, 700+i, 100+i, 800+i, 300+i);
            v.triangle(200+i, 100+i, 200+i, 200+i, 400+i, 200+i);
        }
    }
}

