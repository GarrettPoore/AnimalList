/*
This class contains all of the elements that will add, edit, and remove the animals from the list
 */
package animallist;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu 
{
    //Singleton creation
    private static final Menu INSTANCE = new Menu();
    public static Menu getInstance()
    {
        return INSTANCE;
    }
    private Menu(){}
    
    //Animals list
    private ArrayList<Animal> animals = new ArrayList<>();
    
    //Input scanner
    Scanner keyboard = new Scanner(System.in);
    
    //Obtains the reference to the array list
    public void shareArrayList(ArrayList<Animal> animal){
        this.animals = animal;
    }
    
    //Options for the main menu
    public MenuOptions mainMenu(){        
        int choice = 0; //User selection
        boolean flag; //Exit flag
        
        //Main menu header
        System.out.println();
        System.out.println("Please type a corrosponding number with one "
                + "of the options below:");
        System.out.println("Add - 1");
        System.out.println("Edit - 2");
        System.out.println("Delete - 3");
        System.out.println("Or type any other number to exit.");
        
        //Selection loop
        do{
            try{
                //Parse the selection
                choice = Integer.parseInt(keyboard.nextLine());
                flag = false;
            }
            catch (Exception ex){
                System.out.println("Please enter a whole number.");
                flag = true;
            }
        }while(flag);
            
        //Return the correct enumeration
        switch (choice){
            case 1:
                return MenuOptions.ADD;
            case 2:
                return MenuOptions.EDIT;
            case 3:
                return MenuOptions.DELETE;
            default:
                return MenuOptions.EXIT;
        }            
    }
        
    //Menu option to add a new animal to the list
    public void addMenu(){
        this.animals.add(createAnimal());
    }
    
    //Menu option to edit an existing item in the list
    public void editMenu()
    {
        int selection; //Selection of animal item
        Animal animal = new Animal(); 
        boolean flag;
        boolean exitToMainMenu = false;
        
        int count = 1;
        //Verify if there are any animals in the list
        if (animals.isEmpty()){
            //Display error and exit method
            System.out.println("There are no animals in the list.");
            return;
        }
        else{
            //List the animals
            for (Animal listAnimal : animals) {
                System.out.println(count + " - " + listAnimal.getName());
                System.out.println();
                count++;
            }
        }
        
        //Edit menu header
        System.out.println("Please enter the number of the animal you wish to edit, "
                + "or any other number to return to the main menu:");
        System.out.println();
        
        //Obtain the selection from the user
        do{
            try{
                selection = Integer.parseInt(keyboard.nextLine());
                animal = animals.get(selection-1);
                flag = false;
            }
            //If a number was not eneted, maintain the loop
            catch(NumberFormatException ex){
                System.out.println("Please enter a whole number.");
                flag = true;
            }
            //If the array find fails, then the user entered a different number
            //So, exit the loop and the method
            catch(Exception ex){
                exitToMainMenu = true;
                break;
            }
        }while(flag);
        
        //Exit the method
        if (exitToMainMenu){
            return;
        }
        
        //Show the user's selection
        System.out.println("You have chosen the following:");
        animal.displayAnimal();
        System.out.println();
        
        //Edit the animal
        createAnimal(animal);
    }
    
    //Menu option to delete an existing item in the list
    public void deleteMenu()
    {
        int selection;
        boolean flag;
        
        int count = 1;
        //Verify if there are any animals in the list
        if (animals.isEmpty()){
            //Display error and exit method
            System.out.println("There are no animals in the list.");
            return;
        }
        else{
            //List the animals
            for (Animal listAnimal : animals) {
                System.out.println(count + " - " + listAnimal.getName());
                System.out.println();
                count++;
            }
        }
        
        //Delete menu header
        System.out.println("Please enter the number of the animal you wish to delete, "
                + "or any other number to return to the main menu:");
        System.out.println();
        
        //Obtain the selection
        do{
            try{
                selection = Integer.parseInt(keyboard.nextLine());
                animals.remove(selection-1); //Remove the selected animal
                flag = false;
            }
            //If a number was not eneted, maintain the loop
            catch(NumberFormatException ex){
                System.out.println("Please enter a whole number.");
                flag = true;
            }
            //If the array find fails, then the user entered a different number
            //So, exit the the method
            catch(Exception ex){
                break;
            }
        }while(flag);
    }
    
    //Displays all of the animals
    public void displayMenu(){
        System.out.println();
        for (Animal animal : animals) {
            animal.displayAnimal();
            System.out.println();
        }
        
    }
    
    
    
    //Creates an animal object
    //The method will either accept an exiting animal, or create a new one
    private Animal createAnimal(Animal... optionalAnimal){
        
        Animal animal = new Animal();
        
        //Check for an animal arg
        if (optionalAnimal.length > 0){
            animal = optionalAnimal[0];
        }
        
        //Variables
        char input;
        boolean flag;
        
        //Obtain the name of the animal
        System.out.println("Please enter the name of the animal: ");
        do{
            animal.setName(keyboard.nextLine());
            
            //Check if the name is blank
            if ("".equals(animal.getName().trim())){
                
                System.out.println("Please enter the name of the animal.");
                flag = true;
            }
            else{
                flag = false;
            }
        }while(flag);
        
        //Obtain the color of the animal
        System.out.println("What color is the " + animal.getName());
        do{
            animal.setColor(keyboard.nextLine());
            
            //Check if the color is blank
            if ("".equals(animal.getColor().trim())){
                
                System.out.println("Please enter the color of a " + animal.getName() + ".");
                flag = true;
            }
            else{
                flag = false;
            }
        }while(flag);
        
        //Ask if the animal has fur
        System.out.println("Does the " + animal.getName() + " have fur? (Enter y for yes and n for no)");
        do{
            input = keyboard.next().charAt(0);
            
            //Parse the selection
            switch (Character.toString(input)) {
                
                case "y": case "Y":
                    animal.setHasFur(true);
                    flag = false;
                    break;
                    
                case "n": case "N":
                    animal.setHasFur(false);
                    flag = false;
                    break;
                    
                default:
                    System.out.println("Please enter either \"y\" or \"n\".");
                    flag = true;
                    break;
            }
        }while(flag);
        
        //Ask if the animal is a vertebrate
        System.out.println("Is the " + animal.getName() + " a vertebrate? (Enter y for yes and n for no)");
        do{
            input = keyboard.next().charAt(0);
            
            //Parse the selection
            switch (Character.toString(input)) {
                
                case "y": case "Y":
                    animal.setIsVertebrate(true);
                    flag = false;
                    break;
                    
                case "n": case "N":
                    animal.setIsVertebrate(false);
                    flag = false;
                    break;
                    
                default:
                    System.out.println("Please enter either \"y\" or \"n\".");
                    flag = true;
                    break;
            }
        }while(flag);
        
        //Ask if the animal can fly
        System.out.println("Can the " + animal.getName() + " fly? (Enter y for yes and n for no)");
        do{
            input = keyboard.next().charAt(0);
            
            //Parse the selection
            switch (Character.toString(input)) {
                
                case "y": case "Y":
                    animal.setCanFly(true);
                    flag = false;
                    break;
                    
                case "n": case "N":
                    animal.setCanFly(false);
                    flag = false;
                    break;
                    
                default:
                    System.out.println("Please enter either \"y\" or \"n\".");
                    flag = true;
                    break;
            }
        }while(flag);
        
        //Return the new animal
        return animal;
    }
}
