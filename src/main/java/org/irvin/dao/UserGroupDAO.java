package org.irvin.dao;

import java.util.ArrayList;
import java.util.List;

import org.irvin.dto.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserGroupDAO {

	   @Autowired
	   private JdbcTemplate jdbcTemplate;
		
		public List<UserGroup> getUserGroups() 
		{
			List<UserGroup> userGroups = new ArrayList<UserGroup>();
			StringBuilder query = new StringBuilder();
			
			try 
			{
				query.append("SELECT * FROM teams");
				
				userGroups = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<UserGroup>(UserGroup.class));
				
			} catch (DataAccessException e) {
				System.out.println(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			return userGroups;
		}	
		
		
		public UserGroup getUserGroup(Object[] parameters, int[] parameterTypes) 
		{
			UserGroup userGroup = new UserGroup();
			StringBuilder query = new StringBuilder();
			
			try 
			{
				query.append("SELECT * FROM teams WHERE team_id = ? ");

				userGroup = (UserGroup) jdbcTemplate.queryForObject(query.toString(), parameters, parameterTypes, new BeanPropertyRowMapper<UserGroup>(UserGroup.class));
				
			} catch (DataAccessException e) {
				System.out.println(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			return userGroup;
		}		
		
		
		public Integer createUserGroup(Object[] parameters, int[] parameterTypes) 
		{
			StringBuilder query = new StringBuilder();
			
			try 
			{
				query.append("INSERT INTO teams ");
				query.append("VALUES (?, ?, ?) ");

				return jdbcTemplate.update(query.toString(), parameters, parameterTypes);
				
			} catch (DataAccessException e) {
				System.out.println(e.getMessage());
				return 2;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return 0;
		}	
		
	
		public Integer updateUserGroup(Object[] parameters, int[] parameterTypes) 
		{
			StringBuilder query = new StringBuilder();
			
			try 
			{
				query.append("UPDATE teams SET ");
				query.append(" team_desc = ?, supervisor_id = ? ");
				query.append("WHERE team_id = ? ");

				return jdbcTemplate.update(query.toString(), parameters, parameterTypes);
				
			} catch (DataAccessException e) {
				System.out.println(e.getMessage());
				return 2;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return 0;
		}	
		
		
		public Integer deleteUserGroup(Object[] parameters, int[] parameterTypes) 
		{
			StringBuilder query = new StringBuilder();
			
			try 
			{
				query.append("DELETE FROM teams WHERE team_id = ? ");
				
				return jdbcTemplate.update(query.toString(), parameters, parameterTypes);
					
			} catch (DataAccessException e) {
				System.out.println(e.getMessage());
				return 2;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			return 0;
		}	
		
}
