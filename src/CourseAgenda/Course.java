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
    
    public static ArrayList<String> getCourseList(){
        fileLines = readFile();
        for(String data:fileLines){
            String[] values = data.split(",");
            if(!courseNames.contains(values[0])){
                courseNames.add(values[0]);
            }
        }
        System.out.println(courseNames);
        return courseNames;
    }
    
    public double getAverage(){
        fileLines = readFile();
        for(String data:fileLines){
            String[] values = data.split(",");
            try{
                if(values[0].equals(course)){
                    int newGrade = Integer.parseInt(values[3]);
                    grades.add(newGrade);
                    }
            }catch (ArrayIndexOutOfBoundsException a){
                System.out.println("No Grades Entered!");
            }
        }
        System.out.println(grades);
        int sum = 0;
        for(int temp : grades) {
            sum += temp;
        }
        average = (double)sum/(double)grades.size();
        System.out.println(average);
        return average;
        
    }
    
    public static ArrayList<String> readFile(){
        try {
            File myObj = new File("Agenda.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
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
