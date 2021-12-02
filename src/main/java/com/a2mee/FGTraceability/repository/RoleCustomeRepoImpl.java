/** 14-Jan-2021
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.a2mee.FGTraceability.access.model.Role;

/**
 * @author {Dattatray Bodhale}
 *
 * 14-Jan-2021
 */
public class RoleCustomeRepoImpl implements RoleCustomeRepo {

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.repository.RoleCustomeRepo#assignPermissions(com.a2mee.FGTraceability.access.model.Role)
	 */
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	@Transactional
	public Role assignPermissions(Role rolesDetail) {
		int id = rolesDetail.getRoleId();
		Role existingRole = entityManager.find(Role.class, id);
		if(existingRole == null) {
			existingRole = rolesDetail;
			existingRole.setRoleId(null);
		} else {
			existingRole.setName(rolesDetail.getName());
			existingRole.getRolePermission().forEach(rolePermission -> {
				entityManager.remove(rolePermission);
			});
			existingRole.setRolePermission(rolesDetail.getRolePermission());
		}
		entityManager.persist(existingRole);
		existingRole.getRolePermission().forEach(rolePermission -> {
			entityManager.persist(rolePermission);
		});
		
		entityManager.flush();
		
		
		return  existingRole;
	}
	
}
