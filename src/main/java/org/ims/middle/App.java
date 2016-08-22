package org.ims.middle;

import java.util.List;

import org.ims.beans.StateAbbrvBean;

public class App {
	public static void main(String[] args) {
		MiddleInterfaceF midF = new MiddleInterfaceF();
		List<StateAbbrvBean> rList =midF.printStateAbb();
		for(StateAbbrvBean s:rList){
			System.out.println(s.getStateAbbrv());
		}
	}
}
