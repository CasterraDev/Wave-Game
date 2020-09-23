public class Math {
    public static float clamp(float var,float x,float y){
        if (var < x){
            return var = x;
        }else if (var > y){
            return var = y;
        }else{
            return var;
        }
    }
}
