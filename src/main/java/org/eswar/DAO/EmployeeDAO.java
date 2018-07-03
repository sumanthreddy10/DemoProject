package org.eswar.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDAO 
{

	public void addEmployee(Employee bean)
	{
        Session session = HibernateUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addEmployee(session,bean);        
        tx.commit();
        session.close();
    }
	private void addEmployee(Session session, Employee bean){
        Employee employee = new Employee();
        
        employee.setEname(bean.getEname());
        employee.setSalary(bean.getSalary());
        
        session.save(employee);
    }
	public List<Employee> getEmployees()
	{
        Session session = HibernateUtil.getSession();    
        Query query = session.createQuery("from Employee");
        List<Employee> employees =  query.list();
        session.close();
        return employees;
    }
	public int deleteEmployee(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Employee where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
    
    public int updateEmployee(int id, Employee emp){
         if(id <=0)  
               return 0;  
         Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Employee set ename = :name, salary=:salary where eid = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id",id);
            query.setString("name",emp.getEname());
            query.setDouble("salary",emp.getSalary());
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            tx.commit();
            session.close();
            return rowCount;
    }
}
