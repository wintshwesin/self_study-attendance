/*
 *@author : WintShweSin
 *@version: 1.0
 *Employee Model Class
 */

package attendance.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class EmployeeBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String employee_code;
	private String employee_name;
	private String department_code;
	private String position_code;
	private char gender;
	private String salary_grade_id;
	private String telephone;
	private String address;
	private String email;
	private String password;
	private String admin_permission;

	public String getAdmin_permission() {
		return admin_permission;
	}

	public void setAdmin_permission(String admin_permission) {
		this.admin_permission = admin_permission;
	}

	private Timestamp created;
	private Timestamp updated;

	public String getEmployee_code() {
		return employee_code;
	}

	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getDepartment_code() {
		return department_code;
	}

	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}

	public String getPosition_code() {
		return position_code;
	}

	public void setPosition_code(String position_code) {
		this.position_code = position_code;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSalary_grade_id() {
		return salary_grade_id;
	}

	public void setSalary_grade_id(String salary_grade_id) {
		this.salary_grade_id = salary_grade_id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public EmployeeBean() {

	}

	public EmployeeBean(String emp_code, String emp_name) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.employee_code = emp_code;
		this.employee_name = emp_name;
	}

	public EmployeeBean(String employee_code, String employee_name, String department_code,
			String position_code, char gender, String salary_grade_id, String telephone,
			String address, String email, String password, String admin_permission, Timestamp created) {
		this.employee_code = employee_code;
		this.employee_name = employee_name;
		this.department_code = department_code;
		this.position_code = position_code;
		this.gender = gender;
		this.salary_grade_id = salary_grade_id;
		this.telephone = telephone;
		this.address = address;
		this.email = email;
		this.password = password;
		this.admin_permission = admin_permission;
		this.created = created;
	}

}
