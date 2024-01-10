package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<Employee,String> {

	
	String query="select employee from Employee employee where employee.user=?1 and employee.password=?2";
	@Query(query)
	public Employee findByuserpwd(String username,String password);
	
}
