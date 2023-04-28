package ie.tudublin;

import processing.core.PApplet;

public class Space extends Poly
{
    public Space(ProjectVisual v) {
        super(v);
    }
    
    @Override
    public void render()
    {
        v.calculateAverageAmplitude();
        v.background(0);
        //random HSB colours
        float h = v.random(255);
        float s = v.random(255);
        float b = v.random(255);

        //create background stars + lazers
        
        stars();
        //wave();
        //lazers();
        planets();
        arcs();
        
        

        //SLOW IT DOWN LATER!!! !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //cubed globe drawing and rotation
        v.fill(0);
        v.translate(v.width/2, v.height/2, 0);
        v.rotateY(v.radians(v.frameCount));
        v.stroke(PApplet.map(v.getSmoothedAmplitude(), 0, h, s, b), 255, 255);
        v.sphere(150);
        //adds more sections to the sphere mesh, looks like disco ball mirrors
        v.sphereDetail(70);
        
    }

    void planets()
    {
        //ROTATE THEM LATER
        //push/pop used to keep styles and rotation to these elements only
        v.pushStyle();
        v.push();
        v.noStroke();
        v.fill(311, 98, 100);
        v.circle(300, 370, 300 * v.getSmoothedAmplitude());
        v.pop();
        v.popStyle();

        v.pushStyle();
        v.push();
        v.noStroke();
        v.fill(194, 99, 99);
        v.circle(810, 470, 450 * v.getSmoothedAmplitude());
        v.pop();
        v.popStyle();

        v.pushStyle();
        v.push();
        v.noStroke();
        v.fill(60, 99, 99);
        v.circle(445, 810, 200 * v.getSmoothedAmplitude());
        v.pop();
        v.popStyle();
        
    }

    void arcs()
    {
        //creates 3 circles around main planet
        for(int i = 0; i < 600; i += 150)
        {
            v.pushStyle();
            v.noFill();
            v.stroke(255);
            //using ellipse so i can use mode to center it
            v.ellipseMode(v.CENTER);
            v.ellipse(v.width/2, v.height/2, 300 + i, 300 + i);
            v.popStyle();
        }
        
    }

    void wave()
    {
        //random colours
        float hue = v.random(255);
        float sat = v.random(255);
        float bri = v.random(255);
        int i = -1000;//starts off screen so there's an even bounce accross the wave
        float a = 0;
        
        while(i < v.width)
        {
            float j = v.map(v.sin(a * v.getSmoothedAmplitude()), -1, 1, 20, 250);
            v.stroke(hue, sat, bri);
            v.circle(i, j + 350, 5);
            i += 1;
            a += 0.09;
        }
        
    }
    //function for background stars
    void stars()
    {
        for(int i = 0; i < 50; i++)
        {
            float randStars = v.random(1000);
            float randStars2 = v.random(1000);
            v.fill(50, 50, 100);
            v.stroke(50, 100, 100);
            v.circle(randStars, randStars2, 5);
        }
    }
    
    //function for lazer disco lights
    //I WANT THEM TO BEAT OUTWARDS, NOT WORKING ENTIRELY
    void lazers()
    {
        int size = 110;
        float height = v.height/2;
        float a = 0;
        
        
        
        for(int i = size; i < v.width - size; i = i + size)
        {
            for(int j = size; j < v.height - size; j = j + size)
            {
                v.pushStyle();
                v.lights();
                v.stroke(255);
                v.strokeWeight(3);
                v.line(i, j, v.width/2, v.height/2);
                v.popStyle();
            }
        }
    }
}
