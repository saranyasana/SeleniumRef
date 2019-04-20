package com.example.assignment.model;

public class Device {

private String name;
private String IP;
public String getIP() {
	return IP;
}
public void setIP(String iP) {
	IP = iP;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
Device(){}
public Device(String name, String iP) {
	super();
	this.name = name;
	IP = iP;
}

}
