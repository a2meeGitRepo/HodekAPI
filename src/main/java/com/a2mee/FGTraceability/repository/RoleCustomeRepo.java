/** 14-Jan-2021
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import com.a2mee.FGTraceability.access.model.Role;

/**
 * @author {Dattatray Bodhale}
 *
 * 14-Jan-2021
 */
public interface RoleCustomeRepo {
	Role assignPermissions(Role role);
}
