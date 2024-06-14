package com.tka.Organization.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.Organization.entity.Country;
import com.tka.Organization.entity.Employee;

import jakarta.persistence.Query;

@Repository
public class MainDao {
	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {		
		 session= factory.openSession();
		tx=session.beginTransaction();		
		session.persist(c);
		tx.commit();
		msg="Country is addedd...";
		}catch (Exception e) {
						
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();			
		}finally {
			
			if(session!=null) {
				session.close();
			}			
		}
		
		return msg;		
	}

	public String updateCountry(int id, Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {			
			session= factory.openSession();
			tx=session.beginTransaction();
			
			Country country= 
					session.get(Country.class, id);
			
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			
			msg="Country is updatated...";	
			
		}catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
		
	}

	public String deleteRecord(int id) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		String msg=null;
	try {
		session= factory.openSession();
		tx=session.beginTransaction();
		Country country= 
				session.get(Country.class, id);
		session.remove(country);
		tx.commit();
		msg="Country is delete...";
		
	} catch (Exception e) {
		// TODO: handle exception
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}		
		return msg;
		
	}

	public List<Country> getAllRecord() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Country> list = null;

	//	List<Country> list = null;

		try {

			String hqlQuery = "from Country";
			session=factory.openSession();
			tx = session.beginTransaction();
			org.hibernate.query.Query<Country> query = session.createQuery(hqlQuery, Country.class);
			 list = query.list();
			session.getTransaction();
			tx.commit();
			System.out.println("Here is all country..");

		} catch (Exception e) {

			if (list != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public String addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		String msg=null;
	try {
		session= factory.openSession();
		tx=session.beginTransaction();
		session.persist(emp);
		tx.commit();
		msg="Employee added Sucessifully";
	}catch (Exception e) {
		// TODO: handle exception
		if (tx != null) {
			tx.rollback();
	}
		e.printStackTrace();
	}finally {
		session.close();

	}
		return msg;
	}
	public String updateEmployee(Employee emp) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			Employee employee= 
			session.get(Employee.class, emp.getId());
			
			employee.setName(emp.getName());
			employee.setCountry(emp.getCountry());
			employee.setUpdateby(emp.getUpdateby());
			employee.setCreateby(emp.getCreateby());
			employee.setUpdatedtm(emp.getUpdatedtm());
			employee.setCreatedtm(emp.getCreatedtm());
			employee.setStatus(emp.getStatus());
			employee.setPhoneno(emp.getPhoneno());
			employee.setEmailid(emp.getEmailid());
			employee.setSalary(emp.getSalary());
			
			session.merge(employee);
			tx.commit();
			msg="Employee Updatated Successfully...";
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			
			if(session!=null) {
				session.close();
			}
			
		}
		
		
		
		return msg;
	}

	public String deleteEmployee(int id) {
		
		
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Employee emp= session.get(Employee.class, id);
			session.remove(emp);
			tx.commit();
			msg="Employee is Deleted...";
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			
			if(session!=null) {
				session.close();
			}
			
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuey="from Employee";		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Employee> query= 
			session.createQuery(hqlQuey,Employee.class);
			list= query.list();
			tx.commit();
		}catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
				}
				e.printStackTrace();
				
			}finally {
				
				if(session!=null) {
					session.close();
				}
			}	
		return list;
	}

	public Employee getParticularById(int id) {
		
		Session session=null;
		Transaction tx=null;
		Employee emp=null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
		emp= session.get(Employee.class, id);
			tx.commit();
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			if(session!=null) {
				session.close();
			}
		}	
		return emp;
	}
	
	}

	
	
