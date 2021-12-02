/** 14-Jan-2021
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.access.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author {Dattatray Bodhale}
 *
 * 14-Jan-2021
 */
@Entity
@Table(name = "access_user_role")
public class RoleUser {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "user_id")
	private String user_id;
	@Column(name = "role_id")
	private Integer role_id;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the role_id
	 */
	public Integer getRole_id() {
		return role_id;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	
	
}
