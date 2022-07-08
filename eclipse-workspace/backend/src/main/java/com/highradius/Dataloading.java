package com.highradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * Servlet implementation class Dataloading
 */
@WebServlet("/Dataloading")
public class Dataloading extends HttpServlet {
private static final long serialVersionUID = 1L;
private static final JsonElement Response = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dataloading() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub

HashMap<Object,Object> Response=new HashMap<Object,Object>();
ArrayList<pojo> data = new ArrayList<pojo>();

try {


Class.forName("com.mysql.cj.jdbc.Driver");
   Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose", "root", "Redrum@1");
   PreparedStatement ps = conn.prepareStatement("select * from winter_internship limit ?");
   ps.setInt(1, 1000);
   //String query="SELECT sl_no,business_code,cust_number,clear_date,business_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id from winter_internship";
   ResultSet result = ps.executeQuery();
   
   while(result.next()) {
    pojo ob = new pojo (
    result.getInt("sl_no"),
    result.getString("business_code"),
result.getInt("cust_number"),
result.getString("clear_date"),
result.getInt("buisness_year"),
result.getString("doc_id"),
result.getString("posting_date"),
result.getString("document_create_date"),
result.getString("due_in_date"),
result.getString("invoice_currency"),
result.getString("document_type"),
    result.getInt("posting_id"),
    result.getDouble("total_open_amount"),
    result.getString("baseline_create_date"),
    result.getString("cust_payment_terms"),
    result.getInt("invoice_id"));
   
    data.add(ob);
   }
   Response.put("data", data);
   
} catch (Exception e) {
e.printStackTrace();
}
Gson gson = new Gson();
String jsonResponse = gson.toJson(Response);
response.setHeader("Access-Control-Allow-Origin", "*");
response.getWriter().append(jsonResponse);



}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}

}