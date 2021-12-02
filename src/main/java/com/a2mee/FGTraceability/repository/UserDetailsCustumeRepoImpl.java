/** 14-Jan-2021
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.a2mee.FGTraceability.access.model.Role;
import com.a2mee.FGTraceability.access.model.UserDetails;

/**
 * @author {Dattatray Bodhale}
 *
 * 14-Jan-2021
 */
public class UserDetailsCustumeRepoImpl implements UserDetailsCustumeRepo {

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.repository.UserDetailsCustumeRepo#addRoles(com.a2mee.FGTraceability.access.model.UserDetails)
	 */

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public UserDetails addRoles(UserDetails userDetail) {
		// TODO Auto-generated method stub
		String id = userDetail.getId();
		UserDetails existingUser = entityManager.find(UserDetails.class, id);
		Set<Role> roleset = new HashSet<>();
		existingUser.getRoles().forEach(role ->{
			roleset.add(role);
		});
		userDetail.getRoles().forEach(role ->{
			roleset.add(role);
		});
		existingUser.setRoles(roleset);
		entityManager.persist(existingUser);
		entityManager.flush();
		return  existingUser;	}
	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.repository.UserDetailsCustumeRepo#deleteRoles(com.a2mee.FGTraceability.access.model.UserDetails)
	 */
	@Override
	public UserDetails deleteRoles(UserDetails userDetail) {
		// TODO Auto-generated method stub
		String id = userDetail.getId();
		UserDetails existingUser = entityManager.find(UserDetails.class, id);
		for (Role newrole : userDetail.getRoles()) {
		for (Iterator iterator = existingUser.getRoles().iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			if(!newrole.getRoleId().equals(role.getRoleId()))
				iterator.remove();				
			}
		}
			
		entityManager.persist(existingUser);
		entityManager.flush();
		return existingUser;
	}

}
