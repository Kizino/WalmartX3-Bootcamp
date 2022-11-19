import java.lang.Thread;

public class Mars {
    public static void main(String[] args){
        String ColonyName = "MushroomKingdom";
        int ShipPopulation = 300;
        double ShipFood = 4000.00;
        boolean Landing = true;
        String LandingLocation = "The Hill";

        ShipFood = remaining_food(ShipFood, ShipPopulation, 2);
        System.out.println("Remaining Food: " + ShipFood);

        ShipFood = ShipFood + ShipFood * 0.5;
        System.out.println("Remaining Food: " + ShipFood);

        ShipPopulation += 5;
        System.out.println("Current Population: " + ShipPopulation);

        if(LandingLocation.equalsIgnoreCase("The Hill")){
            System.out.println("Bbzzz Landing on the Plain");
        } else{
            System.out.println(("ERROR!!! Flight plan already set. Landing on the Plain"));
        }

        Landing = LandingCheck(100);
    }

    public static double remaining_food(double currentFood, int population, int days){
        double remainFood = currentFood;
        for(int i = 0; i < days; i++){
            remainFood = remainFood - (population * 0.75);
        }

        return remainFood;
    }

    public static boolean LandingCheck(int Loops){
        for(int i = 0; i < Loops; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("Keep Center");
            } else if (i % 5 == 0) {
                System.out.println(("Right"));
            } else if (i % 3 == 0) {
                System.out.println("Left");
            }else {
                System.out.println("Calculating");
            }

            try{
                Thread.sleep(250);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }

        System.out.println("Landed");

        return false;
    }
}
