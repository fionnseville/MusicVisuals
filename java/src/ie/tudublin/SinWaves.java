package ie.tudublin;

import processing.core.PApplet;
import processing.core.PConstants;

public class SinWaves extends Poly{

    public SinWaves(ProjectVisual v) {
        super(v);
       
    }

    float angle = 0.0f;


    @Override
    public void render() {
        

        v.background(0); 
        int gridSize = 20;
        float boxSize;

    
        
        v.translate(v.width / 2, v.height / 2, 0);
        //v.rotateX(v.radians(v.frameCount));
        //v.rotateY(v.radians(v.frameCount));
        //v.rotateZ(v.radians(v.frameCount));

        for (int x = -gridSize / 2; x < gridSize / 2; x++) {
            for (int y = -gridSize / 2; y < gridSize / 2; y++) {
            for (int z = -gridSize / 2; z < gridSize / 2; z++) {
                float offsetX = x * gridSize * (v.getSmoothedAmplitude()*12);
                float offsetY = y * gridSize * (v.getSmoothedAmplitude()*12);
                float offsetZ = z * gridSize * (v.getSmoothedAmplitude()*12);
                //float offsetX = x * gridSize * 2;
                //float offsetY = y * gridSize * 2;
                //float offsetZ = z * gridSize * 2;
                float distance = v.dist(0, 0, offsetX, offsetY);
                //boxSize=20;
                boxSize = (v.sin(v.radians(angle + distance)) + 1) * 20;
                v.pushMatrix();
                v.translate(offsetX, offsetY, offsetZ-400);
                v.fill((offsetX + v.frameCount) % 255, (offsetY + v.frameCount) % 255, (offsetZ + v.frameCount) % 255);
                v.noStroke();
                v.box(boxSize);
                v.popMatrix();
            }
            }
        }
        angle += 2;
    }
    
}
