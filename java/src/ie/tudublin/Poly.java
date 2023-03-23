package ie.tudublin;

public abstract class Poly {
    ProjectVisual v;

    public Poly(ProjectVisual v){
        this.v = v;
    }

    public abstract void render();
}
