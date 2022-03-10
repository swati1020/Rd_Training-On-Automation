package epam.com.RestApiTesting;

public class PojoForRestApiTesting {
	private String date;
	private int empName;
	private String timezoneOffset;
	private String time;
	private Boolean forcePunchIn;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getEmpName() {
		return empName;
	}

	public void setEmpName(int empName) {
		this.empName = empName;
	}

	public String getTimezoneOffset() {
		return timezoneOffset;
	}

	public void setTimezoneOffset(String timezoneOffset) {
		this.timezoneOffset = timezoneOffset;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Boolean getForcePunchIn() {
		return forcePunchIn;
	}

	public void setForcePunchIn(Boolean forcePunchIn) {
		this.forcePunchIn = forcePunchIn;
	}

}