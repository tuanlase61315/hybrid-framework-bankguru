package pageUIs.nopCommerce;

public class HomePageUI {
	public static final String HOME_PAGE_SILDER = "//div[@id='nivo-slider']";
	// public: phạm vi rộng ngoài package
	// static: biến tĩnh - cho phép 1 class khác truy cập đến biến của nay
	// mà ko cần khởi tạo đối tượng của class này lên
	// HomePageUI.HOMEPAGE_SLIDER
	// final: ngăn cản việc gán lại giá trị cho biến này
	// static final: hằng số (constant) - phải viết hoa và phân cách bằng dấu gạch nối _
	// String: kiểu dữ liệu đại diện cho xpath
	
	public static final String REGISTER_LINK= "//a[@class='ico-register']";
	public static final String LOGIN_LINK = "//a[@class='ico-login']";
	
}
