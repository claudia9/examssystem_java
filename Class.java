import java.util.ArrayList;

/**
 * The Class represents a school (inside a school)
 * @author Morten, Nico, Stavro and Bjarki
 */
public class Class {
    private String className;
    private ArrayList<Course> courses;
    
    
    /** 
     * The constructor
     * @param className the name of the class
     */
    public Class(String className) {
	this.className = className;
	courses = new ArrayList<Course>();
    }
    
    /**
     * @return the name of the class
     */
    public String getClassName() {
	return className;
    }
}