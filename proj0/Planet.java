public class Planet {
	/** Its current x position*/
	public double xxPos;
	/** Its current y position*/
	public double yyPos;
	/** current velocity in the x direction*/
	public double xxVel;
	/** current velocity in the y direction*/
	public double yyVel;
	/** mass*/
	public double mass;
	/** the name of the file that corresponds to the image
	 * that depicts the planet (e.g., jupiter.gif)*/
	public String imgFileName;

	/** VALUE of constant G*/
	public static final double G = 6.67e-11;
   
   
   

	/** Constructor to initialize a planet */
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/** Constructor to initialize the copy of a planet */
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;	
	}
    
    public double calcDistance (Planet X) {
      double distance = Math.sqrt((this.xxPos - X.xxPos)*
                                   (this.xxPos - X.xxPos) +
                                   (this.yyPos - X.yyPos) *
                                   (this.yyPos - X.yyPos));
      return distance; 
   }

    public double calcForceExertedBy(Planet E) {
      
      double force = (G * this.mass * E.mass) / 
         (calcDistance(E) * calcDistance(E));
      return force;
    }

    public double calcForceExertedByX(Planet Q) {
      double forceX = calcForceExertedBy(Q) * (Q.xxPos - this.xxPos) / 
      calcDistance (Q);    
      return forceX;
    }

    public double calcForceExertedByY(Planet Q) {
      double forceY = calcForceExertedBy(Q) * (Q.yyPos - this.yyPos) / 
      calcDistance (Q);    
      return forceY;
    }

   public double calcNetForceExertedByX(Planet[] allPlanets) {
      double netForceX = 0;
      for (int i = 0; i < allPlanets.length; i++) {
         if (this.equals(allPlanets[i])) {
            continue;
         }
         netForceX += this.calcForceExertedByX(allPlanets[i]);
      }
      return netForceX;
   }
      
   
   public double calcNetForceExertedByY(Planet[] allPlanets) {
      double netForceY = 0;
      for (int i = 0; i < allPlanets.length; i++) {
         if (this.equals(allPlanets[i])) {
            continue;
         }
         netForceY += this.calcForceExertedByY(allPlanets[i]);
      }
      return netForceY;
   }

   public void update(double dt, double fX, double fY) {
      
      double ax = fX / this.mass;
      double ay = fY / this.mass;
      this.xxVel = this.xxVel + ax * dt;
      this.yyVel = this.yyVel + ay * dt;
      this.xxPos = this.xxPos + dt * this.xxVel;
      this.yyPos = this.yyPos + dt *this.yyVel;
      
   }

   public void Draw(){
       StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
   }
   

      
   

   

}