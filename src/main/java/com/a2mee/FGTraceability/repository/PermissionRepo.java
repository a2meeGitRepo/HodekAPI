/** 30-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.a2mee.FGTraceability.access.model.Permission;

/**
 * @author {Dattatray Bodhale}
 *
 * 30-Dec-2020
 */
public interface PermissionRepo extends JpaRepository<Permission, Integer> {

}
