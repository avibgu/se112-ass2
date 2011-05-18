
public class WebPage {

	final String _pageTechnologie;
	final String _pageContent;
	
	protected WebPage(String pageTechnologie, String pageContent) {
		_pageTechnologie = pageTechnologie;
		_pageContent = pageContent;
	}
	
	public String getPageTechnologie(){
		return _pageTechnologie;
	}
	
	public String getPageContent(){
		return _pageContent;
	}
	
	@Override
	public String toString(){
		return getPageTechnologie() + ": " + getPageContent();
	}

	static WebPage create(String technologie, String content) {
//		if (technologie.equals("HTML"))
//			return new HtmlWebPage(technologie, content);
//		else
//			return new JspWebPage(technologie, content);
		return new WebPage(technologie, content);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

/*
		//	BEFORE
		WebPage html = new HtmlWebPage();
		WebPage jsp = new JspWebPage();
		
		System.out.println(html);
		System.out.println(jsp);
*/

		WebPage html = WebPage.create("HTML", "html content from main..");
		WebPage jsp = WebPage.create("JSP", "jsp content from main..");
		
		System.out.println(html);
		System.out.println(jsp);
	}

}
