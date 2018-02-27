package config;

public class WindowLayoutConfig {

	private String classname;
	
	private String objectName;
	
	private int axisX;
	
	private int axisY;

	public WindowLayoutConfig(String className, String objectName, int axisX, int axisY) {
		this.classname = className;
		this.objectName = objectName;
		this.axisX = axisX;
		this.axisY = axisY;
	
	}

	public String getClassname() {
		return classname;
	}

	public int getAxisX() {
		return axisX;
	}

	public int getAxisY() {
		return axisY;
	}
	
	public String getObjectname() {
		return objectName;
	}


}
