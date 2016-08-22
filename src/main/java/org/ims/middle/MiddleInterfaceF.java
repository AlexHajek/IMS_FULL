package org.ims.middle;

import java.util.ArrayList;
import java.util.List;

import org.ims.IMS_WEB.DataLayer;
import org.ims.beans.StateAbbrvBean;

public class MiddleInterfaceF {
	private DataLayer dLayer = new DataLayer();
	public List<StateAbbrvBean> printStateAbb(){
		List<StateAbbrvBean> rList = new ArrayList<>();
		System.out.println(dLayer.test());
		List<StateAbbrvBean> list = dLayer.getAllAbbr();
		for(StateAbbrvBean s:list){
			s.getStateName();
//			StateAbbrvBean abbrv = this.StateAbbrvBean(s);
			rList.add(s);
		}
		return rList;
	}
	@Override
	protected void finalize() throws Throwable {
		dLayer.close();
		super.finalize();
	}
	
	//"Castings"
//	private StateAbbrv castAbbrv(StateAbbrvBean s){
//		StateAbbrv abbrv = new StateAbbrv();
//		abbrv.setArrvId(s.getArrvId());
//		abbrv.setStateAbbrv(s.getStateAbbrv());
//		abbrv.setStateName(s.getStateName());
//		abbrv.setStateAddressSet(s.getStateAddressSet());
//		abbrv.setStateAddressSet(null);
//		return abbrv;
//	}
}
