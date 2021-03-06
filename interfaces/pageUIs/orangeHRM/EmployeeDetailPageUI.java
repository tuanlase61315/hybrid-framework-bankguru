package pageUIs.orangeHRM;

public class EmployeeDetailPageUI {
	
	/* add employee */
	public static final String FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM = "//input[@id='firstName']";
	public static final String LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM = "//input[@id='lastName']";
	public static final String EMPLOYEE_ID_TEXTBOX_AT_ADD_EMPLOYEE_FORM = "//input[@id='employeeId']";
	
	/*Personal details*/
	public static final String FULLNAME_HEADER_TEXT_AT_PERSONAL_DETAIL_FORM = "//div[@id='profile-pic']/h1[text()='%s']";
	public static final String FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_txtEmpFirstName']";
	public static final String LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_txtEmpLastName']";
	public static final String EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_txtEmployeeId']";
	
	
	public static final String SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_txtNICNo']";
	public static final String GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_FORM = "//label[text()='%s']/preceding-sibling::input";
	public static final String MARITAL_STATUS_DROPDOW_AT_PERSONAL_DETAIL_FORM = "//select[@id='personal_cmbMarital']";
	public static final String NATIONALITY_DROPDOW_AT_PERSONAL_DETAIL_FORM = "//select[@id='personal_cmbNation']";
	public static final String DATE_OF_BIRTH_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_DOB']";	
	public static final String SUCCESSFULLY_MESSAGE_AT_PERSONAL_DETAIL_FORM = "//div[contains(@class,'message success')]";

	/* Salary */
	public static final String SIDEBAR_TAB_BY_NAME = "//ul[@id='sidenav']//a[text()='%s']";
	public static final String PAY_GRADE_DROPDOWN_AT_SALARY_FORM = "//select[@id='salary_sal_grd_code']";
	public static final String SALAYRY_COMPONENT_TEXTBOX_AT_SALARY_FORM = "//input[@id='salary_salary_component']";
	public static final String PAY_FREQUECY_DROPDOWN_AT_SALARY_FORM = "//select[@id='salary_payperiod_code']";
	public static final String CURENCY_DROPDOWN_AT_SALARY_FORM = "//select[@id='salary_currency_id']";
	public static final String AMOUNT_TEXTBOX_AT_SALARY_FORM = "//input[@id='salary_basic_salary']";
	public static final String COMMENT_TEXTBOX_AT_SALARY_FORM = "//textarea[@id='salary_comments']";
	
	/* Job */
	public static final String JOB_TITLE_AT_JOB_FORM = "//select[@id='job_job_title']";
	public static final String EMPLOYMENT_STATUS_AT_JOB_FORM = "//select[@id='job_emp_status']";
	public static final String JOB_CATEGORY_AT_JOB_FORM = "//select[@id='job_eeo_category']";
	public static final String JOINED_DATE_TEXTBOX_AT_JOB_FORM = "//input[@id='job_joined_date']";
	public static final String SUB_UNIT_AT_JOB_FORM = "//select[@id='job_sub_unit']";
	public static final String LOCATION_AT_JOB_FORM = "//select[@id='job_location']";
	public static final String START_DATE_TEXTBOX_AT_JOB_FORM = "//input[@id='job_contract_start_date']";
	public static final String END_DATE_TEXTBOX_AT_JOB_FORM = "//input[@id='job_contract_end_date']";

	/* Add Supervisor */
	public static final String NAME_TEXTBOX_AT_ADD_SUPERVISOR_FORM = "//input[@id='reportto_supervisorName_empName']";
	public static final String REPORTING_METHOD_DROPDOWN_AT_ADD_SUPERVISOR_FORM = "//select[@id='reportto_reportingMethodType']";

}
