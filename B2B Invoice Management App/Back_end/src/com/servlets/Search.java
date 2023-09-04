package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
 * Servlet implementation class SearchInvoice
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int rowCount = 12;*/
		
		try {
			Connection con = Jdbc_DB_connection.createConnection();
			
			boolean isAdvancedSearch = Boolean.parseBoolean(request.getParameter("isAdvancedSearch"));
			Integer cust_number = Integer.parseInt(request.getParameter("cust_number"));
			
//			String page = request.getParameter("page");

			
			Statement st = con.createStatement();
			String sql_statement = null;
			
			if(isAdvancedSearch == true) {
				Integer buisness_year = Integer.parseInt(request.getParameter("buisness_year"));
				String doc_id = request.getParameter("doc_id");
				Integer invoice_id = Integer.parseInt(request.getParameter("invoice_id"));
				
				sql_statement = "SELECT sl_no,business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id FROM winter_internship WHERE cust_number LIKE '%" + cust_number +"%'" + " OR buisness_year LIKE '%"+buisness_year+"%' OR  doc_id LIKE '%" +doc_id+"%' OR invoice_id LIKE '%" + invoice_id+"%' AND is_deleted=0;";// + "%' LIMIT " + page +"," + rowCount;
			}
			else {
				sql_statement = "SELECT sl_no,business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id FROM winter_internship WHERE is_deleted=0 AND cust_number LIKE '%" + cust_number +"%';";
			}
			
			ResultSet rs = st.executeQuery(sql_statement);

			ArrayList<Pojo> data = new ArrayList<>();
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
				object.setDue_in_date(rs.getDate("due_in_date"));
				object.setInvoice_currency(rs.getString("invoice_currency"));
				object.setDocument_type(rs.getString("document_type"));
				object.setPosting_id(rs.getInt("posting_id"));
				
				object.setTotal_open_amount(rs.getDouble("total_open_amount"));
				object.setBaseline_create_date(rs.getDate("baseline_create_date"));
				object.setCustomer_payment(rs.getString("cust_payment_terms"));
				object.setInvoice_id(rs.getInt("invoice_id"));
				data.add(object);
			}
			
			Gson gson = new GsonBuilder().serializeNulls().create();
			String invoices  = gson.toJson(data);
			response.setContentType("application/json");
			try {
				response.getWriter().write(invoices);//getWriter() returns a PrintWriter object that can send character text to the client. 
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			rs.close();
			st.close();
			con.close();
			response.setHeader("Access-Control-Allow-Origin","http://localhost:3000");
			
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