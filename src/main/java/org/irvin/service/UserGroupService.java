package org.irvin.service;

import java.sql.Types;
import java.util.List;

import org.irvin.dto.UserGroup;
import org.irvin.exception.UserGroupHasDependenciesException;
import org.irvin.exception.UserGroupNotAcceptableException;
import org.irvin.exception.UserGroupNotFoundException;
import org.irvin.dao.UserGroupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGroupService {
	
	@Autowired
	UserGroupDAO userGroupDAO;
	
	public List<UserGroup> getUserGroups() 
	{
		return userGroupDAO.getUserGroups();
	}
	
	public UserGroup getUserGroup(String id) 
	{
		Object[] parameters = { id };
		int[] parameterTypes = { Types.VARCHAR };
		return userGroupDAO.getUserGroup(parameters, parameterTypes);
	}

	public UserGroup createUserGroup(UserGroup userGroup) 
	{
		Object[] parameters = { userGroup.getTeam_id(), userGroup.getTeam_desc(), userGroup.getSupervisor_id() };
		int[] parameterTypes = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		int out = userGroupDAO.createUserGroup(parameters, parameterTypes);
		if (out == 0 || out == 2)
			throw new UserGroupNotAcceptableException("User Group data is not acceptable");
		else
			return getUserGroup(userGroup.getTeam_id());
	}	
	
	public UserGroup updateUserGroup(UserGroup userGroup) 
	{
		Object[] parameters = { userGroup.getTeam_desc(), userGroup.getSupervisor_id(), userGroup.getTeam_id() };
		int[] parameterTypes = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		int out = userGroupDAO.updateUserGroup(parameters, parameterTypes);
		if (out == 0 || out == 2)
			throw new UserGroupNotAcceptableException("User Group data is not acceptable");
		else
			return getUserGroup(userGroup.getTeam_id());
	}	
	
	public void deleteUserGroup(String id) 
	{
		Object[] parameters = { id };
		int[] parameterTypes = { Types.VARCHAR };
		int out = userGroupDAO.deleteUserGroup(parameters, parameterTypes);
		if (out == 0)
			throw new UserGroupNotFoundException("id - "+id+" not found");
		else if (out == 2)
			throw new UserGroupHasDependenciesException("id - "+id+" has dependencies");
	}	
}
