/**
 * 
 */
package com.Vicarious.ServiceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Vicarious.Service.VicariousServiceI;

/**
 * @author nilesh
 *
 */


	@Service("vicariousService")
	@Transactional
	public class VicariousServiceImpl implements VicariousServiceI {


		/* (non-Javadoc)
		 * @see com.websystique.springmvc.service.VicariousService#getRandomInteger(int[])
		 */
		public int getRandomInteger(Integer... minmaxargument) {
			int retval=0;
			int minval=0;
			int maxval=0;
			// TODO Auto-generated method stub
			System.out.println("minmaxargument.length):"+minmaxargument.length);
			
			
			
			if(minmaxargument.length==0) 
				retval=(int) (Math.random()*20);
			
			if(minmaxargument.length==2) {
				List<Integer> arglst = Arrays.asList(minmaxargument);
				System.out.println("arglst.get(1)):"+arglst.get(1));
				System.out.println("arglst.get(0)):"+arglst.get(0));
				if(arglst.get(0)>arglst.get(1)) {
					minval=arglst.get(1);
					maxval=arglst.get(0);
				}else {
					minval=arglst.get(0);
					maxval=arglst.get(1);
				}
				if(maxval<=0 )maxval=20;
				if(maxval>20) maxval=20;
				if(minval<0) maxval=0;
			
				 retval=((int) (Math.random()*(maxval - minval))) + minval;
			}
				
				
			
		return retval;
		}


}
