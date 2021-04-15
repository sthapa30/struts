package com.sym.bo;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sym.dao.EmployeeInfoDAO;
import com.sym.dto.EmployeeDTO;
//import com.sym.services.EmployeeInfoService;

public class EmployeeInfoBO {

	Logger logger = Logger.getLogger(EmployeeInfoBO.class);

	private boolean checkNull(String input) {

		if (input != null && input.trim().length() > 0) {
			return true;
		}
		return false;
	}

	private boolean isNumber(String input) {

		if (Pattern.matches("[0-9]+", input)) {
			return true;
		}
		return false;

	}

	public EmployeeDTO getEmployeeInfo(String empId) {

		EmployeeDTO empDto = null;
		logger.debug("    EmployeeInfoBO - start" + empId);
		// System.out.println(" EmployeeInfoBO - start");

		if (isNumber(empId)) {
			// EmployeeInfoDAO empDao = new EmployeeInfoDAO();

			try {
				ApplicationContext context = new ClassPathXmlApplicationContext("springAppConfig.xml");
				EmployeeInfoDAO empDao = (EmployeeInfoDAO) context.getBean("employeeDAO");

				empDto = empDao.getEmployeeInfo(Integer.parseInt(empId));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			logger.debug("Invalid empID");
			// System.out.println("Invalid empID");
		}

		// System.out.println(" EmployeeInfoBO - end");
		logger.debug("    EmployeeInfoBO - end" + empId);

		return empDto;
	}

	public int addEmployee(String empId, String firstName, String lastName, String email, String hireDate,
			String jobID) {

		int result = 0;

		if (isNumber(empId) && checkNull(firstName) && checkNull(lastName) && checkNull(email) && checkNull(jobID)
				&& checkNull(hireDate)) {

			EmployeeDTO empDto = new EmployeeDTO();

			empDto.setEmpID(Integer.parseInt(empId));
			empDto.setLastName(lastName);
			empDto.setFirstName(firstName);
			empDto.setEmail(email);
			empDto.setHireDate(hireDate);
			empDto.setJobID(jobID);

			EmployeeInfoDAO empDao = new EmployeeInfoDAO();

			try {
				result = empDao.addEmployee(empDto);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	public int updateEmployeeInfo(String empId, String firstName, String lastName, String email, String hireDate,
			String jobID) {

		int result = 0;

		if (isNumber(empId) && checkNull(firstName) && checkNull(lastName) && checkNull(email) && checkNull(jobID)
				&& checkNull(hireDate)) {

			EmployeeDTO empDto = new EmployeeDTO();

			empDto.setEmpID(Integer.parseInt(empId));
			empDto.setLastName(lastName);
			empDto.setFirstName(firstName);
			empDto.setEmail(email);
			empDto.setHireDate(hireDate);
			empDto.setJobID(jobID);

			EmployeeInfoDAO empDao = new EmployeeInfoDAO();

			try {
				result = empDao.updateEmployeeInfo(empDto);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return result;

	}

	public int deleteEmployee(String empId) {

		int result = 0;
		System.out.println("    deleteEmployee - start");

		if (isNumber(empId)) {
			EmployeeInfoDAO empDao = new EmployeeInfoDAO();
			try {
				EmployeeDTO empDto = new EmployeeDTO();
				empDto.setEmpID(Integer.parseInt(empId));
				result = empDao.deleteEmployee(empDto);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid empID");
		}

		System.out.println("    deleteEmployee - end");
		return result;

	}

}
