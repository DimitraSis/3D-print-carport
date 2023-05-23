import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

import javax.servlet.ServletException;
import java.util.List;
import java.util.Scanner;

public class Test {


	private static String USER = "root";
	private static String PASSWORD = "123456";
	private static String URL = "jdbc:mysql://localhost:3306/fogcarporte";



	public static void main(String[] args)
	{
		ThreeDPrintDB db = new ThreeDPrintDB(USER, PASSWORD, URL);
		CarportMapper carportMapper = new CarportMapper(db);
		Scanner sc = new Scanner(System.in);
		System.out.println("choose order Id for your given order.");

		String orderId = sc.nextLine();
		int parsedOrderId = Integer.parseInt(orderId);

		List<Carport> listOfCarportsFromOrder = carportMapper.selectCarportsFromOrderId(parsedOrderId);

		for (Carport s: listOfCarportsFromOrder) {
			System.out.println("Carport with Id " + s.getCarportId() + " found.");

		}

		System.out.println("choose the Id of your chosen carport");
		String carportId = sc.nextLine();
		int parsedCarportId = Integer.parseInt(carportId);

		for (Carport t: listOfCarportsFromOrder) {
			if (parsedCarportId == t.getCarportId()) {
				System.out.println("choose to print rem, stolpe or spaer or type anything else to close");
				String choice = sc.nextLine();

				if (choice.equalsIgnoreCase("rem")) {
					rem(t.getLength());
					System.out.println("generating openscad file for rem");
				}

				else if (choice.equalsIgnoreCase("stolpe")) {
					stolpe(t.getHeight());
					System.out.println("generating openscad file for stolpe");
				}

				else if (choice.equalsIgnoreCase("spaer")) {
					spaer(t.getWidth());
					System.out.println("generating openscad file for spaer");

				}

				else {


				}
			}

		}



	}

	public static void stolpe(double height){
/**
 *
 * support pillars that go to the ground ( vertical)
 *
 * z is the variable for the length of stolpe
 */


		JavaCSG csg = JavaCSGFactory.createDefault();

		var stolpe= csg.box3D(15,10,height*30,false);
		var cutout = csg.box3D(10, 10, 6, false);

		stolpe = csg.difference3D(stolpe, cutout);

		csg.view(stolpe);
	}

	public static void rem(double length){
		/**
		 * x is the variable for the length of rem
		 * horizontal support
		 */

		JavaCSG csg = JavaCSGFactory.createDefault();

		var rem= csg.box3D(length*30,10,10,false);

		csg.view(rem);
	}

	public static void spaer(double width){

		/**
		 * x is the variable for the length of spaer
		 *
		 * horizontal tag support
		 */


		JavaCSG csg = JavaCSGFactory.createDefault();


		var spaer= csg.box3D(width*30,10,10,false);
		var cutout = csg.box3D(10, 10, 3, false);

		for ( int x = -1; x < 2; x++) {
			for (int y = -1; y < 1; y++){
				cutout = csg.box3D(10, 10, 3, false);
				cutout = csg.translate3D((width*12)*x, 30*y, 0).transform(cutout);
				spaer = csg.difference3D(spaer, cutout);
			}
		}

		csg.view(spaer);
	}
}
