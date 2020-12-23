/*
 *@author : WintShweSin
 *@version: 1.0
 *Validation
 */

package attendance.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import attendance.model.EmployeeBean;

public class Validation {
	public List<String> validate(EmployeeBean employeeBean) {
		List<String> errors = new ArrayList<String>();
		System.out.println("Validation Check");
		String emp_name = employeeBean.getEmployee_name();
		String tel = employeeBean.getTelephone();
		String password = employeeBean.getPassword();
		String email = employeeBean.getEmail();
		/*if (emp_code.length() > 7) {
			errors.add("従業員番号は7桁まで入力してください");
		}
		if (emp_name.length() > 50) {
			errors.add("従業員名称は50桁まで入力してください");
		}
		if (tel.length() > 30) {
			errors.add("電話番号は30桁まで入力してください");
		}
		if (address.length() > 200) {
			errors.add("住所は200桁まで入力してください");
		}
		if (email.length() > 50) {
			errors.add("メールは50桁いない入力してください");
		}*/
		if(!isValidName(emp_name)) {
			errors.add("名称に文字だけ入力してください");
		}
		if(!isValidateEmail(email)) {
			errors.add("メールフォマードで入力してください");
		}
		if(!isValidatePhone(tel)) {
			errors.add("電話番号は(●●●）●●●●-●●●●で入力してください");
		}
		if(!isValidatePassword(password)) {
			errors.add("パスワードは大文字、小文字、数字を含めて8文字から30文字まで入力してください");
		}
		System.out.println(errors);
		return errors;

	}

	//Validate for employee_name
	public static boolean isValidName(String emp_name) {
		String name_regex = "^[a-zA-Z\\s]+$";
		Pattern p =Pattern.compile(name_regex);
		Matcher m = p.matcher(emp_name);
		return m.matches();
	}

	//Validate for password
	public static boolean isValidatePassword(String password) {
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,20}$";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.matches();
	}

	//Validate for email format
	public static boolean isValidateEmail(String email) {
		String email_regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern p = Pattern.compile(email_regex,Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	//Validate for phone format (xxx)-xxxx-xxxx
	public static boolean isValidatePhone(String phone) {
		String phone_regex = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{4}[- .]?\\d{4}$";
		Pattern p = Pattern.compile(phone_regex);
		Matcher matcher = p.matcher(phone);
	    return matcher.matches();
	}

}
