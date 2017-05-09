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
    /** @param gradesMap HashMap data structure to hold subjects and grades*/
    Map<String, ArrayList<Integer>> gradesMap = 
            new HashMap<String, ArrayList<Integer>>();
    /**
     * ReportCard constructor that builds object from
     * String and ArrayList<Integer>
     */
    public ReportCard(String subject, ArrayList<Integer> grades) {
        if (gradesMap.get(subject) == null) 
            this.gradesMap.put(subject, grades);
        else return;
    }
    /**
     * Empty ReportCard object constructor if user wants to set it up later.
     */
    public ReportCard(){};
    /**
     * ReportCard constructor that builds object from HashMap.
     * @param gradesMap HashMap data structure to build ReportCard object.
     */
    public ReportCard(Map<String, ArrayList<Integer>> gradesMap) {
        this.gradesMap = gradesMap;
    }
    /**
     * Sets subject and it's grades from parameters.
     */
    public void setSubjectAndGrades(String subject, ArrayList<Integer> grades){
        if (gradesMap.get(subject) == null) 
            this.gradesMap.put(subject, grades);
        else return;
    }
    /**
     * Returns ArrayList<String> of all the subjects in ReportCard.
     */
    public ArrayList<String> getSubjects(){
        ArrayList<String> subjects = new ArrayList<String>();
        if(!gradesMap.isEmpty())
            for (Map.Entry<String, ArrayList<Integer>> ee : gradesMap.entrySet()) 
                subjects.add(ee.getKey());
        return subjects;
    }
    /**
     * Returns ArrayList<Integer> of all the grades of subject
     * specified in the parameter.
     */
    public ArrayList<Integer> getGrades(String subject){
        ArrayList<Integer> grades = new ArrayList<Integer>();
        if(!gradesMap.isEmpty())
            for (Map.Entry<String, ArrayList<Integer>> ee : gradesMap.entrySet()) 
                if(ee.getKey() == subject){
                    List<Integer> values = ee.getValue();
                    for (int i = 0; i < values.size(); i++)
                        grades.add(values.get(i));
                }
        return grades;
    }    
    /**
     * Calculates and returns double value of average grades from subject 
     * specified in the parameter
     */
    public double getSubjectAverage(String subject){
        double sumOfGrades = 0.00;
        double totalGrades = 0.00;
        double average = 0.00;
        if(!gradesMap.isEmpty())
            for (Map.Entry<String, ArrayList<Integer>> ee : gradesMap.entrySet()) 
                if(ee.getKey() == subject){
                    List<Integer> values = ee.getValue();
                    totalGrades = values.size();
                    for (int i = 0; i < values.size(); i++)
                        sumOfGrades += values.get(i);
                }
        average = sumOfGrades/totalGrades;
        return average;
    }
    /**
     * Calculates and returns double value of total average grade from all
     * subjects.
     */
    public double getTotalAverage(){
        double sumOfAverages = 0.00;
        double totalAverages = 0.00;
        double average = 0.00;
        if(!gradesMap.isEmpty())
            for (Map.Entry<String, ArrayList<Integer>> ee : gradesMap.entrySet()) {
                double f = 0.5;
                double rounded = f * Math.round(getSubjectAverage(ee.getKey())/f);
                sumOfAverages += rounded;
                totalAverages++;
            }
        average = sumOfAverages/totalAverages;
        return average;
    }
    /**
     * Prints readable report of subject and it's grades in console.
     */
    public void print() {
        ArrayList<Integer> grades = new ArrayList<Integer>();
        String subject2;
        for (Map.Entry<String, ArrayList<Integer>> ee : gradesMap.entrySet()) {
            String key = ee.getKey();
            System.out.print(key + " ");
            List<Integer> values = ee.getValue();
            for (int i = 0; i < values.size(); i++){
                System.out.print(values.get(i)+ " ");
            }
            System.out.print("\n");
           }
    }
    /**
     * Returns readable String of subject and it's grades.
     */
    @Override
    public String toString() {
        String toString = "";
        ArrayList<Integer> grades = new ArrayList<Integer>();
        String subject2;
        for (Map.Entry<String, ArrayList<Integer>> ee : gradesMap.entrySet()) {
            String key = ee.getKey();
            toString += ee.getKey();
            List<Integer> values = ee.getValue();
            for (int i = 0; i < values.size(); i++){
                toString += " " + values.get(i);
            }
            toString += "\n";
           }
        return toString;
    }
}
