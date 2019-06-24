package com.store.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.store.data.ConnectionFactory;
import com.store.model.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public List<Product> getProducts() throws Exception {
		
		List<Product> productList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from products order by product_name");
			rs = ps.executeQuery();
			while(rs.next()) {
				int productId = rs.getInt(1);
				String productName = rs.getString(2);
				int quantity = rs.getInt(3);
				double price = rs.getDouble(4);
				Date dateOfManufacture = rs.getDate(5);
				Date dateOfExpiry = rs.getDate(6);
				String location = rs.getString(7);
				String productCategory = rs.getString(8);
				String productSubCategory = rs.getString(9);
				
				Product product = new Product(productId, productName, quantity, price, dateOfManufacture, dateOfExpiry, location, productCategory, productSubCategory);
				
				productList.add(product);		
		   }
		}		
		finally {
			close(rs,ps,con);
		}
		return productList;
	}
		
		private void close(ResultSet rs, PreparedStatement ps, Connection con) {
			try {
				if(rs !=null) {
					rs.close();
				}
				if(ps !=null) {
					ps.close();
				}
				if(con !=null) {
					con.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public void addProduct(Product product) throws Exception{
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = ConnectionFactory.getCon();
				
		        System.out.println(product);
				
				ps = con.prepareStatement("insert products(product_name,quantity_available,price,date_of_manufacture,date_of_expiry,location,product_category,product_sub_category)values(?,?,?,?,?,?,?,?)");
				
				ps.setString(1, product.getProductName());
				ps.setInt(2, product.getQuantity());
				ps.setDouble(3, product.getPrice());
				ps.setTimestamp(4, new java.sql.Timestamp(product.getDateOfManufacture().getTime()));
				ps.setTimestamp(5, new java.sql.Timestamp(product.getDateOfExpiry().getTime()));
				ps.setString(6, product.getLocation());
				ps.setString(7, product.getProductCategory());
				ps.setString(8, product.getProductSubCategory());
				ps.executeUpdate();
				
			}
			finally {
				close(null,ps,con);
			}
			
		}

		@Override
		public void deleteProduct(int productId) throws Exception {
			
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = ConnectionFactory.getCon();
				
				ps = con.prepareStatement("delete from products where product_id = ?");
				
				ps.setInt(1, productId);
					
				ps.executeUpdate();

		}
			finally {
				close(null,ps,con);
			}
			
		}

		@Override
		public Product getProduct(int productId) throws Exception {
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Product product = null;
			
			try {
				con = ConnectionFactory.getCon();
				ps = con.prepareStatement("select * from products where product_id = ?");
				ps.setInt(1, productId);
				rs = ps.executeQuery();

				if(rs.next()) {
					
					String productName = rs.getString("product_name");
					int quantity = rs.getInt("quantity_available");
					double price = rs.getDouble("price");
					Date dateOfManufacture = rs.getDate("date_of_manufacture");
					Date dateOfExpiry = rs.getDate("date_of_expiry");
					String location = rs.getString("location");
					String productCategory = rs.getString("product_category");
					String productSubCategory = rs.getString("product_sub_category");
					
					product = new Product(productId, productName, quantity, price, dateOfManufacture, dateOfExpiry, location, productCategory, productSubCategory);
					
					
				}
				else {
					throw new Exception("Could not find Product Id: "+productId);
				}
			}
			finally {
				close(null,ps,con);
			}
			return product;
			
		}

		@Override
		public void updateProduct(Product product) throws Exception {
			
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = ConnectionFactory.getCon();
				ps = con.prepareStatement("update products set product_name=?,quantity_available=?,price=?,date_of_manufacture=?,date_of_expiry=?,location=?,product_category=?,product_sub_category=? where product_id=?");
				
				ps.setString(1, product.getProductName());
				ps.setInt(2, product.getQuantity());
				ps.setDouble(3, product.getPrice());
				ps.setTimestamp(4, new java.sql.Timestamp(product.getDateOfManufacture().getTime()));
				ps.setTimestamp(5, new java.sql.Timestamp(product.getDateOfExpiry().getTime()));
				ps.setString(6, product.getLocation());
				ps.setString(7, product.getProductCategory());
				ps.setString(8, product.getProductSubCategory());
				ps.setInt(9, product.getProductId());
				ps.executeUpdate();
				
				
			}
			finally {
				close(null,ps,con);
			}
			
			
		}

		@Override
		public List<Product> searchProducts(String searchName) throws Exception {
			
			 List<Product> productList = new ArrayList<>();
				Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
					con = ConnectionFactory.getCon();
					if(searchName != null && searchName.trim().length()>0) {
					ps = con.prepareStatement("select * from products where lower(product_name) like ? or lower(product_category) like ?");
					ps.setString(1, "%"+ searchName.toLowerCase()+"%");
					ps.setString(2, "%"+ searchName.toLowerCase()+"%");
					
					
					}
					else {
						ps = con.prepareStatement("select * from products order by product_name");
					}
					rs = ps.executeQuery();
					while(rs.next()) {
						int productId = rs.getInt(1);
						String productName = rs.getString(2);
						int quantity = rs.getInt(3);
						double price = rs.getDouble(4);
						Date dateOfManufacture = rs.getDate(5);
						Date dateOfExpiry = rs.getDate(6);
						String location = rs.getString(7);
						String productCategory = rs.getString(8);
						String productSubCategory = rs.getString(9);
						
						Product product = new Product(productId, productName, quantity, price, dateOfManufacture, dateOfExpiry, location, productCategory, productSubCategory);
						
						productList.add(product);		
					
				}
				
			}
				finally {
					close(rs,ps,con);
				}
				return productList;
		  }
			
		}


