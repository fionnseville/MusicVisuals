package ie.tudublin;

import java.util.ArrayList;

public class ProjectVisual extends Visual {

    private int mode = 0;

    public void settings(){
		size(1024, 1024, P3D);
	}

	public void setup(){
        colorMode(HSB,360,100,100);
		startMinim();
		loadAudio("Bee Gees - Stayin' Alive (Official Music Video).wav");
		startListening();
	}

    Poly test = new Test(this);

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
       
        test.render();
      
      
    }   
    
}
