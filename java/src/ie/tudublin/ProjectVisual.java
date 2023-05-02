package ie.tudublin;

import java.util.ArrayList;


import ddf.minim.analysis.BeatDetect;

public class ProjectVisual extends Visual {

    private int mode = 0;

    public void settings(){
		//size(1024, 1024, P3D);
        fullScreen(SPAN,P3D);

	}

	public void setup(){
        colorMode(HSB,360,100,100);
		startMinim();
        rectMode(CENTER); 
		loadAudio("Bee Gees - Stayin' Alive (Official Music Video).wav");
        beat = new BeatDetect(getAudioPlayer().bufferSize(), getAudioPlayer().sampleRate());
        beat.setSensitivity(10);
        bl = new BeatListener(beat, getAudioPlayer());
		startListening();
        colorMode(HSB, 360, 100, 100);
	}

    Poly spiral = new Spiral(this);
    Poly kal = new kalidascope(this);
    Poly bloom = new Bloom(this);
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

        switch(mode)
        {
            case 1:
                background(0);
                bloom.render();
            break;

            case 2:
                background(0);
                kal.render(); 
            break;

            case 3:
                background(0);
                spiral.render();
            break;

            case 4:
                background(0);
                cube.render();
            break;
        }
        
    }   
    
    public void keyPressed() 
    {
		if (key >= '0' && key <= '9') 
        {
			mode = key - '0';
		}
	}
}
