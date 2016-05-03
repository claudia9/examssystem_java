import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a school
 * @author Morten, Nico, Stavro and Bjarki
 */
public class School implements Serializable {
    //private static final long serialVersionUID = 8419651375056840731L;
    private String schoolName;
    private ArrayList<Education> educations;
    private Schedule examSchedule;

    /** 
     * The constructor
     * @param schoolName the name of this school
     */
    public School(String schoolName) {
	this.schoolName = schoolName;
	this.educations = new ArrayList<Education>();
	this.examSchedule = new Schedule();
    }

    /**
     * @return the name of this school
     */
    public String getSchoolName() {
	return schoolName;
    }

    /**
     * @param index index into the educations array list
     * @return the education at the given index
     */
    public Education getEducation(int index) {
	return educations.get(index);
    }

    /**
     * @return an array list of all educations that this school offers
     */
    public ArrayList<Education> getOfferedEducations() {
	return educations;
    }

    /**
     * @return an array list of the educations that this school does not offer
     */
    public ArrayList<Education> getUnofferedEducations() {
	ArrayList<Education>result = new ArrayList<Education>();
	ArrayList<Education> allEducations = new ArrayList<Education>();
	ArrayList<Education> offeredEducations = new ArrayList<Education>();
	offeredEducations = getOfferedEducations();
	
	Iterator allEducationsIt = allEducations.iterator();
	Iterator offeredEducationsIt = offeredEducations.iterator();

	allEducations = SOSUHelper.getAllEducations();

//	for (int i=0; i<allEducations.size(); i++) {
//	    boolean unique = true;
//	    for (int j=0; j<offeredEducations.size(); j++) {
//	    	if (allEducations.get(i).getEducationName().equals(offeredEducations.get(j).getEducationName())) {
//	    		unique = false;
//	    		// TODO: add break here?
//	    	}
//	    }
//	    if (unique) {
//		result.add(allEducations.get(i));
//	    }
//	}
	
	while (allEducationsIt.hasNext()){
		Education edu1 = (Education) allEducationsIt.next();
		boolean unique = true;
		
		while (offeredEducationsIt.hasNext()){
			Education edu2 = (Education) offeredEducationsIt.next();
			if (edu1.getAllCourseNames().equals(edu2.getAllCourseNames())){
				unique = true;
			}
			if (unique){
				result.add(edu1);
			}
		}
	}

	return result;
    }

    /**
     * @return a string array of all education names
     */
    public String[] getAllEducationNames() {
	String res[] = new String[educations.size()];

	for (int i = 0; i < educations.size(); i++) {
	    res[i] = educations.get(i).getEducationName();
	}
	return res;
    }

    /** 
     * @param education the education to add to this school
     */
    public void addEducation(Education education) {
	educations.add(education);
    }

    /**
     * @param index remove the education at the given index
     */
    public void removeEducation(int index) {
	educations.remove(index);
    }

    /**
     * This method adds an exam to the school's exam schedule.
     * Notice the the school's exam schedule is an array list containing a 
     * list of string arrays. Each element in the array list holds a course name, 
     * a class name and the date of the exam  
     * @param courseName the name of the course
     * @param className the name of the class
     * @param date the date of the exam
     */
    public void addExamToSchedule(String courseName, String className, Date date) {
	examSchedule.addExam(courseName, className, date);
    }

    /**
     * The method will return an exam schedule for the className provided.
     * The returned variable is an array list and each elements will 
     * contain the course name, the class name and date of the exam
     *  
     * @param className the class name to get the schedule for
     * @return a string array containing the class name, course name
     * and the date
     */
    public ArrayList<String[]> getExamScheduleForClass(String className) {
    	return examSchedule.getExamSchedule(className);
    }
}