package hello;

public class Employee {

	private String name;
	private long id;
	private String department;
	private long salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		String employee = "Employee Id: "+this.id+ ", Name: "+this.name+", Department: "+this.department+", salary: "+this.salary;
		return employee;
	}
}
