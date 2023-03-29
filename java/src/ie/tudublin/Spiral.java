package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Spiral extends Poly{

    private PVector forward;
    private PVector position;
    PApplet p;
    float rot = 0.1f;

    public Spiral(float x, float y, ProjectVisual v){
        super(v);
        forward = new PVector(x,y);
        position = new PVector(x,y);
        
    }

   public void move(){
        forward.x = PApplet.sin(rot);
        forward.y = -PApplet.cos(rot);
        PVector front = PVector.add(position,PVector.mult(forward,30));
        Circle c = new Circle(v,rot, front.x, front.y);
        v.circles.add(c);
        rot -= 0.1f;
    }
   
    @Override
    public void render(){
        Circle c = new Circle(v, rot, position.x, position.y);
        v.pushMatrix(); 
        c.render();
        c.move();
        this.move();
        v.popMatrix();
        
    }

    

}
