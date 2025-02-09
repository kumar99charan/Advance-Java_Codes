//in the version given in question class employee is doing responsibilities like printing ,storing data .....and there is no reusage of code.....to further better the code we can use SRP and OCP 



class Employee{         //SRP states that there should be only one reponsibily of a class
  private String Name;
  private double salary;

 Employee (String Name,double salary){
    this.Name=Name;
    this.salary=salary;
   }
 public String getName(){
    return Name;
  }
  
 public double getSalary(){
   return salary;
   }

  
}

class PaySlip{   //this class has only one functionanlity that is to print....and it sticks to SRP 
    	void  printPaySlip(Employee employee){
              System.out.println("Emplyee Name:"+employee.getName()+" Salary:"+employee.getSalary());
      }
  
}

interface Storage{   //according to OCP , we need to  open for extension  but closed for modification
     void Store(Employee employee); //new functionality can be added without changing the old functionality

 }


class toDatabase implements Storage{  //so we can store emplpoyee in database by just calling the store function without modifying
    public  void Store(Employee employee){
          System.out.println("Storing "+employee.getName()+" to DataBase");
     }

}

class toFile implements Storage{ //we can store employee in the file by just calling the store function 
    public void Store(Employee employee){
       System.out.println("Stroing "+employee.getName()+" to File"); 
   } 
 }

public class Main1{
  public static void main(String[] args){
      Employee emp1= new Employee("Charan",500000);
      PaySlip pay1= new PaySlip();
      pay1.printPaySlip(emp1);
      toDatabase store1=new toDatabase();
      store1.Store(emp1);
      toFile store2=new toFile();
      store2.Store(emp1);
  }

}
