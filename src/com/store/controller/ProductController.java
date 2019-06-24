package com.store.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.store.data.ProductDAOImpl;
import com.store.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductDAOImpl productUtil = null;

	
	@Override
	public void init() throws ServletException {
		super.init();
	    productUtil = new ProductDAOImpl();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
         try {
			
			String COMMAND = request.getParameter("COMMAND");
			
			if(COMMAND==null) {
				COMMAND = "LIST";
		
			                                     }
            switch(COMMAND) {
			
			      case "LIST":
				     listProducts(request,response);
				     break;
				     
			      case "ADD":
			    	  addProducts(request,response);
			    	  break;
			    	  
			      case "DELETE":
						deleteProduct(request,response);
						break;
						
			      case "SEARCH":
			    	  searchProduct(request,response);
						break;
			    	  
			      case "LOAD":
						loadProduct(request,response);
						break;
			   
						
					case "UPDATE":
						updateProduct(request,response);
						break;
				     
				  default:
					  listProducts(request,response);
						break;
			}
		
	     }
         catch(Exception e) {
	           throw new ServletException(e);
        }

   }


	private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String searchName = request.getParameter("theSearchName");
		List<Product> productList = productUtil.searchProducts(searchName);
		request.setAttribute("PRODUCT_LIST",productList);
		RequestDispatcher rd = request.getRequestDispatcher("product-list.jsp");
		rd.forward(request, response);
				
		
	}


	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        String dateOfManufacture = request.getParameter("dateOfManufacture");
        String dateOfExpiry = request.getParameter("dateOfExpiry");
        String location = request.getParameter("location");
        String productCategory = request.getParameter("productCategory");
        String productSubCategory = request.getParameter("productSubCategory");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        		
        Date dom = new Date();
        dom = sdf.parse(dateOfManufacture);
        
        Date doe = new Date();
        doe = sdf.parse(dateOfExpiry);
        
       Product product = new Product(productId, productName, quantity, price, dom, doe, location, productCategory, productSubCategory);
       
       productUtil.updateProduct(product);
       
       listProducts(request,response);
		
	}


	private void loadProduct(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
       int productId = Integer.parseInt(request.getParameter("productId"));
		
		Product product = productUtil.getProduct(productId);
		
		request.setAttribute("PRODUCT", product);
		
		RequestDispatcher rd = request.getRequestDispatcher("update-product.jsp");
		
		rd.forward(request, response);
		
	}


	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		productUtil.deleteProduct(productId);
		listProducts(request,response);
		
	}


	private void addProducts(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String productName = request.getParameter("productName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        String dateOfManufacture = request.getParameter("dateOfManufacture");
        String dateOfExpiry = request.getParameter("dateOfExpiry");
        String location = request.getParameter("location");
        String productCategory = request.getParameter("productCategory");
        String productSubCategory = request.getParameter("productSubCategory");
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        		
        Date dom = new Date();
        dom = sdf.parse(dateOfManufacture);
        
        Date doe = new Date();
        doe = sdf.parse(dateOfExpiry);
        
        Product product = new Product(productName,quantity,price,dom,doe,location,productCategory,productSubCategory);
		
        productUtil.addProduct(product);
        
        response.sendRedirect("ProductController");
		
	}


	private void listProducts(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
        List<Product> productList = productUtil.getProducts();
		
		request.setAttribute("PRODUCT_LIST", productList);
	    
		RequestDispatcher rd = request.getRequestDispatcher("product-list.jsp");
		
		rd.forward(request,response);
		
	}
}
