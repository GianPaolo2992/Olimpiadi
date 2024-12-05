package view;



import cotroller.AthleteController;
import cotroller.DisciplineController;
import cotroller.SportsController;
import service.SportsService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int entityChoice= 0;
        System.out.println("scegli tra le seguenti opzioni");

        System.out.println("1. Atleta");
        System.out.println("2. Disciplina");
        System.out.println("3. sport");


         entityChoice = scanner.nextInt();
        scanner.nextLine();
        do {
            if(entityChoice == 1){
                System.out.println("***Menu***");
                System.out.println("1. crea un nuovo atleta");
                System.out.println("2. lista atleti");
                System.out.println("3. aggiorna atleta ");
                System.out.println("4.  elimina atleta");
                System.out.println("9. Exit");
                System.out.print("Inserisci la tua scelta: ");
                choice = scanner.nextInt();
                AthleteController athleteController = new AthleteController();
                switch(choice){
                    case 1:
                        athleteController.create();
                        break;
                    case 2:
                        athleteController.read();
                        break;
                    case 3:
                        athleteController.update();
                        break;
                    case 4:
                        athleteController.delete();
                    case 9:
                        System.out.println("exiting");
                        break;
                    default:
                        System.out.println("Scelta errata. Scegliere un numero da 1 a 4 o 9");
                }
            }
            else if(entityChoice == 2){
                System.out.println("***Menu***");
                System.out.println("1. crea un nuova disciplina");
                System.out.println("2. lista discipline");
                System.out.println("3. aggiorna disciplina ");
                System.out.println("4. elimina disciplina");
                System.out.println("9. Exit");
                System.out.print("Inserisci la tua scelta: ");
                choice = scanner.nextInt();
                DisciplineController disciplineController = new DisciplineController();
                switch(choice){
                    case 1:
                        disciplineController.create();
                        break;
                    case 2:
                        disciplineController.read();
                        break;
                    case 3:
                        disciplineController.update();
                        break;
                    case 4:
                        disciplineController.delete();
                    case 9:
                        System.out.println("exiting");
                        break;
                    default:
                        System.out.println("Scelta errata. Scegliere un numero da 1 a 4 o 9");
                }
            }
            else if(entityChoice == 3){
                System.out.println("***Menu***");
                System.out.println("1. crea un nuova disciplina");
                System.out.println("2. lista Sport");
                System.out.println("3. aggiorna disciplina ");
                System.out.println("4. elimina disciplina");
                System.out.println("9. Exit");
                System.out.print("Inserisci la tua scelta: ");
                choice = scanner.nextInt();
                SportsController sportsController = new SportsController();
                switch(choice){
                    case 1:
                         sportsController.create();
                        break;
                    case 2:
                        sportsController.read();
                        break;
                    case 3:
                         sportsController.update();
                        break;
                    case 4:
                        sportsController.delete(); // da controllare il funzionamento.
                    case 9:
                        System.out.println("exiting");
                        break;
                    default:
                        System.out.println("Scelta errata. Scegliere un numero da 1 a 4 o 9");
                }
            }

        }while(choice != 9);

        scanner.close();




    }

}