package ie.tudublin;

public class Grave extends Poly {

    public Grave (ProjectVisual v){
        super(v);
    }

    public void render(){
        v.translate(v.width / 2, v.height/2);
        v.scale(100);
        v.shape(v.grave);
    }
    
}
