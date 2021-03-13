package pageUIs.nopCommerce;

public class CustomerPageUI {
	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	// public: phạm vi rộng ngoài package
	// static: biến tĩnh - cho phép 1 class khác truy cập đến biến của nay
	// mà ko cần khởi tạo đối tượng của class này lên
	// HomePageUI.HOMEPAGE_SLIDER
	// final: ngăn cản việc gán lại giá trị cho biến này
	// static final: hằng số (constant) - phải viết hoa và phân cách bằng dấu gạch nối _
	// String: kiểu dữ liệu đại diện cho xpath
	
	public static final String LASTNAME_TEXTBOX= "//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String SITE_MAP_LINK = "//a[text()='Sitemap']";
}
