package pageUIs.nopCommerce;

public class BasePageUI {
	
	// ko tham so = truyen co dinh ten page
	public static final String HOME_PAGE_LOGO = "//div[@class='header-logo']";
	public static final String SITE_MAP_LINK = "//a[text()='Sitemap']";
	public static final String SHOPPING_CART_LINK = "//a[text()='Shopping cart']";
	public static final String NEWS_LINK = "//ul[@class='list']//a[text()='News']";
	public static final String ABOUT_US_LINK = "//a[text()='About us']";
	
	// co 1 tham so = dynamic page name
	public static final String FOOTER_PAGE_LINK_BY_NAME = "//div[@class='footer']//a[text()='%s']";
	
	//dynamic locator
	public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_VALUE = "//button[@value='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE_BY_ID = "//span[@class='field-validation-error']/span[@id='%s-error']"; 
}
