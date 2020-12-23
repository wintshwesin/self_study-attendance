/*
 *@author : WintShweSin
 *@version: 1.0
 *Department Model Class
 */

package attendance.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class DepartmentBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String department_code;
	private String department_name;
	private Timestamp created;
	private Timestamp updated;
	public String getDepartment_code() {
		return department_code;
	}
	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
