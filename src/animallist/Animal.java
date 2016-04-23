/*
This class will contain all of the information about each animal
 */
package animallist;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Animal 
{
    //Variables and deafult values
    private String name = "";
    private String color = "";
    private boolean hasFur = false;
    private boolean isVertebrate = false;
    private boolean canFly = false;
    
    //Getters
    public String getName(){
        return name;
    }
    public String getColor(){
        return color;
    }
    public boolean getHasFur(){
        return hasFur;
    }
    public boolean getIsVertebrate(){
        return isVertebrate;
    }
    public boolean getCanFly(){
        return canFly;
    }
    
    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setHasFur(boolean hasFur){
        this.hasFur = hasFur;
    }
    public void setIsVertebrate(boolean isVertebrate){
        this.isVertebrate = isVertebrate;
    }
    public void setCanFly(boolean canFly){
        this.canFly = canFly;
    }
    
    //Display method
    public void displayAnimal(){  
        //Display the name and color
        System.out.print("The " + name + " is " + color + ", ");
        
        //Display if the animal has fur
        if (hasFur){
            System.out.print("has fur, ");
        }
        else{
            System.out.print("does not have fur, ");
        }
        
        //Display if the animal is a vertebrate or an invertebrate
        if (isVertebrate){
            System.out.print("is a vertebrate, ");
        }
        else{
            System.out.print("is an invertebrate, ");
        }   
        
        //Display if the animal can fly
        if (canFly){
            System.out.print("and can fly.");
        }
        else{
            System.out.print("and cannot fly.");
        }
    }
    
    public void Save(){
        try{
            
        
            File saveFile = new File("Animal_List.txt");
            FileWriter writer = new FileWriter(saveFile);
            PrintWriter printWriter = new PrintWriter(writer);
            
            printWriter.println();
            printWriter.println();
            printWriter.println();
            printWriter.println();
            printWriter.println();
            
            printWriter.flush();
            printWriter.close();
        }
        catch (Exception ex){
            
        }
    }
    
    @Override
    public String toString(){
        
        String output;
        
        output = "The " + name + " is " + color + ", ";
        
        //Display if the animal has fur
        if (hasFur){
            output += "has fur, ";
        }
        else{
            output += "does not have fur, ";
        }
        
        //Display if the animal is a vertebrate or an invertebrate
        if (isVertebrate){
            output += "is a vertebrate, ";
        }
        else{
            output += "is an invertebrate, ";
        }   
        
        //Display if the animal can fly
        if (canFly){
            output += "and can fly.";
        }
        else{
            output += "and cannot fly.";
        }
        
        return output;
        
    }
}
