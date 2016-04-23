/*
This program will ask the user to enter properties about animals.
The program will store this data and allow the user to edit the data, or remove it.
Upon completion, the program will print out all of the animals along with their properties.
*/
package animallist;

import java.util.ArrayList;
import java.io.*;
import java.nio.*;

public class AnimalList {

    public static void main(String[] args) {
        //Array list to store the animals
        ArrayList<Animal> animals = new ArrayList<>(); 
        
        //Instance of the menu
        Menu menu = Menu.getInstance();
        
        //Shares the reference of the array list
        menu.shareArrayList(animals);
        
        //Variable to hold the choice of the user
        MenuOptions menuChoice;
        
        //Header
        System.out.println("This program will allow you to add, edit, or remove "
                + "different animals to a list.");
        System.out.println("Later, you can display the characteristics of "
                + "any of those animals.");
        
        do
        {
            //Obtain the choice
            menuChoice = menu.mainMenu();
        
            //Act on the choice
            switch (menuChoice){
                case ADD:
                    menu.addMenu();
                    break;
            
                case EDIT:
                    menu.editMenu();
                    break;
                
                case DELETE:
                    menu.deleteMenu();
                    break;
            }
        }while(menuChoice != MenuOptions.EXIT);
        
        //Display the list
        menu.displayMenu();
        
        try{
            
            File saveFile = new File("Animal_List.txt");
            FileWriter writer = new FileWriter(saveFile);
            PrintWriter printWriter = new PrintWriter(writer);
            
            for(Animal animal: animals){
                
                printWriter.println(animal.getName());
                printWriter.println(animal.getColor());
                printWriter.println(animal.getHasFur());
                printWriter.println(animal.getIsVertebrate());
                printWriter.println(animal.getCanFly());
            }
            
            printWriter.flush();
            printWriter.close();
            
            
        }
        catch (Exception ex){
            System.out.println("Error");
        }            
        
    }
}
