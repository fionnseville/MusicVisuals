package ie.tudublin;

import java.util.ArrayList;

public class ProjectVisual extends Visual {

    public static final String PApplet = null;
    private int mode = 0;

    ArrayList<Circle> circles = new ArrayList<Circle>();

    public void settings(){
		size(1024, 1024, P3D);
	}

	public void setup(){
        colorMode(HSB,360,100,100);
		startMinim();
		loadAudio("Bee Gees - Stayin' Alive (Official Music Video).wav");
		startListening();
	}

    Poly spiral = new Spiral(512, 512, this);
    //Poly circle = new Circle(this,0.1f);

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
        for(int i = circles.size()-1; i>=0; i--){
            Circle c = circles.get(i);
            c.render();
            c.move();	
        } 
       // circle.render();
       
      
      
        //float x = width/2;
        //float y = height/2;
       // float radius = 10;
        //float angle = 0;
      
        //for (int i = 0; i < 100; i++) {
        //  float newX = x + cos(angle) * radius;
        //  float newY = y + sin(angle) * radius;
        //  ellipse(newX, newY, radius, radius);
        //  radius += 2;
        //  angle += 0.1;
        //}
      
      
    }   
    
}
