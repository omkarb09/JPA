package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Users;
import com.lti.utils.JpaUtils;

public class UserDao {
	
	private EntityManager entityManager;
	
	public UserDao()
	{
		entityManager = JpaUtils.getEntityManager();
	}
	
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}
	
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}
	
	public void rollbackTransaction() {
		entityManager.getTransaction().rollback();
		
	}
	
	public int readLogin(String username, String password)
	{
		
		TypedQuery<Users> tquery = entityManager.createQuery("Select u From Users u Where u.username='"+username+"' and u.password='"+password+"'",Users.class);
		List<Users> users = tquery.getResultList();
		
		System.out.println(users);
		if(users !=null || users.size()>0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public List<Users> readAllUsers()
	{
		TypedQuery<Users> tquery = entityManager.createQuery("Select u From Users u Order By u.username",Users.class);
		List<Users> users = tquery.getResultList();
		return users;
	}
	
	public Users readUserByUsername(String username) {
		Users student = entityManager.find(Users.class, username);
		return student;
	}
	
	public int deleteUser(String username){
		
		/*Users user = readUserByUsername(username);
		if(user!=null)
		{
			entityManager.remove(user);
			return 1;
		}*/
		Query query = entityManager.createQuery("DELETE FROM Users u WHERE u.username='"+username+"'");
		int result = query.executeUpdate();
		
		return result;
		
	}
	
	public int createUser(Users user){
		
		entityManager.persist(user);
		return 1;
	}
	
	public Users updateUser(Users user) 
	{
		
		Users user2 = entityManager.merge(user);
		return user2;
		
	}
}


	
	
	
	
	
	
	


