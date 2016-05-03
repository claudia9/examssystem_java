import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This class represent an exam report. An exam report holds one or more exams
 * to be conducted on the same date
 * @author Morten, Nico, Stavro and Bjarki
 */
public class ExamReport implements Serializable {
    private Date date;
    private ArrayList<Exam> exams;
    private String responsible;
    
    /**
     * @param date the date of this exam report (when the exams are to be conducted
     * @param responsible the person who made this exam report
     */
    public ExamReport(Date date, String responsible) {	
	this.date = date.copy();
	exams = new ArrayList<Exam>();
	this.responsible = responsible;
    }
    
    /**
     * @param exam an exam to add to this report
     */
    public void addExam(Exam exam) {
	exams.add(exam);
    }
       
    /** 
     * @return a copy the Date of this exam report
     */
    public Date getDate() {
	return date.copy();
    }
    
    /**
     * @return return a string of this exam report including the date,
     * the responsible and the information on all the exams
     */
    public String toString() {
	String res = "Date: " + date.toString() + "\n"; 
	res += "Responsible: " + responsible + "\n";
	res += "--------------------------------------------\n";
	for (int i=0; i<exams.size(); i++) {
	    res += exams.get(i).toString();
	    res += "--------------------------------------------\n";
	}
	return res;
    }
}