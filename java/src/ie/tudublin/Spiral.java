package ie.tudublin;

import javax.print.attribute.standard.PrinterMessageFromOperator;

import processing.core.PApplet;
import processing.core.PVector;

public class Spiral extends Poly{

    float angle;
    float[] lerpedBuffer;
    float lerpedAverage = 0;
    float total = 0;
   
    public Spiral(ProjectVisual v){
        super(v);
        lerpedBuffer = new float [v.width];
        
    }

    
   
    @Override
    public void render(){
      //v.colorMode(PApplet.RGB);

      v.background(0);

      float x = v.width;
      float diameter = 150;
      int num = 100;

      

      v.translate(v.width/2, v.height/2);
      //v.fill(0,20);
		  //v.rect(0,0,v.width,v.height);

      for(float a = 0; a<360; a+=22.5f){ //the amount of circles and the size of the gaps between them
        v.rotate(-ProjectVisual.radians(a));
        v.noStroke();
        v.pushMatrix();
        //v.noStroke();
		    
        for (int i=0; i <num; i++){
            
            diameter = v.getSmoothedAmplitude() * 600; //diametre of ellipse linked to song
            float c = PApplet.map(i, 0, v.getAudioBuffer().size() , 0, 150);
            v.fill(v.getAudioBuffer().get(i)*i*i*i,100,100);
            v.fill(200,100,100);
            v.scale(0.95f); //0.95-og //0.98 // 0.5 //0.8
            v.rotate(ProjectVisual.radians(angle)/2);// /2
            v.ellipse(x, 0, diameter, diameter); //first two x,y second width height
            
            //v.box(diameter);
            //v.circle(x, 0, diameter*2);
        }
        v.popMatrix();
        
        v.pushMatrix();
        for (int i=0; i <num; i++){
            diameter = v.getSmoothedAmplitude() * 600;
            float c = PApplet.map(i, 0, v.getAudioBuffer().size() , 0, 150);
            //v.fill(v.getAudioBuffer().get(i)*i*i*i,150,250);
            v.fill(c,150,250);
            v.scale(0.95f); //0.95-og //.98 // 0.5f //0.8
            v.rotate(-ProjectVisual.radians(angle)/2); //reverses angle of rotation // /2
            v.ellipse(x, 0, diameter, diameter); //first two x,y second width height
            //v.box(diameter);
            //v.circle(x, 0, diameter*2);
        }
        v.popMatrix();
        
  
      }

      //angle+=0.1f;
      angle+=(PApplet.map(v.getAmplitude(), 0, 1.0f, 0, 1f));
    }

    
    
}
