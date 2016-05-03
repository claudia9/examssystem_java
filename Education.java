import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/** This class represents an education
 * @author Morten, Nico, Stavro and Bjarki
 */
public class Education implements Serializable{
    private String educationName;
    private ArrayList<Course> courses;
    
    /**
     * The constructor
     * @param educationName the name of this education
     */
    public Education(String educationName) {
	this.educationName = educationName;
	courses = new ArrayList<Course>();
    }
    
    /**
     * @return the name of this education
     */
    public String getEducationName() {
	return educationName;
    }
    
    /**
     * @return a string array containing all education names
     */
    public String[] getAllCourseNames() {
	String res[] = new String[courses.size()];
	Iterator it = courses.iterator();
	
	while (it.hasNext()){
		int index = 0;
		Course c = (Course) it.next();
		res[index] = c.getCourseName();
		index++;
		}
	
	return res;
    }


    /**
     * @param course the course to add to this education
     */
    public void addCourse(Course course) {
	courses.add(course);
    }
    
    /**
     * @param index the index into the courses array list
     * @return the course at the given index
     */
    public Course getCourse(int index) {
	return courses.get(index);
    }
    
 
}