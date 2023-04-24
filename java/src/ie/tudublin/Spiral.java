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
      v.background(0);

      float x = v.width;
      float diameter = 150;
      int num = 100;

      angle+=(PApplet.map(v.getSmoothedAmplitude(), 0, 1.0f, 0, 2f));

      v.translate(v.width/2, v.height/2);

      for(float a = 0; a<360; a+=22.5f){ //the amount of circles and the size of the gaps between them
        v.rotate(-ProjectVisual.radians(a));
        v.noStroke();
        v.pushMatrix();
        for (int i=0; i <num; i++){
            //diameter = v.getSmoothedAmplitude() * 500; //diametre of ellipse linked to song
            float c = PApplet.map(i, 0, v.getAudioBuffer().size() , 0, 150);
            v.fill(200,100,100);
            v.scale(0.95f);
            v.rotate(ProjectVisual.radians(angle));
            v.ellipse(x, 0, diameter, diameter); //first two x,y second width height
            
            //v.box(diameter);
            //v.circle(x, 0, diameter*2);
        }
        v.popMatrix();

        v.pushMatrix();
        for (int i=0; i <num; i++){
            //diameter = v.getSmoothedAmplitude() * 500;
            float c = PApplet.map(i, 0, v.getAudioBuffer().size() , 0, 150);
            v.fill(c,100,100);
            v.scale(0.95f);
            v.rotate(-ProjectVisual.radians(angle)); //reverses angle of rotation
            v.ellipse(x, 0, diameter, diameter); //first two x,y second width height
            //v.box(diameter);
            //v.circle(x, 0, diameter*2);
        }
        v.popMatrix();
      }

      //angle+=0.1f;
        
    }

    

}
