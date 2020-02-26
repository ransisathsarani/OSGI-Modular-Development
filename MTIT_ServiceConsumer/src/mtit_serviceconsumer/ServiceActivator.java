package mtit_serviceconsumer;

import java.util.Scanner;

import com.mtit.service.ServiceProduce;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ServiceActivator implements BundleActivator {
	
	ServiceReference serviceReference;

	Scanner scanner = new Scanner(System.in);
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Start Consumer Service");
		serviceReference = context.getServiceReference(ServiceProduce.class.getName());
		ServiceProduce serviceProduce = (ServiceProduce) context.getService(serviceReference);
		System.out.println(serviceProduce.produceService());
		
		System.out.println("---------------Welcome to COFFEE SHOP-----------------");
		System.out.println("------------------------------------------------------");
		System.out.println("----------------------MENU----------------------------");
		System.out.println("1 - Latte     -----> Rs.540.00");
		System.out.println("2 - Cappucino -----> Rs.690.00");
		System.out.println("3 - Espresso  -----> Rs.720.00");
		System.out.println("------------------------------------------------------");
		
		System.out.println("Select the Coffee you want to buy: ");

		Scanner scanner = new Scanner(System.in);
		int itemType = scanner.nextInt();
		if(itemType == 1) {
			System.out.println("Enter qty:");
			Scanner sc = new Scanner(System.in);
			int qty = sc.nextInt();
			int price = 540;
			int totPrice = serviceProduce.calculateTotal(price, qty);
			System.out.println("Total Amount: Rs." + totPrice + " /=");
			System.out.println("Thank you!!! Come agin");
			
		}
		else if(itemType == 2) {
			System.out.println("Enter qty:");
			Scanner sc = new Scanner(System.in);
			int qty = sc.nextInt();
			int price = 690;
			int totPrice = serviceProduce.calculateTotal(price, qty);
			System.out.println("Total Amount: Rs." + totPrice + " /=");
			System.out.println("Thank you!!! Come agin");
			
		}
		else if(itemType == 3) {
			System.out.println("Enter qty: ");
			Scanner sc = new Scanner(System.in);
			int qty = sc.nextInt();
			int price = 720;
			int totPrice = serviceProduce.calculateTotal(price, qty);
			System.out.println("Total Amount: Rs. " + totPrice + " /=");
			System.out.println("Thank you!!! Come again");
		}
		else {
			
			System.out.println("Exit");
		}
		
	}
	
	

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye!!!");
		context.ungetService(serviceReference);
	}

}
