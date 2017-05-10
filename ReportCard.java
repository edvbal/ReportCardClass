package javaapplication2;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * ReportCard class stores subjects and it's grades in HashMap data structure
 * that contains String key (subject) and ArrayList<Integer> value (grades).
 * It can also calculate average subject grade and average total grade.
 */
public class ReportCard {
    
    // Declaring class variables accessible only in the class scope
    private String subject;                                      
    private ArrayList<Integer> grades = new ArrayList<Integer>();
    
    /* ReportCard constructor that builds object from
       String subject and ArrayList<Integer> grades */
    public ReportCard(String subject, ArrayList<Integer> grades){
        this.subject = subject;
        this.grades = grades;
    }
    
    // Empty ReportCard object constructor if user wants to set up object later.
    public ReportCard(){};

    // Returns class variables to outside of the class scope
    public String getSubject() {return subject;}
    public ArrayList<Integer> getGrades() { return grades;}
    
    // Sets class variables
    public void setSubject(String subject) {this.subject = subject;}
    public void setGrades(ArrayList<Integer> grades) {this.grades = grades;}
    
    // Calculates and returns double value of average grades of subject
    public double getAverageGrade(){
        double sumOfGrades = 0.00;
        for (int i = 0; i < grades.size(); i++)
            sumOfGrades += grades.get(i);
        return sumOfGrades/grades.size();
    }
    
    // Returns readable String of subject and it's grades.
    @Override
    public String toString() {
        String reportCardString = subject + " ";
        for (int i = 0; i < grades.size(); i++)
            reportCardString += grades.get(i) + " ";
        return reportCardString;
    }
}
