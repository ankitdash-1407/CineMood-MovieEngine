import java.util.ArrayList;
import java.util.Scanner;

public class MovieEngine {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        ArrayList<Movie> database = new ArrayList<>();

        database.add(new Movie("Interstellar","sci-fi",9.9));
        database.add(new Movie("pk","drama",9.2));
        database.add(new Movie("Rockstar","romance",8.5));
        database.add(new Movie("Chainsaw","gore",7.0));
        database.add(new Movie("Ashiqui 2","romance",6.6));


        while (true) {

            System.out.print("Enter the title/Genre of the movie u wanna search or type exit to f off ! ");
            String userChoice = keyboard.nextLine();

            if (userChoice.equalsIgnoreCase("exit")){
                System.out.println("going off !!! bye.");
                break;
            }

            double ratingPrefd = 0.0;

            System.out.print("Rating preferences (type maximum ratings out of 10 or type SPACEBAR to skip.) ");
            String ratingPrefstr = keyboard.nextLine().trim();
            if (ratingPrefstr.isEmpty()){
                 ratingPrefd = 0.0;
            }
            else {
                 ratingPrefd = Double.parseDouble(ratingPrefstr);
            }

            boolean found = false;

            for (int i=0; i < database.size(); i++){
                if (userChoice.equalsIgnoreCase(database.get(i).title) || userChoice.equalsIgnoreCase(database.get(i).genre) && database.get(i).rating >= ratingPrefd){
                    System.out.println("Movie Found !!");
                    System.out.println("____________________________________________________");
                    System.out.println("TITLE: "+database.get(i).title);
                    System.out.println("GENRE: "+database.get(i).genre);
                    System.out.println("RATING: "+database.get(i).rating);
                    System.out.println("____________________________________________________");
                    found = true;
                }
            }
            if (!found){
                System.out.println("____________________________________________________");
                System.out.print("Is "+userChoice+" a movie title(wanna add it to the database)?(yes / no)");
                String yesNo = keyboard.nextLine();
                if (yesNo.equalsIgnoreCase("no")){
                    System.out.println("Sorry, we will definitely work on our database!");

                }
                else {
                    System.out.println("Adding to database.");
                    System.out.print("Type the genre of " + userChoice + " : ");
                    String newGenre = keyboard.nextLine();
                    System.out.print("Type the rating of the movie : ");
                    double newRating = keyboard.nextDouble();
                    keyboard.nextLine();
                    database.add(new Movie(userChoice, newGenre, newRating));
                    System.out.println("____________________________________________________");
                    System.out.println("DATABASE UPDATED");
                }

            }
        }
        keyboard.close();
    }
}
