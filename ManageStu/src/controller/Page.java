package controller;

public class Page {
	public int countPage(String current,String total) {
		int currentPage;
		if (current!=null&&!current.equals("")) {
			//System.out.println("current:"+current);
			String current1=current.trim();
			currentPage=Integer.parseInt(current1);
			int totalPage=Integer.parseInt(total);
			if(currentPage>totalPage){
				currentPage=totalPage;
			}
			if(currentPage<1){
				currentPage=1;
			}
		}
		else{
			currentPage=1;
		}	
		return currentPage;
	}
}
