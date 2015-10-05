package hello;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	Connection connection;
	Statement statement;

	public void getConnection() {

		try {

			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "root");
			statement = connection.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/todos")
	public List<Todo> getTodos() {
		List<Todo> todos = new ArrayList<>();

		this.getConnection();

		try {
			ResultSet resultSet = statement.executeQuery("select * from todo");

			while (resultSet.next()) {
				Todo todo = new Todo();
				todo.setId(resultSet.getLong("id"));
				todo.setTodo(resultSet.getString("todo"));
				todo.setTimeStamp(resultSet.getDate("time_stamp"));
				todo.setCompleted(resultSet.getBoolean("is_completed"));
				todo.setColor(resultSet.getString("color"));
				todos.add(todo);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		System.out.println("Todos called");
		return todos;
	}

	@RequestMapping("/employees")
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		this.getConnection();
		try {
			ResultSet resultSet = statement.executeQuery("select * from employe");

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setName(resultSet.getString("name"));
				employee.setId(resultSet.getInt("id"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setSalary(resultSet.getInt("salary"));
				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
}
