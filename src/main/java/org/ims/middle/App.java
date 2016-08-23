package org.ims.middle;

import java.util.List;

import org.ims.beans.ProductBean;
import org.ims.beans.ProductCategoryBean;
import org.ims.beans.StateAbbrvBean;

public class App {
	public static void main(String[] args) {
		MiddleInterfaceF midF = new MiddleInterfaceF();
		for(ProductCategoryBean p:midF.getAllProductCats()){
			System.out.println(p.getCategoryDescription());
		}
	}
}
