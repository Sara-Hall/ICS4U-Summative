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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sara
 */
public class Agenda extends AgendaForm {
    
    public void AgendaImport() {
        String fileLocation = "C:\\Users\\sara\\OneDrive\\Documents\\Agenda.txt";
        File file = new File(fileLocation);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel table = (DefaultTableModel)AgendaTable.getModel();          
            Object[] agendaLines = br.lines().toArray();
            table.setRowCount(0);
            
            for(int i = 0; i < agendaLines.length; i++) {
                String agendaLine = agendaLines[i].toString().trim();
                String[] agendaItem = agendaLine.split(",");
                table.addRow(agendaItem);
            }
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AgendaExport() {
        // create new text file if not already created
        // save contents of table to text file
        try {
            File file = new File("C:\\Users\\sara\\OneDrive\\Documents\\Agenda.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < AgendaTable.getRowCount(); i++) {
                for (int j = 0; j < AgendaTable.getColumnCount(); j++) {
                    bw.write((String)AgendaTable.getModel().getValueAt(i,j) + ",");
                }
                bw.write(" \n");
            }
            bw.close();
            fw.close();
            JOptionPane.showMessageDialog(null, "Data has been saved");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void AgendaAdd() {
        // get user input
        String agendaCourse = JOptionPane.showInputDialog("Enter the course");
        String agendaType = JOptionPane.showInputDialog("Enter the type of assessment due");
        String agendaDate = JOptionPane.showInputDialog("Enter the due date");
        String agendaGrade = JOptionPane.showInputDialog("Enter the grade if recieved");
        
        // put data into new table row
        Object agendaItem[] = new Object[4];
        agendaItem[0] = agendaCourse;
        agendaItem[1] = agendaType;
        agendaItem[2] = agendaDate;
        agendaItem[3] = agendaGrade;
        
        DefaultTableModel table = (DefaultTableModel)AgendaTable.getModel();
        table.addRow(agendaItem);
    }
    
    public void AgendaUpdate() {
        DefaultTableModel table = (DefaultTableModel)AgendaTable.getModel();
        int selectedRow = AgendaTable.getSelectedRow();
        int selectedCol = AgendaTable.getSelectedColumn();
        String message = null;
        
        // replace data in selected table cell if any changes are made
        try {
            String agendaItem = table.getValueAt(selectedRow, selectedCol).toString();
            switch (selectedCol) {
                case 0:
                    message = "Enter any changes to the course";
                    break;
                case 1:
                    message = "Enter any changes to the type of assessment due";
                    break;
                case 2:
                    message = "Enter any changes to the date";
                    break;
                case 3:
                    message = "Enter any changes to the grade";
                default:
                    break;
            }
                    
            String newAgendaCourse = JOptionPane.showInputDialog(null, message, agendaItem);
            table.setValueAt(newAgendaCourse, selectedRow, selectedCol);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No cell selected");
        }
    }
    
    public void AgendaDelete() {
        DefaultTableModel table = (DefaultTableModel) AgendaTable.getModel();
        
        // delete selected row
        try {
            int selectedRowIndex = AgendaTable.getSelectedRow();
            table.removeRow(selectedRowIndex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No row selected");
        }
    }
    
}
