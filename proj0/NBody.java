public class NBody {
  public static double readRadius( String fileName){
    /* Start reading in file.txt */
    In in = new In(fileName);
    int count = 0;
    while(!in.isEmpty()) {
      count ++;
      if (count == 2){
        return in.readDouble();
      }
      in.readInt();
    }
    return 0;
  }

  public static Planet[] readPlanets( String fileName ){
    Planet[] planets = new Planet[1];
    int numPlanents = 0;
    int lineNum = 0 ;
    /* Start reading in file.txt */
    In in = new In(fileName);
    while(!in.isEmpty()) {
      lineNum ++;
      if (lineNum == 1){
        numPlanents = in.readInt();
        planets = new Planet[numPlanents];
      }
      if (lineNum == 2){
        in.readDouble();
      }
      if (lineNum > 2){
        double xxPos = in.readDouble();
        double yyPos = in.readDouble();
        double xxVel = in.readDouble();
        double yyVel = in.readDouble();
        double mass = in.readDouble();
        String img = in.readString();
        Planet planet = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
        planets[lineNum - 3] = planet;
        if (planets[numPlanents -1] != null ){
          return planets;
        }
      }
    }
    return planets;
  }

  public static void main( String[] args){
    if( args.length != 3){
      System.out.println("please provide the required 3 inputs ");
      System.out.println("1: T - length of time to run simulation");
      System.out.println("2: dt - interval of time to update simulation");
      System.out.println("3: fileName - file with the intial state of simulation");
      System.exit(1);
    }
    try{
      double time = Double.paresDouble(args[0]);
      double dt = Double.paresDouble(args[1]);
      Strig fileName = args[3];
    }
    catch (Exception e) {
      System.out.println("Please provide the required 3 inputs ");
      System.exit(1);
    }

    double r = readRadius(fileName);
    Planet[] palnets = readPlanets(fileName);
    
   }

}
