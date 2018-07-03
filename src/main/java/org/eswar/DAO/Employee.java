package org.eswar.DAO;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Employee 
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eid;
	@Column
	private String ename;
	@Column
	private double salary;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary="
				+ salary + "]";
	}

}
