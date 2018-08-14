package org.irvin.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserGroup {
	
	String team_id;
	String team_desc;
	String supervisor_id;
	
	
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getTeam_desc() {
		return team_desc;
	}
	public void setTeam_desc(String team_desc) {
		this.team_desc = team_desc;
	}
	public String getSupervisor_id() {
		return supervisor_id;
	}
	public void setSupervisor_id(String supervisor_id) {
		this.supervisor_id = supervisor_id;
	}
}
