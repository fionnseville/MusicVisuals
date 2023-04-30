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
    float cRange;
    

    v.translate(v.width/2, v.height/2);
    
    for(float a = 0; a<360; a+=22.5f){ //used to create circular rotation lower value for 'a' means more cirles and tighter rotation can also cause lag if too low
      v.rotate(-ProjectVisual.radians(a));
      v.noStroke();
      v.pushMatrix();
      //v.noStroke();
      
      for (int i=0; i <num; i++){ //used for drawing the circles and to allow for rotation in positive direction
        if(v.beat.isKick()){
          cRange = 2000;
        }
        else{
          cRange = 3000;
        }
        diameter = v.getSmoothedAmplitude() * 600; //diametre of ellipse linked to song
        float c = PApplet.map(i,0, v.getAudioBuffer().size() , 0, cRange);
        //v.fill(v.getAudioBuffer().get(i)*i*i*i,100,100);
        v.fill(c,100,100);
        v.scale(0.95f); //0.95-og //0.98 // 0.5 //0.8
        v.rotate(ProjectVisual.radians(angle)/2);// /2
        v.ellipse(x, 0, diameter, diameter); //first two x,y second width height
        
      }
      v.popMatrix();
      
      v.pushMatrix();
      for (int i=0; i <num; i++){ //used for drawing the circles and to allow for rotation in positive direction
        
        if(v.beat.isKick()){
          cRange = 2000;
        }
        else{
          cRange = 3000;
        }
          diameter = v.getSmoothedAmplitude() * 600;
          float c = PApplet.map(i, 0, v.getAudioBuffer().size() , 0, cRange);
          //v.fill(v.getAudioBuffer().get(i)*i*i*i,150,250);
          v.fill(c,150,250);
          v.scale(0.95f); //0.95-og //.98 // 0.5f //0.8
          v.rotate(-ProjectVisual.radians(angle)/2); //reverses angle of rotation // /2
          v.ellipse(x, 0, diameter, diameter); //first two x,y second width height
        
      }
      v.popMatrix();
      

    }

    angle+=(PApplet.map(v.getSmoothedAmplitude(), 0, 1.0f, 0, 1f));
      
  }

    

}
