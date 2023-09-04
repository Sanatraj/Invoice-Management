package com.pojo;

import java.sql.Date;
import java.time.Year;

public class Pojo {
	private Integer sl_no;
	private String business_code;
	private Integer cust_number;
	private Date clear_date;
	private Integer business_year;
	private Date due_in_date;
	private String invoice_currency;
	private String document_type;
	private Integer posting_id;
	private Double total_open_amount;
	private String doc_id;
	private Date posting_date;
	private Date document_create_date;
	private Date document_create_date1;
	private String cust_payment_terms;
	private Date baseline_create_date;
	private String aging_bucket;
	private String area_business;
	private Integer invoice_id;
	private Short isOpen;
	private Short is_deleted;
	
	public Integer getsl_no() {
		
		return sl_no;
	}
	
	public void setSl_no(Integer Sl_no)
	{
		sl_no = Sl_no;
	}
	
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String Business_code)
	{
		business_code=Business_code;
	}
	
	public Integer getCust_number() {
		return cust_number;
	}
	public void setCust_number(Integer Cust_number) {
		cust_number=Cust_number;
	}
	
	public String getInvoice_currency() {
		return invoice_currency;
	}
	public void setInvoice_currency(String Invoice_currency) {
		invoice_currency=Invoice_currency;
	}
	
	public Integer getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(Integer Invoice_id) {
		invoice_id=Invoice_id;
	}
	
	public Double getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(Double Total_open_amount) {
		total_open_amount=Total_open_amount;
	}
	
	public Integer getPosting_id() {
		return posting_id;
	}
	public void setPosting_id(Integer Posting_id) {
		posting_id=Posting_id;
	}
	
	public String getDocument_type() {
		return document_type;
	}
	public void setDocument_type(String Document_type) {
		document_type=Document_type;
	}
	
	public Date getClear_date() {
		return clear_date;
	}
	public void setClear_date(Date Clear_date) {
		clear_date=Clear_date;
	}
	
	public Integer getBuss_year() {
		return business_year;
	}
	public void setBuss_year(Integer Business_year) {
		business_year=Business_year;
	}
	
	public String getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String Doc_id) {
		doc_id=Doc_id;
	}
	
	public Date getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(Date Posting_date) {
		posting_date=Posting_date;
	}
	
	public Date getDocument_create_date() {
		return document_create_date;
	}
	public void setDocument_create_date(Date Document_create_date) {
		document_create_date=Document_create_date;
	}
	
	public Date getDocument_create_date1() {
		return document_create_date1;
	}
	public void setDocument_create_date1(Date Document_create_date1) {
		document_create_date1=Document_create_date1;
	}
	
	public String getCustomer_payment() {
		return cust_payment_terms;
	}
	public void setCustomer_payment(String Cust_payment_terms) {
		cust_payment_terms=Cust_payment_terms;
	}
	
	public String getAging_bucket() {
		return aging_bucket;
	}
	public void setAging_bucket(String Aging_bucket) {
		aging_bucket=Aging_bucket;
	}
	
	public String getArea_business() {
		return area_business;
	}
	public void setArea_business(String Area_business) {
		area_business=Area_business;
	}
	
	public Date getBaseline_create_date() {
		return baseline_create_date;
	}
	public void setBaseline_create_date(Date Baseline_create_date) {
		baseline_create_date=Baseline_create_date;
	}
	
	public Date getDue_in_date() {
		return due_in_date;
	}
	public void setDue_in_date(Date Due_in_date) {
		due_in_date=Due_in_date;
	}
	
	public Short getIs_open() {
		return isOpen;
	}
	public void setIs_open(Short IsOpen) {
		isOpen=IsOpen;
	}
	
	public short getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(Short Is_deleted) {
		is_deleted=Is_deleted;
	}
	
	@Override
	public String toString() {
		return "Invoice[business_code="+business_code+"cust_number="+cust_number+"clear_date"+clear_date+"business_year"+business_year+"doc_id"+doc_id+"posting_date"+posting_date+"document_create_date"+document_create_date+"document_create_date1"+document_create_date1+"due_in_date"+due_in_date+"invoice_currency"+invoice_currency+"document_type"+document_type+"posting_id"+posting_id+"area_business"+area_business+"total_open_amount"+total_open_amount+"baseline_create_date"+baseline_create_date+"cust_payment_terms"+cust_payment_terms+"invoice_id"+invoice_id+"isOpen"+isOpen+"aging_bucket"+aging_bucket+"is_deleted"+is_deleted+"]";
	}
}