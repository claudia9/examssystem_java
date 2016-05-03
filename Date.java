import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This class represents a date
 * @author Morten, Nico, Stavro and Bjarki
 */
public class Date {
    int day, month, year;

    /**
     * The default constructor creates a new date object which represents the date when the object was created
     */
    public Date() {
	Calendar now = GregorianCalendar.getInstance();
	int day = now.get(Calendar.DAY_OF_MONTH);
	int month = now.get(Calendar.MONTH) + 1;
	int year = now.get(Calendar.YEAR);
	set(day, month, year);
    }

    /**
     * This constructor creates a new date object according to the parameters provided
     * @param day the day of this date
     * @param month the month of this date
     * @param year the year of this date
     */
    public Date(int day, int month, int year) {
	set(day, month, year);
    }

    /**
     * @return the day of this date
     */
    public int getDay() {
	return day;
    }

    /**
     * @return the month of this date
     */
    public int getMonth() {
	return month;
    }

    /**
     * @return the year of this date
     */
    public int getYear() {
	return year;
    }

    /**
     * @return true if this date contains a leap year, false otherwise
     */
    public boolean isLeapYear() {
	if (getYear() % 4 == 0
		&& ((getYear() % 100 != 0) || (getYear() % 400 == 0))) {
	    return true;
	} else {
	    return false;
	}

    }

    /**
     * @return the number of days in this date
     */
    public int numberOfDaysInMonth() {
	int days = 0;
	switch (getMonth()) {
	case 1:
	    days = 31;
	    break;
	case 2:
	    if (!isLeapYear()) {
		days = 28;
	    } else {
		days = 29;
	    }
	    break;
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
	    days = 31;
	    break;
	case 4:
	case 6:
	case 9:
	case 11:
	    days = 30;
	    break;
	}
	return days;
    }    

    /**
     * @return the name of the month as a string
     */
    public String getMonthName() {
	switch (getMonth()) {
	case 1:
	    return "January";
	case 2:
	    return "February";
	case 3:
	    return "March";
	case 4:
	    return "April";
	case 5:
	    return "May";
	case 6:
	    return "June";
	case 7:
	    return "July";
	case 8:
	    return "August";
	case 9:
	    return "September";
	case 10:
	    return "October";
	case 11:
	    return "November";
	case 12:
	    return "December";
	}
	return "";
    }

    /**
     * Sets (modifies) the date. It does some checking to make sure that both day and month are within valid ranges
     * @param day the new day
     * @param month the new month
     * @param year the new year
     */
    public void set(int day, int month, int year) {
	this.year = Math.abs(year);
	this.month = month;
	this.day = day;
	
	if (month < 1) {
	    this.month = 1;
	} else if (month > 12) {
	    this.month = 12;
	}

	if (day < 1) {
	    this.day = 1;
	}

	switch (month) {
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
	    if (day > 31) {
		this.day = 31;
	    }
	    break;
	case 4:
	case 6:
	case 9:
	case 11:
	    if (day > 30) {
		this.day = 30;
	    }
	    break;
	case 2:
	    if (isLeapYear()) {
		if (day > 29) {
		    this.day = 29;
		}
	    } else {
		if (day > 28) {
		    this.day = 28;
		}
	    }
	    break;
	}
    }

    /**
     * Sets (modifies) the date. It does some checking to make sure that both day and month are within valid ranges
     * @param day the new day
     * @param monthName the new month as a string
     * @param year the new year
     */
    public void set(int day, String monthName, int year) {
	int month = -1;
	switch (monthName) {
	case "January":
	    month = 1;
	    break;
	case "February":
	    month = 2;
	    break;
	case "March":
	    month = 3;
	    break;
	case "April":
	    month = 4;
	    break;
	case "May":
	    month = 5;
	    break;
	case "June":
	    month = 6;
	    break;
	case "Juli":
	    month = 7;
	    break;
	case "August":
	    month = 8;
	    break;
	case "September":
	    month = 9;
	    break;
	case "October":
	    month = 10;
	    break;
	case "November":
	    month = 11;
	    break;
	case "December":
	    month = 12;
	    break;
	}

	set(day, month, year);
    }

    /**
     * A static (class) method that return the current date
     * @return the current date
     */
    public static Date now() {
	Calendar now = GregorianCalendar.getInstance();
	int day = now.get(Calendar.DAY_OF_MONTH);
	int month = now.get(Calendar.MONTH) + 1;
	int year = now.get(Calendar.YEAR);
	return new Date(day, month, year);

    }

    /**
     * Compares this date to another object
     * @param obj the other object
     * @return true if this date is equals to obj, false otherwise
     */
    public boolean equals(Object obj) {
	if (!(obj instanceof Date)) {
	    return false;
	}
	Date other = (Date) obj;
	return getDay() == other.getDay() && getMonth() == other.getMonth()
		&& getYear() == other.getYear();
    }

    /**
     * @return a copy of this date
     */
    public Date copy() {
	return new Date(getDay(), getMonth(), getYear());
    }
    
    /**
     * @return a string representation of this year in the format: DD/MM/YYYY
     */
    public String toString() {
	String day = "" + getDay();
	if (getDay() < 10) {
	    day = "0" + day;
	}

	String month = "" + getMonth();
	if (getMonth() < 10) {
	    month = "0" + month;
	}

	return day + "/" + month + "/" + getYear();
    }
}