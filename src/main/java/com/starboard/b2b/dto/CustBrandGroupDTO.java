package com.starboard.b2b.dto;


public class CustBrandGroupDTO extends BaseDTO {
	private long custId;
	private long brandGroupId;
	private long productTypeId;
	/*private Date timeCreate;
	private Date timeUpdate;*/
	private String productTypeName;
	private String productTypeDescription;
	private String userCreate;
	private String userUpdate;
	public CustBrandGroupDTO(){
		
	}
	public CustBrandGroupDTO(long custId,long brandGroupId,long productTypeId,String productTypeName,String productTypeDescription,String userCreate,String userUpdate){
		super();
		this.custId = custId;
		this.brandGroupId = brandGroupId;
		this.productTypeId = productTypeId;
		/*this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;*/
		this.productTypeName = productTypeName;
		this.productTypeDescription = productTypeDescription;
		this.userCreate = userCreate;
		this.userUpdate = userUpdate;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public long getBrandGroupId() {
		return brandGroupId;
	}
	public void setBrandGroupId(long brandGroupId) {
		this.brandGroupId = brandGroupId;
	}
	public long getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(long productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public String getProductTypeDescription() {
		return productTypeDescription;
	}
	public void setProductTypeDescription(String productTypeDescription) {
		this.productTypeDescription = productTypeDescription;
	}
	public String getUserCreate() {
		return userCreate;
	}
	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}
	public String getUserUpdate() {
		return userUpdate;
	}
	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}
}
