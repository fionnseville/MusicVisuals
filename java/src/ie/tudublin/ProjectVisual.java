package ie.tudublin;

public class ProjectVisual extends Visual {

    //private int mode = 0;
    
    

    public void settings(){
		//size(1024, 1000, P3D);
        fullScreen(P3D);
	}

	public void setup(){
        colorMode(HSB,360,100,100);
		startMinim();
		loadAudio("Bee Gees - Stayin' Alive (Official Music Video).wav");
		startListening();
	}
    
    float distance = 0;
    float distanceChange = 0.001f;

    Poly spiral = new Spiral(this);


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
       
       spiral.render();
    }   
    
}
    