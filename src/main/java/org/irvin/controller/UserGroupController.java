package org.irvin.controller;

import java.util.List;

import org.irvin.dto.UserGroup;
import org.irvin.exception.UserGroupNotFoundException;
import org.irvin.service.UserGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/UserGroupManagement")
public class UserGroupController {

	@Autowired
	UserGroupService userGroupService;
	
    @GetMapping(value = "/userGroups", produces = { "application/json", "application/xml" })
    @ResponseBody
    public List<UserGroup> getUserGroups() {
		return userGroupService.getUserGroups();
	}	
   
    @GetMapping(value = "/userGroups/{id}", produces = { "application/json", "application/xml" })
    @ResponseBody
    public UserGroup getUserGroup(@PathVariable("id") String id) {
    	
    	UserGroup userGroup = userGroupService.getUserGroup(id);
    	if (userGroup.getTeam_id() == null)
    		throw new UserGroupNotFoundException("id - "+id+" not found");
		return userGroup;
	}	
    

    @PostMapping(value = "/userGroups")
    @ResponseBody
    public UserGroup createUserGroup(@RequestBody UserGroup userGroup) {

    	return userGroupService.createUserGroup(userGroup);
		
	}        
   
    @PutMapping(value = "/userGroups")
    @ResponseBody
    public UserGroup updateUserGroup(@RequestBody UserGroup userGroup) {

    	return userGroupService.updateUserGroup(userGroup);
		
	}     
    
    @DeleteMapping(value = "/userGroups/{id}")
    @ResponseBody
    public void deleteUserGroup(@PathVariable("id") String id) {
    	
    	userGroupService.deleteUserGroup(id);
		
	}    
	
}
