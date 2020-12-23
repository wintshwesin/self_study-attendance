/*
 *@author : WintShweSin
 *@version: 1.0
 *Attendance Model Class
 */
package attendance.model;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class AttendacneBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private LocalDate working_date;
	private LocalTime start_time;
	private LocalTime end_time;
	private Duration break_time;
	public Duration getBreak_time() {
		return break_time;
	}

	private LocalTime start_break_time;
	private LocalTime end_break_time;
	public LocalTime getStart_break_time() {
		return start_break_time;
	}
	public void setStart_break_time(LocalTime start_break_time) {
		this.start_break_time = start_break_time;
	}
	public LocalTime getEnd_break_time() {
		return end_break_time;
	}
	public void setEnd_break_time(LocalTime end_break_time) {
		this.end_break_time = end_break_time;
	}
	public void setBreak_time(Duration break_time) {
		this.break_time = break_time;
	}

	private Duration working_hours;
	public LocalDate getWorking_date() {
		return working_date;
	}
	public void setWorking_date(LocalDate working_date) {
		this.working_date = working_date;
	}
	public LocalTime getStart_time() {
		return start_time;
	}
	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}
	public LocalTime getEnd_time() {
		return end_time;
	}
	public void setEnd_time(LocalTime end_time) {
		this.end_time = end_time;
	}

	public Duration getWorking_hours() {
		return working_hours;
	}
	public void setWorking_hours(Duration working_hours) {
		this.working_hours = working_hours;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void calcBreakTime() {
		Duration duration = Duration.between(start_break_time, end_break_time);
		setBreak_time(duration);
	}

	public void calcWorkingHours() {
		Duration duration = Duration.between(start_time, end_time);
		setWorking_hours(duration);
		if(break_time != null) {
			duration = working_hours.minus(break_time);
			setWorking_hours(duration);
		}
	}



}
