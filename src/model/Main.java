package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import connectionManager.Login;
import connectionManager.Product;
import dao.LoginDAO;
import dao.ProductDAO;
public class Main
{
	public static void main(String[] args)  throws NumberFormatException,IOException,ClassNotFoundException,SQLException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int choice,option;
		Login login=new Login();
		LoginDAO logindao=new LoginDAO();
		Product product=new Product();
		ProductDAO productdao=new ProductDAO();
		do {
	        System.out.println("1.Admin");
			System.out.println("2.Agent");
			System.out.println("3.Exit");
			System.out.println("-----------------------------------");
			choice=Integer.parseInt(br.readLine());
			switch(choice) 
			{
			case 1:
				System.out.println("----------------------------");
			System.out.println("Enter username");
			String username=br.readLine();
			System.out.println("Enter password");
			String password=br.readLine();
			login.setUSERNAME(username);
			login.setPASSWORD(password);
		
			if(logindao.validate(login))
			{
				System.out.println("Login Successfully");
				System.out.println("---------------------------------------------");
				do {
					System.out.println("1.Add Product");
					System.out.println("2.Display Inventory Details");
					System.out.println("3.Logout");
					System.out.println("--------------------");
					option=Integer.parseInt(br.readLine());
					switch(option) 
					{
					case 1:System.out.println("Enter product name");
					String productName=br.readLine();
					System.out.println("Enter product id");
					int productId=Integer.parseInt(br.readLine());
					System.out.println("Enter the min selling  quantity");
					int minsell=Integer.parseInt(br.readLine());
					System.out.println("Enter the price of the product");
					int price=Integer.parseInt(br.readLine());
					System.out.println("Enter the quantity");
					int quantity=Integer.parseInt(br.readLine());
					product.setPRODUCTNAME(productName);
					product.setPRODUCTID(productId);
					product.setMINSELL(minsell);
					product.setQUANTITY(quantity);
					product.setPRICE(price);
					productdao.addProduct(product);
					break;
					case 2:productdao.display();
					break;
					case 3:break;

					}
					
				}while(option!=3);
			}
			else {
				System.out.println("__________________________________________________________");
				System.out.println("Check your Username & Password");
				
			}
			break;
			case 2: System.out.println("__________________________________________________________");
			System.out.println("Enter the username: ");
			String name = br.readLine();
			System.out.println("Enter the password: ");
			String pass = br.readLine();
			login.setUSERNAME(name);
			login.setPASSWORD(pass);
			if(logindao.validate(login))
			{
				System.out.println("__________________________________________________________");
				System.out.println("Login Successful");
				
				do
				{
					System.out.println("__________________________________________________________");
					System.out.println("1.Buy/Sell");
					System.out.println("2.Show History");
					System.out.println("3.Logout");
					System.out.println("__________________________________________________________");
					option = Integer.parseInt(br.readLine());
					switch(option)
					{
					case 1: System.out.println("Buy/Sell");
					String agent = br.readLine();
					if(agent.equalsIgnoreCase("buy"))
					{
						System.out.println("Enter the product id: ");
						int productId = Integer.parseInt(br.readLine());
						System.out.println("Enter the product name: ");
						String productname = br.readLine();
						System.out.println("Enter the min selling quantity: ");
						int minsell = Integer.parseInt(br.readLine());
						System.out.println("Enter the product price: ");
						int price = Integer.parseInt(br.readLine());
						System.out.println("Enter the product quantity: ");
						int quantity = Integer.parseInt(br.readLine());
						product.setPRODUCTNAME(productname);
						product.setPRODUCTID(productId);
						product.setMINSELL(minsell);
						product.setQUANTITY(quantity);
						product.setPRICE(price);
						
						productdao.addProduct(product);
						System.out.println("__________________________________________________________");
						
					}
					else if(agent.equalsIgnoreCase("sell"))
					{
						System.out.println("__________________________________________________________");
						System.out.println("Enter the product id: ");
						int productId = Integer.parseInt(br.readLine());
						System.out.println("Enter the product quantity: ");
						int quantity = Integer.parseInt(br.readLine());
						if(productdao.quantityAvailable(productId, quantity))
						{
							int total = productdao.totalCost(productId, quantity);
							System.out.println("__________________________________________________________");
							System.out.println("Total cost is "+total);
							System.out.println("__________________________________________________________");
							System.out.println("Confirm Booking(Yes/No)");
							String booking = br.readLine();
							System.out.println("__________________________________________________________");
			
			
		   
			}
			
			
		}
					case 2:
						productdao.display();
						break;
					
		}
	}while(option!=3);
		
	}

	}
	}while(choice!=3);
			
	}
}


