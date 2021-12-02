/** 10-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.a2mee.FGTraceability.model.PackingTr;

/**
 * @author {Dattatray Bodhale}
 *
 * 10-Dec-2020
 */
public interface PackingTrRepo extends JpaRepository<PackingTr, Integer>,PackingTrCustomeRepo {

	/**
	 * Dattatray Bodhale
	 */
	@Query("SELECT count(p) FROM PackingTr p where  substr(p.packingCode,1,4)=?1")
	long getCountBySubString(String string);

	/**
	 * Dattatray Bodhale
	 */
	@Query("SELECT  MAX(p.packingCode)  FROM PackingTr p where  substr (p.packingCode,1,4)=?1")
	String getMaxCodeBySubString(String string);

	/**
	 * Dattatray Bodhale
	 */
	@Query(" FROM PackingTr p where  p.packingId=?1")
	Optional<PackingTr> findAllByPackingId(int packingId);

	/**
	 * Dattatray Bodhale
	 */
	@Query(" select count(*) FROM PackingTr p where  p.status='Completed'")
	int getTotalCompletePacking();

	/**
	 * Dattatray Bodhale
	 */
	@Query(" select count(*) FROM PackingTr p where  p.status='InProcess'")

	int getTotalInProcessPacking();

	@Query(" select count(*) FROM PackingTr p where  p.componentMst.componentId=?1")
	int getPackingTrByCompId(int componentId);

	@Query(" select count(*) FROM PackingTr p where  p.componentMst.componentId=?1 and Date(p.packedDate)=?2")
	int getPackingTrByCompId(int componentId, Date date);

	@Query(" FROM PackingTr p where  p.packedBy.id=?1 and Date(p.packedDate)=?2")
	List<PackingTr> getPackingTrByDateAndUserId(String id, Date forDate);

	@Query(" FROM PackingTr p where   Date(p.packedDate)=?1")
	List<PackingTr> getPackingByDate(Date date);
	@Query(" FROM PackingTr p where Date(p.packedDate)=?1 and   p.componentMst.componentId=?2")
	List<PackingTr> getPackingByDateAndComponent(Date date, int componentId);




}
