package ie.tudublin;

public class Tree{

    float start;
    float amplitude; 
    float angle = 0;
    ProjectVisual v;

    Tree[] trees;

    public Tree (ProjectVisual v, float start, float amplitude, float angle, int branches){
        this.v = v;
        this.start = start;
        this.amplitude = amplitude;
        this.angle = angle;

        branch(branches);
    }

    //method to create the branches of the tree
    void branch(int branches){

        if( branches > 0){
            trees = new Tree[2];
            v.branchCounter +=2;

            float angle = ProjectVisual.map(v.getSmoothedAmplitude(), 0 , 1 ,ProjectVisual.PI/10f, ProjectVisual.PI / 2f);
            
            trees[0] = new Tree(v, start-amplitude, amplitude/1.5f, angle, branches - 2);
            trees[1] = new Tree(v, start-amplitude, amplitude/1.5f, -angle, branches - 2);

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

