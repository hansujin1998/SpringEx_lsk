package org.lsk.domain;

public class Criteria {
	private int pageNum;
	private int amount;
	private String search;
	private String keyword;
	
	Criteria(){
		this(1,10);
	}
	
	Criteria(int pageNum, int amount){
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return "Criteria [search=" + search + ", keyword=" + keyword + "]";
	}
	
	
}
