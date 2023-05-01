package ie.tudublin;

public class WaveyVisual extends Poly{

    public WaveyVisual(ProjectVisual v) {
        super(v);
    }

    float t;
    float boxspeed=2;
    @Override
    public void render() {
        v.background(0);
        v.lights();

        int numberOfVisuals = 5; 

        for (int k = 0; k < numberOfVisuals; k++) {
            v.pushMatrix();
            v.translate(v.width / (numberOfVisuals + 1) * (k + 1), v.height / 2, 0);
            v.rotateX(t / 5);
            v.rotateY(t / 7);
            v.rotateZ(t / 9);

            for (int i = 0; i < 130; i++) {
                v.fill(255 - i * 8, i * 8, i * 8);
                draw(i, t);
                v.fill(i * 8, 255 - i * 8, i * 8);
                draw(i, -t);
            }
            v.popMatrix();
        }

        t += 0.2;
    }

    public void draw(int i, float rotation) {
        v.pushMatrix();
        float x = v.sin((rotation + i) / 10) * 200;
        float y = v.cos((rotation + i) / 10) * 200;
        float z = v.sin((rotation + i) / 5) * 100;
        v.translate(x, y, z);
        float boxSize = v.cos((rotation + i) / 10) * 20;
        v.box(boxSize);
        for (int j = 0; j < 8; j++) {
            v.pushMatrix();
            v.rotateY(v.radians(j * 45));
            v.translate(boxSize * 1.2f, 0, 0);
            v.box(boxSize * 0.4f);
            v.popMatrix();
        }
        v.popMatrix();
    }
}

