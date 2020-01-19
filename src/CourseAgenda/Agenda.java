/*
 * ICS4U Summative
 * Course Planner
 * Agenda
 */
package CourseAgenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import java.util.ArrayList;


/**
 *
 * @author sara
 */
public class Agenda {
    
    ArrayList<AgendaItem> AgendaItems = new ArrayList<AgendaItem>();
    
    public Agenda() {
        AgendaImport();
    }

    // import agenda table data
    // note: change file location for specific user
    public void AgendaImport() {
                
        try {
            
            String fileLocation = "C:\\Users\\sara\\OneDrive\\Documents\\Agenda.txt";
            File file = new File(fileLocation);
            if (!file.exists()) {
                return;
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] agendaLines = br.lines().toArray();
            AgendaItems.clear();
            
            for(int i = 0; i < agendaLines.length; i++) {
                String agendaLine = agendaLines[i].toString().trim();
                String[] agendaItem = agendaLine.split(",");
                AgendaAdd(agendaItem[0], agendaItem[1], agendaItem[2], Integer.parseInt(agendaItem[3]));
            }
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "C:\\Users\\sara\\OneDrive\\Documents\\Agenda.txt does not exist.");
        } 
    }
    
    // export data from table to text file
    public void AgendaExport() {
        // create new text file if not already created
        // save contents of table to text file
        AgendaItem AgendaItem;
        try {
            File file = new File("C:\\Users\\sara\\OneDrive\\Documents\\Agenda.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < AgendaItems.size(); i++) {
                AgendaItem = AgendaItems.get(i);
                
                bw.write(AgendaItem.AgendaCourse + ",");
                bw.write(AgendaItem.AgendaType + ",");
                bw.write(AgendaItem.AgendaDate + ",");
                bw.write(AgendaItem.AgendaGrade + ",");
                
                bw.write(" \n");
            }
            bw.close();
            fw.close();
            JOptionPane.showMessageDialog(null, "Data has been saved");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "C:\\Users\\sara\\OneDrive\\Documents\\Agenda.txt could not be created.");
        } 
    }
    
    // for adding new agenda items
    public void AgendaAdd(String AgendaCourse, String AgendaType, String AgendaDate, int AgendaGrade) {
        AgendaItem AgendaItem = new AgendaItem();
        AgendaItem.AgendaCourse = AgendaCourse;
        AgendaItem.AgendaType = AgendaType;
        AgendaItem.AgendaDate = AgendaDate;
        AgendaItem.AgendaGrade = AgendaGrade;

        AgendaItems.add(AgendaItem);
    }
    
    // get the number of rows
    public int AgendaItems() {
        return AgendaItems.size();
    }
    
    public AgendaItem AgendaGet(int itemNumber) {
        // make sure item number does not exceed the number of AgendaItems
        if (!(itemNumber < AgendaItems())) {
            JOptionPane.showMessageDialog(null, "Item number exceeds the number of agenda items");
        }
        return AgendaItems.get(itemNumber);
    }
    
    // for updating the table
    public void AgendaUpdate(int itemNumber, String AgendaCourse, String AgendaType, String AgendaDate, int AgendaGrade) {
        AgendaItem AgendaItem = new AgendaItem();
        AgendaItem.AgendaCourse = AgendaCourse;
        AgendaItem.AgendaType = AgendaType;
        AgendaItem.AgendaDate = AgendaDate;
        AgendaItem.AgendaGrade = AgendaGrade;

        AgendaItems.set(itemNumber, AgendaItem);
        
    }

    // for deleting a row
    public void AgendaDelete(int itemNumber) {
        AgendaItems.remove(itemNumber);
    }
    
}
