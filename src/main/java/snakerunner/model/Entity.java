package snakerunner.model;

public class Entity {
    protected int x;
    protected int y;   
   
   
  
  public void generate(){

  }
   //To read the coordinates
    public int getX(){
       return x;
    }
    public int getY(){
       return y;
    }

//Setting the coordinates
public void setX(int x){
    this.x= x;

}
public void setY(int y){
    this.y=y;
}

   
}
