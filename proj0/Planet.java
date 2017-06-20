public class Planet {
  double xxPos; // Its current x position
  double yyPos; // Its current y position
  double xxVel; // Its current velocity in the x direction
  double yyVel; // Its current velocity in the y direction
  double mass; // Its mass
  String imgFileName; // The name of an image in the images directory that depicts the planet

  public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = img;
  }

  public Planet( Planet p ){
    xxPos = p.xxPos;
    yyPos = p.yyPos;
    xxVel = p.xxVel;
    yyVel = p.yyVel;
    mass = p.mass;
    imgFileName = p.imgFileName;
  }

  public double calcDistance( Planet p ){
    double dx = p.xxPos - xxPos;
    double dy = p.yyPos - yyPos;
    return Math.sqrt((dx * dx) + ( dy * dy));
  }

  public double calcForceExertedBy( Planet p){
    double r = this.calcDistance(p);
    double g = 6.67408e-11;
    return g * mass * p.mass / (r * r);
  }

  public double calcForceExertedByX ( Planet p){
    double force = this.calcForceExertedBy(p);
    double r = this.calcDistance(p);
    double dx = p.xxPos - xxPos;
    return force * dx / r;

  }

  public double calcForceExertedByY ( Planet p){
    double force = this.calcForceExertedBy(p);
    double r = this.calcDistance(p);
    double dy = p.yyPos - yyPos;
    return force * dy / r;
  }


  public void update(double dt, double fx, double fy){
    double ax = fx / mass;
    double ay = fy / mass;
    xxVel = xxVel + ax * dt;
    yyVel = yyVel + ay * dt;
    xxPos = xxPos + xxVel * dt;
    yyPos = yyPos + yyVel * dt;
  }

}
