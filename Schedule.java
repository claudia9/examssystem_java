import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents an exam schedule
 * @author Morten, Nico, Stavro and Bjarki
 */
public class Schedule implements Serializable {
    private ArrayList<String[]> examSchedule;

    /**
     * The constructor will create an empty examSchedule array list
     */
    public Schedule() {
	this.examSchedule = new ArrayList<String[]>();
    }

    /** This method will add an exam to the exam schedule
     * @param courseName the course name
     * @param className the class name
     * @param date the date
     */
    public void addExam(String courseName, String className, Date date) {
	String[] exam = new String[3];

	exam[0] = courseName;
	exam[1] = className;
	exam[2] = date.toString();
	
	this.examSchedule.add(exam);
    }

    /**This method will get the exam schedule for the class the is provided as argument
     * @param className the class name
     * @return a schedule for the class name given
     */
    public ArrayList<String[]> getExamSchedule(String className) {
	ArrayList<String[]> result = new ArrayList<String[]>();
	Iterator it = examSchedule.iterator();
	
	while (it.hasNext()){
		String[] str = (String[]) it.next();
		if (str[1].equals(className)){
			result.add(str);
		}
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	return result;
    }
	
//	for (int i = 0; i < this.examSchedule.size(); i++) {
//	    String[] exam = this.examSchedule.get(i);
//	    if (exam[1].equals(className)) {
//		result.add(exam);
//	    } 
//	}

    
    /**
     * @return the number of exams inside this schedule
     */
    public int getNumberOfExams() {
	return examSchedule.size();
    }
}