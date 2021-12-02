package com.a2mee.FGTraceability.controller;
import com.a2mee.FGTraceability.access.model.Permission;
import com.a2mee.FGTraceability.access.model.Role;
import com.a2mee.FGTraceability.access.model.UserDetails;
import com.a2mee.FGTraceability.dto.LoginRequest;
import com.a2mee.FGTraceability.dto.LoginResponce;
import com.a2mee.FGTraceability.dto.PermissionTypeDto;
import com.a2mee.FGTraceability.dto.ResponceObj;
import com.a2mee.FGTraceability.dto.RoleDetailDto;
import com.a2mee.FGTraceability.dto.RoleDto;
import com.a2mee.FGTraceability.dto.UserPermissionDto;
import com.a2mee.FGTraceability.dto.UserRoleDto;
import com.a2mee.FGTraceability.service.AccessService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/access")
@CrossOrigin
public class AccessController {
	@Autowired
	AccessService accessService;
	

	@RequestMapping(value = "/aunthentic", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public LoginResponce serviceLogin(@RequestBody LoginRequest loginRequest) {
		

		LoginResponce loginResponce= new LoginResponce();
		
			UserDetails returnbody = accessService.getUserByUserName(loginRequest.getUserName());
			UserDetails user = new UserDetails();		
		
			if (returnbody != null) {
				if(returnbody.getDeletbit()==1){
					loginResponce.setCode(500);
					loginResponce.setMessage("Deleted User ");
			}
			else if(returnbody.getActive()!=1){
					loginResponce.setCode(500);
					loginResponce.setMessage("Inactive User");
				}else if(returnbody.getPassword().matches(loginRequest.getPassword())||(loginRequest.getPassword()==returnbody.getPassword())){
					loginResponce.setCode(200);
					loginResponce.setMessage("Login Succesfully");
					loginResponce.setData(returnbody);
				}else{
					loginResponce.setCode(500);
					loginResponce.setMessage("Invalid Password");
				}
				
			}
			else {
				loginResponce.setCode(500);
				loginResponce.setMessage("User Name Not Found");
			}
			return loginResponce;
		}
	
	
	@RequestMapping(value = "/getRoleList", method = RequestMethod.GET)
	public @ResponseBody List<Role> getRoleList() {
		List<Role> roleList = null;

		roleList= accessService.getRoleList();

		return roleList;
	}
	
	@RequestMapping(value = "/getPermissionsByUser", method = RequestMethod.GET)
	public @ResponseBody UserPermissionDto getPermissionsByUser(@RequestParam("userId") String  userId) {
		UserPermissionDto userPermissions = null;

		userPermissions= accessService.getPermissionsByUser(userId);

		return userPermissions;
	}
	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	public @ResponseBody List<UserDetails> getAllUser() {
		List<UserDetails> list = new ArrayList<UserDetails>();

		list= accessService.getAllUser();
		

		return list;
	}
	@RequestMapping(value = "/getAllUser2", method = RequestMethod.GET)
	public @ResponseBody List<UserDetails> getAllUser2() {
		List<UserDetails> list = new ArrayList<UserDetails>();

		List<UserDetails> list2= accessService.getAllUser();
		System.out.println("LIST SIZE ::   "+list2.size());

		for(UserDetails details:list2){
			

			UserDetails details2= new UserDetails();
			details2.setId(details.getId());
			details2.setActive(details.getActive());
			details2.setContactNo(details.getContactNo());
			details2.setEmailId(details.getEmailId());
			details2.setFirstName(details.getFirstName());
			details2.setLastName(details.getLastName());
			details2.setGender(details.getGender());
			details.setId(details.getId());
			details.setLastName(details.getLastName());
			details.setPassword(details.getPassword());
			details.setUsername(details.getUsername());
			list.add(details2);
		}
		for(UserDetails details:list){
			System.out.println("DETAILS ::   "+details.toString());

		}
		

		return list;
	}
	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	public @ResponseBody UserDetails getAllUserById(@RequestParam("userId") String userId) {
		UserDetails userDetails = new UserDetails();

		userDetails= accessService.getAllUserById(userId);
		

		return userDetails;
	}
	@RequestMapping(value = "/getAllRolesById", method = RequestMethod.GET)
	public @ResponseBody List<Role> getAllRolesById(@RequestParam("userId") String userId) {
		List<Role> roles= new ArrayList<Role>();

		roles= accessService.getAllRolesById(userId);
		

		return roles;
	}
	@RequestMapping(value = "/getAllRole", method = RequestMethod.GET)
	public ResponseEntity<List<RoleDto>> getAllRoles() {

		List<RoleDto> allroles = accessService.getAllRoles();
		return new ResponseEntity<List<RoleDto>>(allroles, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/allRoleDetails", method = RequestMethod.GET)
	public ResponseEntity<List<RoleDetailDto>> getAllRoleDetails() {

		List<RoleDetailDto> allroles = accessService.getAllRoleDetails();
		return new ResponseEntity<List<RoleDetailDto>>(allroles, HttpStatus.OK);

	}


	@RequestMapping(value = "/allPermissions", method = RequestMethod.GET)
	public ResponseEntity<List<Permission>> getPermissions() {
		List<Permission> allpermissions =	accessService.getAllPermsisons();
		return new ResponseEntity<List<Permission>>(allpermissions, HttpStatus.OK);
	}
	@RequestMapping(value = "/assignPermissions", method = RequestMethod.POST)
	public ResponseEntity<RoleDetailDto> assignPermissions( @RequestBody RoleDetailDto rolesDetail ){
		for(PermissionTypeDto permission:rolesDetail.getPermission()){
			System.out.println("Permission :"+permission.getPermission());
			System.out.println("Permission :"+permission.getPermissionValue());
			System.out.println("Permission :"+permission.getPermissionId());
		}
		
		RoleDetailDto permissions = accessService.assignPermissions(rolesDetail);
		return new ResponseEntity< RoleDetailDto>(permissions,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ResponseEntity<ResponceObj> editUser(@RequestBody UserDetails user){
		ResponceObj obj= new ResponceObj();
		try {
			accessService.updateUser(user);
			obj.setCode(200);
			obj.setMessage("User Updated Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			obj.setCode(200);
			obj.setMessage("SOME THING WRONG ");
		}
		
		return new ResponseEntity<ResponceObj> (obj,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
	public @ResponseBody  ResponseEntity <ResponceObj> addUser(@RequestBody UserDetails user) {
		ResponceObj obj= new ResponceObj();
		String maxUserId=accessService.getMaxUserd();
		System.out.println("MAX ID :: "+maxUserId);
		user.setId(maxUserId);
		user.setActive(1);
		UserDetails optional= accessService.getUserByUserName(user.getUsername());
		if(optional==null){
			accessService.addUser(user);
			obj.setCode(200);
			obj.setMessage("User Detials Added Successfully");
		}else{
			obj.setCode(500);
			obj.setMessage("User Name already exit");
		}
		
		return new ResponseEntity <ResponceObj> (obj,HttpStatus.CREATED);
		

	}
	@RequestMapping(value = "/getUserDetailsBuId", method = RequestMethod.GET)
	public ResponseEntity<UserDetails> getUserDetailsBuId(@RequestParam("userid") String userId) {

		UserDetails userDetails = accessService.getUserDetailsBuId(userId);
		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);

	}
	@RequestMapping(value = "/deteUser", method = RequestMethod.GET)
	public ResponseEntity<UserDetails> deteUser(@RequestParam("userId") String userId) {
System.out.println("USER ID "+userId);
		UserDetails userDetails = accessService.getUserDetailsBuId(userId);
		userDetails.setDeletbit(1);
		accessService.updateUser(userDetails);
		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/getUserRoles/{id}", method = RequestMethod.GET)
	public ResponseEntity <UserRoleDto> getUserRoles (@PathVariable String id){
	UserRoleDto userRole = accessService.getUserDetailById(id);
	return new ResponseEntity< UserRoleDto>(userRole,HttpStatus.OK);
}
	
	@RequestMapping(value = "/assignRoles", method = RequestMethod.POST)
	public ResponseEntity<UserDetails> assignRoles( @RequestBody UserDetails userDetail ){
		System.out.println("Assign Rokes ");
		UserDetails rolesassigned = accessService.assignRoles(userDetail);
		return new ResponseEntity< UserDetails>(rolesassigned,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/deleteRoles", method = RequestMethod.POST)
	public ResponseEntity<UserDetails> deleteRoles( @RequestBody UserDetails userDetail ){
		System.out.println("DELET Rokes ");
		UserDetails roledeleted = accessService.deleteRoles(userDetail);
	
		return new ResponseEntity< UserDetails>(roledeleted,HttpStatus.OK);
	}

	@RequestMapping(value = "/activate", method = RequestMethod.POST)
	public ResponseEntity<Role> setStatus(@RequestBody Role role){
		Role statuschanged = accessService.setRoleStatus(role);
	return new ResponseEntity<Role>(statuschanged,HttpStatus.ACCEPTED)	;
	}

	
}
