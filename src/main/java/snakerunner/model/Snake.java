package snakerunner.model;

public class Snake {

    private Position position; // use class position
    private double speed;
    private String currentDirection;//memorises where it's going
    public String imageName;

    public Snake() {
        //first position spawn
        this.position = new Position(50, 200);
        this.speed = 2.0; //will be removed once we have te levels
        this.currentDirection = "RIGHT";
        this.imageName = "head_right.png";
    }

      public void setSpeed(double newSpeed){
        this.speed =newSpeed;
    }

    //Move is called by the GameLoop
    //the snake goes in the direction set

    public void move() {
        int x =position.getX();
        int y =position.getY();

        switch (currentDirection){
            case "UP": y -=speed;  break;
            case "DOWN": y+= speed; break;
            case "LEFT": x -= speed; break;
            case "RIGHT": x+= speed; break;
        }

        this.position = new Position(x,y);
    }

    public void setDirectionUp(){
        if (!currentDirection.equals("DOWN")){
            this.currentDirection = "UP";
            this.imageName = "head_up.png";

        }
    }

    public void setDirectionDown(){
        if(!currentDirection.equals("UP")){
            this.currentDirection = "DOWN";
            this.imageName = "head_down.png";

        }
    }

    public void setDirectionLeft(){
        if(!currentDirection.equals("RIGHT")){
            this.currentDirection = "LEFT";
            this.imageName = "head_left.png";
        }
    }

    public void setDirectionRight(){
        if (!currentDirection.equals("LEFT")){
            this.currentDirection = "RIGHT";
            this.imageName = "head_right.png";
        }
    }

  
  // Getter to allow position reading
    public Position getPosition() {
        return this.position;
    }

    public String getImage(){
        return this.imageName;
    }

    public double getSpeed() {
        return this.speed;
    }
}