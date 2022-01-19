package com.lscc.gol;
import java.util.Scanner;

public class Game {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);  // Create a Scanner object (user inputs)

        // erster Teil: Gittermodell erstellen
        Grid grid = new Grid(10);
        boolean fertig = false;
        int Zellenzähler = 0;

        while (fertig == false){
            Zellenzähler += 1;
            System.out.println(Zellenzähler+".Zelle");
            //X Koordinate
            System.out.println("X-Koordinate(0-9) für die lebende Zelle: ");
            int x_coordinate = getcoordinate();
            if (x_coordinate == -1){
                System.out.println("Breche die Zelle ab");
                fertig = true;
            }else{
                //Y Koordinate
                System.out.println("Y-Koordinate(0-9) für die lebende Zelle: ");
                int y_coordinate = getcoordinate();
                if (y_coordinate == -1){
                    System.out.println("Breche die Zelle ab");
                    fertig = true;
                }else{
                    grid.put(LiveCell.INSTANCE, x_coordinate, y_coordinate);
                    //x/y Koordinaten werden weitergegeben, in das Grid "grid" eingegeben
                }
            }

        }
        //SO! erster Teil fertig.
        System.out.print("Bitte Enter drücken um das Gittermodell anzuzeigen");
        String input = sc.nextLine();

        if (input.equals("")){
            System.out.println(grid); //first grid
        }

        //zweiter Teil: durch alle Generationen gehen und darstellen
        boolean wiederholung = false;
        while (wiederholung == false){
            Grid nextGrid = grid.nextGeneration();
            System.out.println(nextGrid);
            if (grid.equals(nextGrid) == true){
                wiederholung = true; //quitting while loop
                //System.out.println("sind gleich");
            }
            grid = nextGrid;
            input = sc.nextLine();
            if (input.equals("q")){
                wiederholung = true; //quitting while loop
            }
        }



    }
    static int getcoordinate(){

        int integer = -1;
        boolean zufrieden = false;
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        while (zufrieden == false) {
            String input = sc.nextLine();// Get input from the user
            if (input.equals("")){ //User pressed Enter key
                return -1; //die -1 wird im return so verwendet, dass es die Zelle abbricht

            }else{
                try {
                    integer = Integer.parseInt(input);
                    if (integer > -1 && integer < 10){
                        zufrieden = true;
                    }else{
                        System.out.println("Die Zahl muss zwischen 0 und 9 liegen!");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Error! Das war kein Integer. Versuchen Sie es erneut.");
                }
            }
        }
        return integer;
    }
}
