//

interface PaymentMethod{  //this paymentmethod interface contains only onemethod relevant to all payment methods.classes are not forced to implemt unnecessary methods adhering to Interface Segration Principle
	void pay(double amount);
}



class  CreditCard implements PaymentMethod {  //here there is only one reponsibility for this class adhering to Single Responsibility Principle
	public void pay(double amount){
		System.out.println("PAID "+amount+" using CREDIT CARD");
	}

}

class PayPal  implements PaymentMethod{ //here there is only one reponsibility for this class adhering to Single Responsibility Principle
	public void pay(double amount){
		System.out.println("PAID "+amount+" using PAYPAL");
	}

}


//now if we want to add new payment method we can create google pay class implementing payment method adhering to open close principle
class GooglePay implements PaymentMethod{ //here there is only one reponsibility for this class adhering to Single Responsibility Principle
	
	public void pay(double amount){
		System.out.println("PAID "+amount+" using GooglePay");
	}


}

//payment method can be replaced by credit card and paypal without altering the expected behaviour ..adhering to Liskov Substitution Principle 
class PaymentProcess{ //it follows SRP because it is repsponsible for only processing payments 

//PaymentProcessor depends on Payment method rather than those which are implemented like creditcard or paypal ensuring that the logic of the code is not changed and switching of payment methods happens seamlessly
	private PaymentMethod method;

 	public PaymentProcess(PaymentMethod method){
		this.method=method;
	}

	public void process(double amount){
		method.pay(amount);
       }

}
 
public class PaymentProcessSystem{
	public static void main(String[] args){
		PaymentProcess creditcard=new PaymentProcess(new CreditCard());
	creditcard.process(100);
	
	PaymentProcess paypal=new PaymentProcess(new PayPal());
	paypal.process(200);
	
	PaymentProcess googlepay=new PaymentProcess (new GooglePay());
	googlepay.process(300);
	}
}
