/** 10-Dec-2020
 * @Auther Dattatray Bodhale
 */
package com.a2mee.FGTraceability.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author {Dattatray Bodhale}
 *
 * 10-Dec-2020
 */
public class PackingTrCustomeRepoimpl implements PackingTrCustomeRepo {

	@PersistenceContext
	EntityManager entityManager;
	/*	@Override
		public String getMaxCode(String string) {
			// TODO Auto-generated method stub
			long result = (long) entityManager.createQuery("SELECT count(p) FROM PackingTr p where  substr(p.packingCode,1,4)=:packingCode").setParameter("packingCode", string).getSingleResult();
			int total_count=(int) result;
			if(total_count==0){
				return "0001";
			}else{
				String maxCode= (String) entityManager.createQuery("select MAX(p.packingCode) from PackingTr p where substr(p.packingCode,1,4)=:grnNo").setParameter("packingCode", string).getSingleResult();
				String subCode="1"+maxCode.substring(4,8);
				int intCode=Integer.parseInt(subCode);
				intCode++;
				String code=String.valueOf(intCode).substring(1,5);
				return code;
			}
		return null;
	}*/

	/* (non-Javadoc)
	 * @see com.a2mee.FGTraceability.repository.PackingTrCustomeRepo#getNewPackingCode(java.lang.String)
	 */
	/*@Override
	public String getNewPackingCode(String string) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
