package model.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class AttendancesBean implements Serializable {

	private String employee_id;
	
	private Date date;
	
	private Time start_time;
	
	private Time end_time;
	
	private Time break_time;
	
	private Time work_time;
	
	private Time over_time;
	
	public AttendancesBean() {
	}
	
	public AttendancesBean(String employee_id, Date date, Time start_time, Time end_time, Time break_time, Time work_time, Time over_time) {
		this.employee_id = employee_id;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.break_time = break_time;
		this.work_time = work_time;
		this.over_time = over_time;
	}
	
	public String getEmployee_id() {
		return employee_id;
	}
	
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Time getStart_time() {
		return start_time;
	}
	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}
	
	public Time getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}
	
	public Time getBreak_time() {
		return break_time;
	}
	public void setBreak_time(Time break_time) {
		this.break_time = break_time;
	}
	
	public Time getWork_time() {
		return work_time;
	}
	public void setWork_time(Time work_time) {
		this.work_time = work_time;
	}
	
	public Time getOver_time() {
		return over_time;
	}
	public void setOver_time(Time over_time) {
		this.over_time = over_time;
	}
}

