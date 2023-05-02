package ie.tudublin;

import processing.core.PApplet;

public class WaveyVisual extends Poly{

    public WaveyVisual(ProjectVisual v) {
        super(v);
    }

    float t;
    float boxspeed=2;
    float scaleFactor;
    @Override
    public void render() {
        v.background(0);
        v.lights();

        float numberOfVisuals = 5;//30 *v.getSmoothedAmplitude();
        /*if(v.frameCount%90 >=60){
            numberOfVisuals =numberOfVisuals*2;
        } 
        if(v.frameCount%90 <=60 &&v.frameCount%90<=30){
            numberOfVisuals =numberOfVisuals*4;
        } */

        for (int k = 0; k < numberOfVisuals; k++) {
            v.pushMatrix();
            v.translate(v.width / (numberOfVisuals + 1) * (k + 1), v.height / 2, 0);
            v.rotateX(t / 5);
            v.rotateY(t / 7);
            v.rotateZ(t / 9);
            //float scaleFactor = PApplet.map(v.getSmoothedAmplitude(), 0,1, 0, 2);

            //v.rotateX(PApplet.radians(t / 5)*20);
            //v.rotateY(PApplet.radians(t / 7)*20);
            //v.rotateZ(PApplet.radians(t / 9)*20);

            for (int i = 0; i < 130; i++) {
                //float c=PApplet.map(i, 0, v.getAudioBuffer().size(), 0, 255);
                v.fill(- i * 8, i * 8, i * 8);
                //v.fill(c,150,250);
                draw(i, t);
                v.fill(i * 8, 255 - i * 8, i * 8);
                draw(i, -t);
            }
            v.popMatrix();
        }

        t += 0.2f;//PApplet.map(v.getSmoothedAmplitude(), 0, 1, 0, 7);
    }

    public void draw(int i, float rotation) {
        v.pushMatrix();
        float x = v.sin((rotation + i) / 10) * 200;
        float y = v.cos((rotation + i) / 10) * 200;
        float z = v.sin((rotation + i) / 5) * 100;
        v.translate(x, y, z);

        float boxSize = v.cos((rotation + i) / 10) *20 ;
        //v.scale(scaleFactor);
        v.box(boxSize);
        for (int j = 0; j < 8; j++) {
            v.pushMatrix();
            v.rotateY(v.radians(j * 45));
            v.translate(boxSize * 1.2f, 0, 0);
            v.box(boxSize* 0.4f);
            v.popMatrix();
        }
        v.popMatrix();
    }
}

