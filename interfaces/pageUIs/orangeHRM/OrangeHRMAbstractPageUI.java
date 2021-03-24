package pageUIs.orangeHRM;

public class OrangeHRMAbstractPageUI {
	public static final String DYNAMIC_MENU_LINK = "//a[string()='%s']";
	public static final String DYNAMIC_BUTTON_BY_NAME_AT_FORM_HEADER = "//h1[text()='%s']/parent::div//following-sibling::div//input[@value='%s']";
	public static final String DYNAMIC_TABLE_COLUMN_NAME_SIBLING = "//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_AT_COLUMN_AND_ROW_INDEX = "//tr[%s]/td[%s]";
}
