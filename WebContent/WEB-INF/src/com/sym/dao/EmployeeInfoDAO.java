package com.sym.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sym.dto.EmployeeDTO;

public class EmployeeInfoDAO {

	private Session getHibernateSession() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		return ses;
	}

	public EmployeeDTO getEmployeeInfo(int empId) throws Exception {

		EmployeeDTO empDto = null;
		Session ses = getHibernateSession();
		Query query = ses.createQuery("FROM EmployeeDTO E WHERE E.empID = " + empId);
		List empList = query.list();
		System.out.println(empList.size());
		if (!(empList.isEmpty())) {
			empDto = (EmployeeDTO) empList.get(0);
		}

		return empDto;
	}
		
	public List<EmployeeDTO> getAllEmployeee(){
		
		ArrayList<EmployeeDTO> empList = new ArrayList();
		Session ses = getHibernateSession();
		Query query = ses.createQuery("FROM EmployeeDTO");
		empList = (ArrayList<EmployeeDTO>) query.list();
		//System.out.println(empList.size());
//		if (!(empList.isEmpty())) {
//			empDto = (EmployeeDTO) empList.get(0);
//		}

		return empList;
		
	}

	public int addEmployee(EmployeeDTO empDto) throws Exception {

		int response = 0;
		Session ses = null;

		try {
			ses = getHibernateSession();
			ses.getTransaction().begin();
			ses.save(empDto);
			ses.getTransaction().commit();
			response = 1;

		} catch (Exception ex) {
			ses.getTransaction().rollback();
			ex.printStackTrace();
			throw ex;
		}

		return response;
	}

	public int updateEmployeeInfo(EmployeeDTO empDto) throws Exception {

		int response = 0;
		Session ses = null;

		try {
			ses = getHibernateSession();
			ses.getTransaction().begin();
			ses.update(empDto);
			ses.getTransaction().commit();
			response = 1;

		} catch (Exception ex) {
			ses.getTransaction().rollback();
			ex.printStackTrace();
			throw ex;
		}

		return response;

	}

	public int deleteEmployee(EmployeeDTO empDto) {

		int response = 0;
		Session ses = null;

		try {
			ses = getHibernateSession();
			ses.getTransaction().begin();
			ses.delete(empDto);
			ses.getTransaction().commit();
			response = 1;

		} catch (Exception ex) {
			ses.getTransaction().rollback();
			ex.printStackTrace();
			throw ex;
		}

		return response;

	}

}
