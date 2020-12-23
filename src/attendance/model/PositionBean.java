/*
 *@author : WintShweSin
 *@version: 1.0
 *Department Model Class
 */

package attendance.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class PositionBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String position_code;
	private String position_role;
	private Timestamp created;
	private Timestamp updated;
	public String getPosition_code() {
		return position_code;
	}
	public void setPosition_code(String position_code) {
		this.position_code = position_code;
	}
	public String getPosition_role() {
		return position_role;
	}
	public void setPosition_role(String position_role) {
		this.position_role = position_role;
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
