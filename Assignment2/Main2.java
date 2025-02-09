interface Fly{  //insted of defining fly method inside  Bird which assumes that all birds can fly we use an interface 
      void fly();
}

class CanFly implements Fly{  //there is an heirachy here as canfly and cannotfly implements fly specifying their behavior.

 public  void fly(){
    System.out.println("Can FLY");
   }
}

class CannotFly implements Fly{
     
 public  void fly(){
 	System.out.println("Cannot Fly");
    }
}

abstract class Bird{  //bird is an abstract class
       protected Fly checkFly;
       protected String name;

	Bird(String name,Fly checkFly){
        this.checkFly=checkFly;
        this.name=name;
       
        }

      void canUfly(){
      	/*checkFly.fly();*/
      	System.out.println(""+name+ " ");
      	checkFly.fly();
      	System.out.println("");
      }
     
}


class Sparrow extends Bird{//sparrow is given canfly behaviour 
	Sparrow(){
            super("Sparrow",new CanFly());
           }
 

}
class Penguin extends Bird{

       Penguin(){  //penguin is given cannotfly behaviour
            super("Penguin",new CannotFly());
          }
 
}
//so Liskows Substitution Principle is used in proper way without any violations 
public class Main2{
	public static void main(String[] args){
          		Bird sparrow=new Sparrow();
		          sparrow.canUfly();
		          Bird penguin=new Penguin();
		          penguin.canUfly();
          }

}


