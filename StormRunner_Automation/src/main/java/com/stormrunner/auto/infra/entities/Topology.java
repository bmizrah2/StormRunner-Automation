package com.stormrunner.auto.infra.entities;

// Topology class to read from "Topologies.csv" file
public class Topology {

	public String topologyName;
	public String topologyDescription;
	
	public Topology(String topologyName, String topologyDescription) {
		this.topologyName = topologyName;
		this.topologyDescription = topologyDescription;
	}
	
	public String toString() {
		return "Topology Name: " + topologyName  + "; Topology Description: " + topologyDescription;
	}
}
