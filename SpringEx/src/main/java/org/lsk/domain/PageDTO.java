package org.lsk.domain;

public class PageDTO {
	private int startPage;
	private int endPage;
	
	// 이전페이지 유무
	private boolean next;
	
	// 다음페이지 유무
	private boolean prev;
	// board 테이블의 총 데이터 건수
	
	private int total;
	//endPage 페이지 수를 계산하기 위한 pageNum가 필요하므로 Criteria 클래스를 포함.
	
	public PageDTO(Criteria cri, int total){
		this.cri=cri;
		this.total=total;
		
		// (int)(Math.ceil)(현재 페이지번호/10.0))*10;
		this.endPage=(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		
		// 10-9=1, 20-9=11
		this.startPage = endPage-9;
		
		// 전체 건수를 고려한 endPage -> realEnd
		int realEnd=(int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		// realEnd > endpage => realEnd값을 endPage에 저장
		if(realEnd<endPage) {
			this.endPage=realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
	
	private Criteria cri;
	
	public int getTotal() {
		return total;
	}

	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", next=" + next + ", prev=" + prev
				+ ", total=" + total + ", cri=" + cri + "]";
	}
	
}
