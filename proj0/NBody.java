public class NBody {
	
   /** the fucntion is to readRadius from a given file*/
   public static double readRadius(String fileName) {
        In file = new In(fileName);
        file.readInt();
        double radius = file.readDouble();
        return radius;
    }

   /** the function is to return an array of Planets listed in the given file*/
   public static Planet[] readPlanets(String fileName) {
   	    In file = new In(fileName);
   	    int numOfPlanets = file.readInt();
   	    double radius = file.readDouble();
   	    Planet[] Planets= new Planet[numOfPlanets];
   	    for (int i = 0; i < numOfPlanets; i++) {
   	    	double xxp = file.readDouble();
   	    	double yyp = file.readDouble();
   	    	double xxv = file.readDouble();
   	    	double yyv = file.readDouble();
   	    	double mass = file.readDouble();
   	    	String name = file.readString();
   	    	Planets[i] = new Planet(xxp, yyp, xxv, yyv, mass, name);
   	    }
        return Planets;
   }

   public static void main(String args[]) {
      double T = Double.parseDouble(args[0]);
      double dt = Double.parseDouble(args[1]);
      double time = 0;
      String filename = args[2];
      double r = readRadius(filename);
      Planet[] planets = readPlanets(filename);
      /** draw background and all of the planets */
      StdDraw.setXscale(-2 * r, 2 * r);
      StdDraw.setYscale(-2 * r, 2 * r);
      StdDraw.clear();
      StdDraw.picture(-2 * r, 2 * r, "images/starfield.jpg");
      StdDraw.show();
      for (int i = 0; i < planets.length; i++) {
        planets[i].Draw();
      }
      StdDraw.show();
      
      /** To create an animation */
      StdDraw.enableDoubleBuffering();
      while (time < T) {
      /** create an xForces array and yForces array */
          double[] xForces = new double[planets.length];
          double[] yForces = new double[planets.length];
      /** stores netforces of each Planet in the xForces and yForces arries */
          for (int j = 0; j < planets.length; j++) {
            xForces[j] = planets[j].calcNetForceExertedByX(planets);
            yForces[j] = planets[j].calcNetForceExertedByY(planets); 
          }
      /** update the status of each planet */
          for (int i = 0; i < planets.length; i++) {
            planets[i].update(dt, xForces[i], yForces[i]);
          }
      /** draw background and all the planets */
          StdDraw.setXscale(-2 * r, 2 * r);
          StdDraw.setYscale(-2 * r, 2 * r);
          StdDraw.clear();
          StdDraw.picture(-2 * r, 2 * r, "images/starfield.jpg");
          StdDraw.show();
          for (int i = 0; i < planets.length; i++) {
            planets[i].Draw();
          }
          StdDraw.show();
          StdDraw.pause(10);
          time += dt;

      }   

      /** printing the universe */
          StdOut.printf("%d\n", planets.length);
          StdOut.printf("%.2e\n", r);
          for (int i = 0; i < planets.length; i++) {
             StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
             planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
             planets[i].yyVel, planets[i].mass, planets[i].imgFileName); 
          }

   }

}

   
      