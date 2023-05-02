package ie.tudublin;

import java.util.ArrayList;

import ddf.minim.analysis.BeatDetect;

public class ProjectVisual extends Visual {

    private int mode = 0;
    float start = millis();

    public void settings(){
		size(1024, 1024, P3D);
        fullScreen();
	}

	public void setup(){
        colorMode(HSB,360,100,100);
		startMinim();
        rectMode(CENTER); 
		loadAudio("Bee Gees - Stayin' Alive (Official Music Video).wav");
        beat = new BeatDetect(getAudioPlayer().bufferSize(), getAudioPlayer().sampleRate());
        beat.setSensitivity(300);
        bl = new BeatListener(beat, getAudioPlayer());
		startListening();
        colorMode(HSB, 360, 100, 100);
	}

    Poly play;
    //Poly spiral = new Spiral(this);
    Poly kal = new kalidascope(this);
    //Poly bloom = new Bloom(this);
    Poly cube = new Cubes(this);


	public void draw(){
    
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
        //
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        //will pulse an object with music volume
        calculateAverageAmplitude();    


        //total = 270000
        //38571
        
       //play = new Bloom(this);

        //kal.render(); 
        //cube.render();
    }   
    
}
