package com.starboard.b2b.web.form.product;

import java.util.HashMap;
import java.util.List;

import com.starboard.b2b.dto.ProductSearchResult;

public class ViewProductModelForm {
	private List<ProductSearchResult> noWithnoseProduct;
	private List<ProductSearchResult> withnoseProduct;
	
	private HashMap<String, List<ProductSearchResult>> noWithnoseProductTechnology;
	private HashMap<String, List<ProductSearchResult>> withnoseProductTechnology;

	public ViewProductModelForm(List<ProductSearchResult> noWithnoseProduct,
			List<ProductSearchResult> withnoseProduct) {
		this.noWithnoseProduct = noWithnoseProduct;
		this.withnoseProduct = withnoseProduct;
	}
	
	public void setNoWithnoseProductTechnology(){
		for (ProductSearchResult productSearchResult : noWithnoseProduct) {
			
		}
	}

}
