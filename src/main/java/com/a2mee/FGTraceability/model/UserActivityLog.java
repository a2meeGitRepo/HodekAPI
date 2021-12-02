/** 11-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author {Dattatray Bodhale}
 *
 * 11-Dec-2020
 */
@Entity
@Table(name="userr_activity_log")
public class UserActivityLog {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "log_id", unique = true, nullable = false)
	private int logId;
	
	

	@Column(name="user_id")
	private String user_id;
	
	
	

	@Column(name="user_name")
	private String userName;
	

	@Column(name="activity")
	private String activity;
	
	
	
	@Column(name="packing_no")
	private String packingNo;
	
	
	
	@Column(name="qr_code")
	private String qrCode;
	
	
	
	@Column(name="spec_id")
	private int specIid;
	
	@Column(name="activity_in_shift")
	private String activityInShift;

	@Column(name="activity_date_time")
	private Date activityDateTime;

	/**
	 * @return the logId
	 */
	public int getLogId() {
		return logId;
	}

	/**
	 * @param logId the logId to set
	 */
	public void setLogId(int logId) {
		this.logId = logId;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the activity
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}

	/**
	 * @return the packingNo
	 */
	public String getPackingNo() {
		return packingNo;
	}

	/**
	 * @param packingNo the packingNo to set
	 */
	public void setPackingNo(String packingNo) {
		this.packingNo = packingNo;
	}

	/**
	 * @return the qrCode
	 */
	public String getQrCode() {
		return qrCode;
	}

	/**
	 * @param qrCode the qrCode to set
	 */
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	/**
	 * @return the specIid
	 */
	public int getSpecIid() {
		return specIid;
	}

	/**
	 * @param specIid the specIid to set
	 */
	public void setSpecIid(int specIid) {
		this.specIid = specIid;
	}

	/**
	 * @return the activityInShift
	 */
	public String getActivityInShift() {
		return activityInShift;
	}

	/**
	 * @param activityInShift the activityInShift to set
	 */
	public void setActivityInShift(String activityInShift) {
		this.activityInShift = activityInShift;
	}

	/**
	 * @return the activityDateTime
	 */
	public Date getActivityDateTime() {
		return activityDateTime;
	}

	/**
	 * @param activityDateTime the activityDateTime to set
	 */
	public void setActivityDateTime(Date activityDateTime) {
		this.activityDateTime = activityDateTime;
	}

	
	
	
	
}
