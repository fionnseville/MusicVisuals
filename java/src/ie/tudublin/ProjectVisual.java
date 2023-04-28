package ie.tudublin;

import java.util.ArrayList;

import ddf.minim.analysis.BeatDetect;

public class ProjectVisual extends Visual {

    private int mode = 0;

    public void settings(){
		//size(1024, 1024, P3D);
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
	}

   
    Poly spiral = new Spiral(this);
    Poly bloom = new Bloom(this);

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
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();        
       
        spiral.render();
      
    }   
    
}
