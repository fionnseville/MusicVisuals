package ie.tudublin;

import processing.core.PApplet;
/* 
class Trees{

    float start;
    float amplitude; 
    float angle = 0;
    ProjectVisual v;

    Trees[] trees;

    public Trees (ProjectVisual v, float start, float amplitude, float angle, int branches){
        this.v = v;
        this.start = start;
        this.amplitude = amplitude;
        this.angle = angle;

        branch(branches);
    }

    //method to create the branches of the tree
    void branch(int branches){

        if( branches > 0){
            trees = new Trees[2];
            v.branchCounter +=2;

            float angle = ProjectVisual.map(v.getSmoothedAmplitude(), 0 , 1 ,ProjectVisual.PI/10f, ProjectVisual.PI / 2f);
            
            trees[0] = new Trees(v, start-amplitude, amplitude/1.5f, angle, branches - 2);
            trees[1] = new Trees(v, start-amplitude, amplitude/1.5f, -angle, branches - 2);

        }
        
    }

    public void render(){

        v.rotate(this.angle);
        v.line(0, 0, 0, amplitude);

        if(trees != null){
            v.translate(0, amplitude);
            v.pushMatrix();
            trees[0].render();
            v.popMatrix();
            trees[1].render();
        }

    }
    
}
*/

public class Testing extends Poly{

    Tree tree1;
    Tree tree2;
    Tree tree3;
    
    public Testing (ProjectVisual v){
        super(v);
    }

    @Override
    public void render(){
       
        v.strokeWeight(1);
        v.fill(0,40);

        // Set the visual canvas constraints
        v.rect(-1, -1, v.width+1, v.height+1);

        // Set default fill and stroke
        v.fill(255);
        v.stroke(255);

        // Increment counter
        v.fCounter++;

        // For loop to create 6 trees
        for( int i = 0; i < 6; i++ ){

            // Replace current matrix with identity matrix
            v.resetMatrix();
            
            // Set the visual display window size
            v.translate(v.width / 2, v.height / 2);

            // Set branch counter to 0
            v.branchCounter = 0;
        
            // Set rotation speed of entire visual
            v.rotate( ProjectVisual.map(v.fCounter%360, 0, 360, 0, v.PI*2));
            v.rotate( ProjectVisual.map((float)i, 0f, 6f, 0f, v.PI*2));

            // Create 3 branches of varying sizes
            tree1 = new Tree(v, 0f, ProjectVisual.map(v.getSmoothedAmplitude(),0,.4f,-v.height/30f,-v.height/4f), 0,16);
            tree2 = new Tree(v, 0f, ProjectVisual.map(v.getSmoothedAmplitude(),0,.4f,-v.height/30f,-v.height/4f), 0,18);
            tree3 = new Tree(v, 0f, ProjectVisual.map(v.getSmoothedAmplitude(),0,.5f,-v.height/15f,-v.height/4f), 0,20);

            // Set the fill and stroke values then show the branch
            v.fill((v.fCounter/10)%255);
            v.stroke((v.fCounter/10)%255,255,255);
            tree1.render();

            // Set the fill and stroke values then show the branch
            v.fill((v.fCounter/2)%255);
            v.stroke((v.fCounter/2)%255,255,255);
            tree3.render();

            // Set the fill and stroke values then show the branch
            v.fill((v.fCounter/1)%255);
            v.stroke((v.fCounter/1)%255,255,255);
            tree2.render();

        }

    }

    
    
}
