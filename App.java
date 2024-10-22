// Tl 10/3/24
// zooVersion01.java

package tran.zoo.com;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;




public class App {

    private static String calcAnimalBirthDate(int age, String theSeason) {
        // This is all of the date stuff we did last week:
        // Create a Date object to represent the current date
        Date today = new Date();

        // Define the desired date format
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");

        // Format the date and store it in a string
        String strTodaysDate = formatter.format(today);
        String strTodaysYear = formatterYear.format(today);

        // Output the result
        System.out.println("Today's date in the format yyyy-MM-dd: " + strTodaysDate);

        String animalBirthdate = "";
        int todaysYear = Integer.parseInt(strTodaysYear);
        int animalBirthYear = todaysYear - Integer.parseInt(String.valueOf(age));


        // Normalize the input season to lower case for case-insensitive comparison
        String season = theSeason.toLowerCase();

        switch (season) {
            case "spring":
                animalBirthdate = Integer.toString(animalBirthYear) + "-03-21";
                break;
            case "fall":
                animalBirthdate = Integer.toString(animalBirthYear) + "-09-21";
                break;
            case "winter":
                animalBirthdate = Integer.toString(animalBirthYear) + "-12-21";
                break;
            case "summer":
                animalBirthdate = Integer.toString(animalBirthYear) + "-06-21";
                break;
            default:
                animalBirthdate = Integer.toString(animalBirthYear) + "-01-01"; // Default case for anything else
                break;
        }

        return animalBirthdate;

    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Welcome to my Zoo Program!");

        // Create the animal name lists.
        // Call Utilities to get the animal name lists
        String filePath = "C:\\Users\\Zietr\\JavaProjects\\zooKeeperMidterm\\animalNames.txt";  // Update with the correct file path
        tran.zoo.com.AnimalNameListsWrapper animalLists = tran.zoo.com.Utilities.createAnimalNameLists(filePath);

        // Access the hyena names list
        ArrayList<String> listOfHyenaNames = animalLists.getHyenaNameList();

        // Use a for-each loop to output each hyena name
        System.out.println("Hyena Names:");
        for (String hyenaName : listOfHyenaNames) {
            System.out.println(hyenaName);
        }

        // Similarly, you can do this for the other animal lists
        ArrayList<String> listOfLionNames = animalLists.getLionNameList();
        System.out.println("\nLion Names:");
        for (String lionName : listOfLionNames) {
            System.out.println(lionName);
        }

        ArrayList<String> listOfTigerNames = animalLists.getTigerNameList();
        System.out.println("\nTiger Names:");
        for (String tigerName : listOfTigerNames) {
            System.out.println(tigerName);
        }

        ArrayList<String> listOfBearNames = animalLists.getBearNameList();
        System.out.println("\nBear Names:");
        for (String bearName : listOfBearNames) {
            System.out.println(bearName);
        }




        BufferedReader reader = null;

        try {
            // Create a BufferedReader to read the file
            reader = new BufferedReader(new FileReader("arrivingAnimals.txt"));
            String line;

            // Read each line of the file until reaching the end
            while ((line = reader.readLine()) != null) {
                // Print each line to the console
                System.out.println(line);
                // Parse this line of text.
                String[] arrayOfStrPartsOnComma = line.split(", ");
                // output the array elements
                // this is a for : each loop - very handy when examining array elements.
                int elementNum = 0;
                for (String thePart : arrayOfStrPartsOnComma) {
                    System.out.println("Element " + elementNum + " of arrayOfStrPartsOnComma is: " + thePart);
                    elementNum++;
                }
                System.out.println();
                String[] arrayOfStrPartsOnSpace = arrayOfStrPartsOnComma[0].split(" ");
                elementNum = 0;
                for (String thePart : arrayOfStrPartsOnSpace) {
                    System.out.println("Element " + elementNum + " of arrayOfStrPartsOnSpace is: " + thePart);
                    elementNum++;
                }
                System.out.println();

                String[] arrayOfStrPartsOnSpace02 = arrayOfStrPartsOnComma[1].split(" ");
                elementNum = 0;
                for (String thePart : arrayOfStrPartsOnSpace02) {
                    System.out.println("Element " + elementNum + " of arrayOfStrPartsOnSpace02 is: " + thePart);
                    elementNum++;
                }
                System.out.println();

                String ageInYears = arrayOfStrPartsOnSpace[0];
                String animalBirthSeason = arrayOfStrPartsOnSpace02[2];
                System.out.println("The age in years of the animal is: " + ageInYears);
                System.out.println("The season of birth of the animal is: " + animalBirthSeason);

                // this is a unit test - we are testing the Animal constructor we just created
                tran.zoo.com.Animal myNewAnimal = new tran.zoo.com.Animal("male", 4, 70, "Zig", "Hy01", "2020-3-21", "brown spots", "from San Diego Zoo");

                // Prove it!
                System.out.println("\n this is the new animal!\n");
                System.out.println("\n ID is: " + myNewAnimal.getAnimalID() + " and... name is: " + myNewAnimal.getAnimalName() + "\n");


                // add Utilities
                System.out.println("animal birthdate is: " + calcAnimalBirthDate(Integer.parseInt(ageInYears), animalBirthSeason));


            }
        } catch (IOException e) {
            // Handle exceptions, such as file not found or I/O errors
            e.printStackTrace();
        } finally {
            // Close the BufferedReader in the finally block to ensure it gets closed
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}