/** 14-Jan-2021
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import com.a2mee.FGTraceability.access.model.UserDetails;

/**
 * @author {Dattatray Bodhale}
 *
 * 14-Jan-2021
 */
public interface UserDetailsCustumeRepo {
	UserDetails addRoles(UserDetails userDetail);
	UserDetails deleteRoles(UserDetails userDetail);


}
