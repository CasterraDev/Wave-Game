public class BoxCollider {

    float x;
    float y;
    float width;
    float height;

    public BoxCollider(float x,float y,float width,float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //DOES NOT WORK CORRECTLY
    //Gives multiple hits instead of just one
    public boolean intersects(BoxCollider bc){
        int tw = (int)this.width;
        int th = (int)this.height;
        int rw = (int)bc.width;
        int rh = (int)bc.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = (int)this.x;
        int ty = (int)this.y;
        int rx = (int)bc.x;
        int ry = (int)bc.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }
}
