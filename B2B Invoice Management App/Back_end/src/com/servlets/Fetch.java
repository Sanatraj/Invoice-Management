package com.servlets;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.JDBC.Jdbc_DB_connection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pojo.Pojo;

/**
 * Servlet implementation class RecieveData
 */
@WebServlet("/Fetch")
public class Fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		HashMap<Object,Object> Response=new HashMap<Object,Object>();
		ArrayList<Pojo> data = new ArrayList<>();
		try {
			
			Connection con = Jdbc_DB_connection.createConnection();
			Statement st = con.createStatement();
			String query = "SELECT sl_no,business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id from winter_internship where is_deleted=0";
			//String query = "SELECT * from winter_internship";
//			PreparedStatement ps=con.prepareStatement(query);
//			ps.setInt(1,5);
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				Pojo object = new Pojo();
				object.setSl_no(rs.getInt("sl_no"));
				object.setBusiness_code(rs.getString("business_code"));
				object.setCust_number(rs.getInt("cust_number"));
				object.setClear_date(rs.getDate("clear_date"));
				object.setBuss_year(rs.getInt("buisness_year"));
				object.setDoc_id(rs.getString("doc_id"));
				object.setPosting_date(rs.getDate("posting_date"));
				object.setDocument_create_date(rs.getDate("document_create_date"));
				//object.setDocument_create_date1(rs.getDate("document_create_date1"));
				object.setDue_in_date(rs.getDate("due_in_date"));
				object.setInvoice_currency(rs.getString("invoice_currency"));
				object.setDocument_type(rs.getString("document_type"));
				object.setPosting_id(rs.getInt("posting_id"));
				
				object.setTotal_open_amount(rs.getDouble("total_open_amount"));
				object.setBaseline_create_date(rs.getDate("baseline_create_date"));
				object.setCustomer_payment(rs.getString("cust_payment_terms"));
				object.setInvoice_id(rs.getInt("invoice_id"));
				//object.setIsOpen(rs.getInt("isOpen"));
				
				//object.setIs_deleted(rs.getInt("is_deleted"));
				
				
				
				data.add(object);
			}
			Response.put("invoiceData", data);
//			Gson gson = new GsonBuilder().serializeNulls().create();
			Gson gson = new Gson();
			String invoices  = gson.toJson(Response);
			response.setContentType("application/json");
			try {
				response.setHeader("Access-Control-Allow-Origin","http://localhost:3000");
				response.getWriter().append(invoices);//getWriter() returns a PrintWriter object that can send character text to the client. 
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			rs.close();
			st.close();
			con.close();

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}