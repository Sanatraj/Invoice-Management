package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JDBC.Jdbc_DB_connection;

/**
 * Servlet implementation class Fetch
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {
			Integer sl_no =Integer.parseInt(request.getParameter("sl_no"));

			String business_code =  request.getParameter("business_code");
			Integer cust_number =Integer.parseInt(request.getParameter("cust_number"));
			String clear_date1 = request.getParameter("clear_date");
//			DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate clear_dt = LocalDate.parse(clear_date1, formatter);
			Date clear_date = Date.valueOf(clear_dt);
//			long l=formatter.parse(clear_date1).getTime();
//			Date clear_date=new Date(clear_date);
			
			Integer buisness_year=Integer.parseInt(request.getParameter("buisness_year"));
			String doc_id=request.getParameter("doc_id");
			
			String posting_date1=request.getParameter("posting_date");			
			//DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
//			long l4=formatter.parse(posting_date).getTime();
//			Date posting_date1=new Date(l4);
			LocalDate posting_dt = LocalDate.parse(clear_date1, formatter);
			Date posting_date = Date.valueOf(posting_dt);
			//Date posting_date=(Date)formatter.parse(request.getParameter("posting_date"));
			
			String document_create_date1=request.getParameter("document_create_date");
//			long l1=formatter.parse(document_create_date1).getTime();
//			Date document_create_date=new Date(l1);
			LocalDate document_create_dt = LocalDate.parse(document_create_date1, formatter);
			Date document_create_date = Date.valueOf(document_create_dt);
			
			String due_date1=request.getParameter("due_date");
//			long l2=formatter.parse(due_date1).getTime();
//			Date due_in__date=new Date(l2);
			LocalDate due_dt = LocalDate.parse(due_date1, formatter);
			Date due_date = Date.valueOf(due_dt);
			
			
			//Date due_date=(Date)formatter.parse(request.getParameter("due_date"));
			String invoice_currency=request.getParameter("invoice_currency");
			String document_type=request.getParameter("document_type");
			Integer posting_id=Integer.parseInt(request.getParameter("posting_id"));
			Float total_open_amount=Float.parseFloat(request.getParameter("total_open_amount"));
			String baseline_create_date1=request.getParameter("document_create_date");
//			long l3=formatter.parse(baseline_create_date1).getTime();
//			Date baseline_create_date=new Date(l3);
			LocalDate baseline_create_dt = LocalDate.parse(baseline_create_date1, formatter);
			Date baseline_create_date = Date.valueOf(baseline_create_dt);
			
			//Date baseline_create_date=(Date)formatter.parse(request.getParameter("baseline_create_date"));
			String cust_payment_terms=request.getParameter("cust_payment_terms");
			Integer invoice_id=Integer.parseInt(request.getParameter("invoice_id"));
			Connection con=Jdbc_DB_connection.createConnection();
			String sql_query="INSERT INTO "
					+ "winter_internship"
					+ "(sl_no,business_code,cust_number,clear_date,buisness_year,"
					+ "doc_id,posting_date,document_create_date,due_in_date,"
					+ "invoice_currency,document_type,posting_id,total_open_amount,"
					+ "baseline_create_date,cust_payment_terms,invoice_id) VALUES "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement st=con.prepareStatement(sql_query);
			st.setInt(1, sl_no);
			st.setString(2, business_code);
			st.setInt(3, cust_number);
			st.setDate(4, (java.sql.Date) clear_date);
			st.setInt(5, buisness_year);
			st.setString(6, doc_id);
			st.setDate(7, (java.sql.Date) posting_date);
			st.setDate(8, (java.sql.Date) document_create_date);
			st.setDate(9,(java.sql.Date) due_date);
			st.setString(10, invoice_currency);
			st.setString(11, document_type);
			st.setInt(12, posting_id);
			st.setFloat(13, total_open_amount);
			st.setDate(14, (java.sql.Date) baseline_create_date);
			st.setString(15, cust_payment_terms);
			st.setInt(16, invoice_id);
			st.executeUpdate();
			System.out.println("Updated");
			response.setHeader("Access-Control-Allow-Origin","http://localhost:3000");
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
	}

}