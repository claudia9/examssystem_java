import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents the head of department of SOSU.
 * @author Morten, Nico, Stavro and Bjarki
 */
public class SOSU {
    private ArrayList<School> schools;
    private ArrayList<ExamReport>examReports;

    /** 
     * The constructor
     * The schools array list is created
     * The schools from the binary file is loaded into the schools array list
     * The SOSUHelper.oneTimeSetup() will be run only once to store all schools to a binary file
     */
    public SOSU() {
	schools = new ArrayList<School>();
	schools = SOSUHelper.loadSchools(); 
    }

    /** 
     * This method will save the schools array to the file system as a binary file
     */
    public void install() {
	SOSUHelper.oneTimeSetup();
    }

    /**
     * 
     * @param index an index into the schools array list
     * @return the school at the given index
     */
    public School getSchool(int index) {
	return schools.get(index);
    }

    /**
     * @return a string array of all school names
     */
    public String[] getAllSchoolNames() {
	String[] res = new String[schools.size()];
	Iterator it = schools.iterator();
	int i = 0;

		while (it.hasNext()){
			School sch = (School) it.next();
			res[i] = sch.getSchoolName();
			i++;
		}
		return res;
    }

    /**
     * @param schoolIndex an index into the schools array list
     * @return a string array of all education names of the given school
     */
    public String[] getAllEducationNames(int schoolIndex) {
	return schools.get(schoolIndex).getAllEducationNames();
    }

    /**
     * @param schoolIndex an index into the schools array list
     * @param educationIndex an index into the courses array list inside the school
     * @return a string array of all course names of the given school and education
     */
    public String[] getAllCourseNames(int schoolIndex, int educationIndex) {
	return schools.get(schoolIndex).getEducation(educationIndex).getAllCourseNames();	
    }

    /**
     * 
     * @param responsible the responsible of the report
     * @param date the date the exam(s) are to be conducted
     * @param schoolIndex index into the schools array list
     * @param educationIndex index into educations array list inside the given school
     * @param _class the class name
     * @return the report as a string
     */
    public String generateExamReport(String responsible, String date, int schoolIndex, int educationIndex, String _class) {
	String[] classNames = _class.split(";");

	String dateParts[] = date.split("/");
	Date examsDate = new Date(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));

	// store the school instead of referencing the index all the time
	School school = this.schools.get(schoolIndex);

	ExamReport report = null;
	String courseArray[] = school.getEducation(educationIndex).getAllCourseNames();
	report = new ExamReport(examsDate, responsible);

	for (int i=0; i<classNames.length; i++) {
	    // Get a random number into the educations array list for this school
	    int randCourseIndex = (int)(Math.floor(Math.random() * courseArray.length));

	    // Create a class and a course that is meant to be examined.
	    Course examCourse = school.getEducation(educationIndex).getCourse(randCourseIndex);
	    Class examClass = new Class(classNames[i].trim());

	    // Add the class, course and date to the exam schedule
	    school.addExamToSchedule(examCourse.getCourseName(), examClass.getClassName(), report.getDate());

	    // Create a new exam
	    Exam exam = new Exam(examCourse, examClass);	    
	    report.addExam(exam);		    
	}

	// return the report
	return report.toString();
    }

    /**
     * This method will 
     * 1: save the report to a text file on the file system.
     * 2: update the binary file representing the schools array list0
     * 
     * @param path the path where to store the text file
     * @param report the report to save
     */
    public void saveReport(String path, String report) {
	File file = new File(path);
	PrintWriter out = null;
	try {
	    out = new PrintWriter(file);
	    out.println(report);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} finally {
	    out.close();  
	}
	saveUpdatedSchools();
    }

    /**
     * Let the SOSOHelper take handle file operations
     * This method will make sure that binary file representing the schools array is updated
     */
    public void saveUpdatedSchools() {
	SOSUHelper.saveUpdatedSchools(schools);
    }
}