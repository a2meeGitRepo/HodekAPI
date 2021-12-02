/** 03-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a2mee.FGTraceability.access.model.Permission;
import com.a2mee.FGTraceability.access.model.Role;
import com.a2mee.FGTraceability.access.model.RolePermission;
import com.a2mee.FGTraceability.access.model.RoleUser;
import com.a2mee.FGTraceability.access.model.UserDetails;
import com.a2mee.FGTraceability.dto.PermissionTypeDto;
import com.a2mee.FGTraceability.dto.RoleDetailDto;
import com.a2mee.FGTraceability.dto.RoleDto;
import com.a2mee.FGTraceability.dto.UserPermissionDto;
import com.a2mee.FGTraceability.dto.UserRoleDto;
import com.a2mee.FGTraceability.model.UserActivityLog;
import com.a2mee.FGTraceability.repository.PermissionRepo;
import com.a2mee.FGTraceability.repository.RolePermissionRepo;
import com.a2mee.FGTraceability.repository.RoleRepo;
import com.a2mee.FGTraceability.repository.RoleUserRepo;
import com.a2mee.FGTraceability.repository.UserActivityLogRepo;
import com.a2mee.FGTraceability.repository.UserDetailsRepo;

/**
 * @author {Dattatray Bodhale}
 *
 * 03-Dec-2020
 */
@Transactional
@Service
public class AccessServiceImpl implements AccessService {

	
	
	@Autowired 
	RoleRepo roleRepo;
	@Autowired
	UserDetailsRepo userDetailsRepo;
	@Autowired
	UserActivityLogRepo userActivityLogRepo;
	@Autowired
	PermissionRepo permissionRepo;
	@Autowired
	RolePermissionRepo rolePermissionRepo;
	@Autowired
	RoleUserRepo roleUserRepo;
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#getRoleList()
	 */
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return roleRepo.getActiveRoleList();
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#getUserByUserName(java.lang.String)
	 */
	public UserDetails getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		Optional<UserDetails> optional=userDetailsRepo.findByUserName(userName);
		return optional.isPresent()?optional.get():null;
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#getPermissionsByUser()
	 */
	public UserPermissionDto  getPermissionsByUser(String userId) {
		// TODO Auto-generated method stub
		 HashMap<String, RolePermission> hmap = new HashMap<String, RolePermission>();
		 UserPermissionDto returnbody = new UserPermissionDto();
		 List <PermissionTypeDto> list = new ArrayList<PermissionTypeDto>();

//		List<PermissionTypeDto> permissionlist = new ArrayList<PermissionTypeDto>();
		 Optional<UserDetails> optional =userDetailsRepo.getUserById(userId);
		if(optional.isPresent()) {
			optional.get().getRoles().forEach(role -> {
			if(role.isActivate()) {
				role.getRolePermission().forEach(permission ->{
					
					String perm = permission.getPk().getPermission().getName();
					String type = permission.getType();
					
					if(hmap.containsKey(perm)) {
						RolePermission existingType = hmap.get(perm);
						if (existingType.getType() != "E") {
							 hmap.put(perm,  permission);		
						}
					} else {
						 hmap.put(perm,  permission);
					}
				});
		}
		});
		hmap.forEach((k,v) ->  {
			PermissionTypeDto obj = new PermissionTypeDto(k, v.getType(), v.getPermission().getPvalue());
//			obj.setPermission(k);
//			obj.setType(v);
			list.add(obj);
		
	});
		
		returnbody.setPermissions(list);
		returnbody.setName(optional.get().getFirstName());
		returnbody.setId(optional.get().getId());
		return returnbody;
		}
		
			return null;
			
	
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#getUserById(java.lang.String)
	 */
	@Override
	public UserDetails getUserById(String userId) {
		// TODO Auto-generated method stub
		Optional<UserDetails> optional=userDetailsRepo.getUserById(userId);
		return optional.isPresent()?optional.get():null;
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#saveActivityLog(com.a2mee.FGTraceability.model.UserActivityLog)
	 */
	@Override
	public void saveActivityLog(UserActivityLog activityLog) {
		// TODO Auto-generated method stub
		System.out.println("Save ACTIVIty");
		userActivityLogRepo.save(activityLog);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#getAllUser()
	 */
	@Override
	public List<UserDetails> getAllUser() {
		// TODO Auto-generated method stub
		return userDetailsRepo.getAllUser();
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#getAllRoleDetails()
	 */
	@Override
	public List<RoleDetailDto> getAllRoleDetails() {
		// TODO Auto-generated method stub
	
			List<RoleDetailDto> returnbody = new ArrayList <RoleDetailDto>();
			
			List<Role> rolelist = roleRepo.findAll();
			rolelist.forEach(role ->{
				RoleDetailDto dto = new RoleDetailDto();
				dto.setId(role.getRoleId());
				dto.setRoleName(role.getName());
				dto.setActive(role.isActivate());
				for (RolePermission rolePermission : role.getRolePermission()) {
					PermissionTypeDto permissionTypeDto = new PermissionTypeDto();
					permissionTypeDto.setPermissionId(rolePermission.getPk().getPermission().getPermissionId());
					permissionTypeDto.setPermission(rolePermission.getPk().getPermission().getName());
					permissionTypeDto.setPermissionValue(rolePermission.getPk().getPermission().getPvalue());
					permissionTypeDto.setType(rolePermission.getType());
					dto.getPermission().add(permissionTypeDto);
				}
				
				returnbody.add(dto);
			});
			return returnbody;
		}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#getAllPermsisons()
	 */
	@Override
	public List<Permission> getAllPermsisons() {
		// TODO Auto-generated method stub
		return permissionRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#assignPermissions(com.a2mee.FGTraceability.dto.RoleDetailDto)
	 */
	

	@Override
	public RoleDetailDto assignPermissions(RoleDetailDto rolesDetail) {
		Role role = new Role();
		role.setName(rolesDetail.getRoleName());
		role.setRoleId(rolesDetail.getId());
		for (PermissionTypeDto permissionTypeDto : rolesDetail.getPermission()) {
			RolePermission rp = new RolePermission();
			Permission permission = new Permission();
			permission.setName(permissionTypeDto.getPermission());
			permission.setPermissionId(permissionTypeDto.getPermissionId());
			rp.setType(permissionTypeDto.getType());
			rp.getPk().setPermission(permission);
			rp.getPk().setRole(role);
			role.getRolePermission().add(rp);
			
		}
		
		roleRepo.assignPermissions(role);
		return rolesDetail;
	}
	public  void assignPermissions1(Role role){
		Optional<Role> roles=roleRepo.findById(role.getRoleId());
		Role existingRole= new Role();
		if(! roles.isPresent()){
			existingRole = role;
			existingRole.setRoleId(null);
		}else{
			existingRole.setName(role.getName());
			existingRole.getRolePermission().forEach(rolePermission -> {
				rolePermissionRepo.delete(rolePermission);
			});
			existingRole.setRolePermission(role.getRolePermission());
		}
	
		
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#updateUser(com.a2mee.FGTraceability.access.model.UserDetails)
	 */
	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		userDetailsRepo.save(user);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#addUser(com.a2mee.FGTraceability.access.model.UserDetails)
	 */
	@Override
	public void addUser(UserDetails user) {
		// TODO Auto-generated method stub
		userDetailsRepo.save(user);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#getMaxUserd()
	 */
	@Override
	public String getMaxUserd() {
		// TODO Auto-generated method stub
		String contString="FGT";
		String newCode="";
		  int count=(int) userDetailsRepo.getCountBySubString(contString);
		  System.out.println("COUNT :: "+count);
		 if(count==0){ 
			  newCode= "0001";
			}else{
				String maxCode=userDetailsRepo.getMaxCodeBySubString(contString);
				//String maxCode= (String) entityManager.createQuery("select MAX(p.packingCode) from PackingTr p where substr(p.packingCode,1,4)=:grnNo").setParameter("packingCode", string).getSingleResult();
				System.out.println("maxCode :: "+maxCode.substring(3,7));
				String subCode="1"+maxCode.substring(3,7);
				int intCode=Integer.parseInt(subCode);
				intCode++;
				newCode=String.valueOf(intCode).substring(1,5);
				
			}
		return contString+newCode;
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#getUserDetailsBuId(java.lang.String)
	 */
	@Override
	public UserDetails getUserDetailsBuId(String userId) {
		// TODO Auto-generated method stub
		Optional<UserDetails> optional=userDetailsRepo.getUserDetailsBuId(userId);
		return optional.isPresent()?optional.get():null;
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#delet(com.a2mee.FGTraceability.access.model.UserDetails)
	 */
	@Override
	public void delet(UserDetails userDetails) {
		// TODO Auto-generated method stub
		userDetailsRepo.delete(userDetails);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#getAllRoles()
	 */
	@Override
	public List<RoleDto> getAllRoles() {
		List<RoleDto> returnbody = new ArrayList <RoleDto>();
		
		List<Role> rolelist = roleRepo.findAll();
		rolelist.forEach(role ->{
			RoleDto dto = new RoleDto();
			dto.setId(role.getRoleId());
			dto.setRoleName(role.getName());
			returnbody.add(dto);
		});
		return returnbody;
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#getUserDetailById(java.lang.String)
	 */
	@Override
	public UserRoleDto getUserDetailById(String id) {
		UserRoleDto dto = new UserRoleDto();
		Optional<UserDetails> user =  userDetailsRepo.findAllById(id);
		dto.setContactNo(user.get().getContactNo());
		dto.setEmailId(user.get().getEmailId());
		dto.setFirstName(user.get().getFirstName());
		dto.setGender(user.get().getGender());
		dto.setLastName(user.get().getLastName());
		
		user.get().getRoles().forEach(role -> {
			if(role.isActivate()) 
			{
			RoleDto roledto = new RoleDto();
			roledto.setId(role.getRoleId());
			roledto.setRoleName(role.getName());
			dto.getRoles().add(roledto);
			
			}
		});
		
		return dto ;
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#assignRoles(com.a2mee.FGTraceability.access.model.UserDetails)
	 */

	@Override
	public UserDetails assignRoles(UserDetails userDetail) {
		return userDetailsRepo.addRoles(userDetail);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#deleteRoles(com.a2mee.FGTraceability.access.model.UserDetails)
	 */
	@Override
	public UserDetails deleteRoles(UserDetails userDetail) {
		// TODO Auto-generated method stub
		return userDetailsRepo.deleteRoles(userDetail);
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#getAllUserById(java.lang.String)
	 */
	@Override
	public UserDetails getAllUserById(String userId) {
		// TODO Auto-generated method stub
		Optional<UserDetails> optional=userDetailsRepo.findAllById(userId);
		return optional.isPresent()?optional.get():null;
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#getAllRolesById(java.lang.String)
	 */
	@Override
	public List<Role> getAllRolesById(String userId) {
		// TODO Auto-generated method stub
		List<RoleUser>list=roleUserRepo.getAllRolesById(userId);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.service.AccessService#setRoleStatus(com.a2mee.FGTraceability.access.model.Role)
	 */
	@Override
	public Role setRoleStatus(Role role) {
		Role existingrole = roleRepo.getRolesById(role.getRoleId());
		existingrole.setActivate(role.isActivate());
		roleRepo.save(existingrole);
		return existingrole;
	} 

}
