public class Bicycle{
  private int cadence;
  private int speed = 0;
  private int gear;

  Bicycle(int cadence, int gear) {
    this.cadence = cadence;
    this.gear = gear;
  }
  
  int getCadence(){
    return this.cadence;
  }
  
  void setCadence(int newValue){
    this.cadence = newValue;
  }
  
  int getGear(){
    return this.gear;
  }
    
  void setGear(int newValue){
    this.gear = newValue;
  }
  
  int getSpeed(){
    return this.speed;
  }
  
  void applyBrake(int decrement){
    this.speed -= decrement;
  }
  
  void speedUp(int increment){
    this.speed += increment;
  }
  
  @override
  public String toString(){
    return "Bicycle: " +this.speed + " mph"; 
  }

  public static void main(String args[]){
    final Bicycle bike = new Bicycle(2,0,1);
    System.out.println(bike);
  }
}
