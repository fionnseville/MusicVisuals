package ie.tudublin;

import java.time.chrono.ThaiBuddhistChronology;

import ddf.minim.Minim;
import ddf.minim.analysis.BeatDetect;
import javazoom.jl.player.Player;
import processing.core.PImage;
import processing.core.PShape;

public class ProjectVisual extends Visual {

    //private int mode = 0;
    
    PShape eye;
    PShape grave;
    PImage texture;
    

    public void settings(){
		//size(1024, 1000, P3D);
        fullScreen(P3D,SPAN);
	}

	public void setup(){
        colorMode(HSB,360,100,100);
		startMinim();
		loadAudio("Bee Gees - Stayin' Alive (Official Music Video).wav");
        beat = new BeatDetect(ap.bufferSize(),ap.sampleRate());
        //eye = loadShape("eyeball.obj");
        //grave = loadShape("gravestone.obj");
        //texture = loadImage("gravestone.mtl");
        noiseSeed(0l);
		startListening();
	}
    
    float distance = 0;
    float distanceChange = 0.001f;

    Poly spiral = new Spiral(this);
    Poly spiral2 = new Spiral2(this);
    Poly graves = new Grave(this);
    Poly cubes = new Cubesquared(this);
    Poly cubes2 =new Cubesquared2(this);
    Poly sins = new SinWaves(this);
    Poly waves= new WaveyVisual(this);

	public void draw(){

        stroke(255,255,255);
    
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();        
       
        //spiral.render();
        //graves.render();
        //cubes.render();
        cubes2.render();
        //sins.render();
        //waves.render();
    }   
    
}
    