/*
 * ICS4U Summative
 * Course Planner
 * Agenda
 */
package CourseAgenda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tuna
 */

public class Course {  
    String course;
    double average;
    ArrayList<Integer> grades = new ArrayList<>();
    public static ArrayList<String> courseNames = new ArrayList<String>();
    public static ArrayList<String> fileLines = new ArrayList<String>();
    
    public Course (String couseName){
        course = couseName;
    }
    
    // Gets a list of courses from the output file 
    public static ArrayList<String> getCourseList(){
        // Reads each line on the file and returns an arraylist
        fileLines = readFile();
        
        //Go through the file and add any new couse to the list
        for(String data:fileLines){
            String[] values = data.split(",");
            if(!courseNames.contains(values[0])){
                courseNames.add(values[0]);
            }
        }
        System.out.println(courseNames);
        return courseNames;
    }
    
    // Returns the average of the couse
    public double getAverage(){
        // Reads each line on the file and returns an arraylist
        fileLines = readFile();
        
        //Go through the file and add all grades of a couse to the list
        for(String data:fileLines){
            String[] values = data.split(",");
            try{
                if(values[0].equals(course)){
                    int newGrade = Integer.parseInt(values[3]);
                    grades.add(newGrade);
                    }
            }catch (ArrayIndexOutOfBoundsException a){
                System.out.println("No Grades Entered!");
            }catch (NumberFormatException n){
                System.out.println("TEST");
            }
        }
        
        // Calculates the average using the list of grades
        int sum = 0;
        for(int temp : grades) {
            sum += temp;
        }
        average = (double)sum/(double)grades.size();
        return average;
        
    }
    
    // Reads the file and returns an array list of lines
    public static ArrayList<String> readFile(){
        fileLines.clear();
        try {
            // Reads a new line from the file
            File myObj = new File("Agenda.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                // Adds the new line to the list
                String data = myReader.nextLine();
                fileLines.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException f) {
            System.out.println("Input file does not exist!");
        }
        return fileLines;
    }
   
    
}
