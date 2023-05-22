import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Test
{
	public static void main(String[] args)
	{
		stolpe();
		rem();
		spaer();
	}

	public static void stolpe(){

		// support pillars that go to the ground ( vertical)

		JavaCSG csg = JavaCSGFactory.createDefault();

		var stolpe= csg.box3D(15,10,100,false);
		var cutout = csg.box3D(10, 10, 6, false);

		stolpe = csg.difference3D(stolpe, cutout);

		csg.view(stolpe);
	}

	public static void rem(){
		// horizontal support

		JavaCSG csg = JavaCSGFactory.createDefault();

		var rem= csg.box3D(10,10,200,false);

		csg.view(rem);
	}

	public static void spaer(){
		//horizontal tag support

		JavaCSG csg = JavaCSGFactory.createDefault();


		var spaer= csg.box3D(120,10,10,false);
		var cutout = csg.box3D(10, 10, 3, false);

		for ( int x = -1; x < 2; x++) {
			for (int y = -1; y < 1; y++){
				cutout = csg.box3D(10, 10, 3, false);
				cutout = csg.translate3D(50*x, 30*y, 0).transform(cutout);
				spaer = csg.difference3D(spaer, cutout);
			}
		}

		csg.view(spaer);
	}
}
