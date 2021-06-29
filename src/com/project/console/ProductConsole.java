package com.project.console;

import java.util.Scanner;

import com.project.controller.ProductManager;
import com.project.entity.Product;

public class ProductConsole {

	private ProductManager pm;
	private Scanner sc;

	public ProductConsole() {
		this.sc = new Scanner(System.in);
		this.pm = new ProductManager();
	}

	// Menu
	private int menu() {
		System.out.println("------------------------");
		System.out.println("Welcome to MY SMALL SHOP");
		System.out.println("------------------------");
		System.out.println("| 1. Add a product      |");
		System.out.println("| 2. Delete a product   |");
		System.out.println("| 3. Buy a product      |");
		System.out.println("| 4. Sell a product     |");
		System.out.println("| 5. Product list       |");
		System.out.println("| 6. Available balance  |");
		System.out.println("| 7. Exit               |");
		System.out.println("------------------------\n");

		System.out.print("Choice: ");

		int choice = readInt(1, 7);

		return choice;
	}

	// Starting Point
	public void start() {

		while (true) {
			int choice = menu();

			switch (choice) {
			case 1:
				addProduct();
				break;
			case 2:
				removeProduct();
				break;
			case 3:
				buyProduct();
				break;
			case 4:
				sellProduct();
				break;
			case 5:
				productList();
				break;
			case 6:
				availableBalance();
				break;
			case 7:
				System.exit(0);
				break;
			default:
				throw new AssertionError();
			}
		}
	}

	// Getting Input for Menu in Integer
	private int readInt(int min, int max) {

		int choice;

		while (true) {
			try {
				choice = Integer.parseInt(sc.nextLine());

				if (choice >= min && choice <= max) {
					break;
				}
			} catch (Exception e) {

			}
		}

		return choice;
	}

	// 1
	private void addProduct() {

		System.out.println("---------------------Add New Product---------------------\n");

		System.out.println("Enter product name: ");
		String productName = sc.nextLine();

		System.out.println("Enter product buy price: ");
		float productBuyPrice = Float.parseFloat(sc.nextLine());

		System.out.println("Enter product sell price: ");
		float productSellPrice = Float.parseFloat(sc.nextLine());

		System.out.println("Enter product amount: ");
		int productAmount = Integer.parseInt(sc.nextLine());

		float profit = pm.getProductProfit();

		boolean checkDuplicate = pm.checkDuplicateProduct(productName);

		if (checkDuplicate == true) {
			Product p = new Product(productName, productBuyPrice, productSellPrice, productAmount, profit);
			this.pm.addProduct(p);

			System.out.println("Product Successfully Added!!!\n\n");
		} else {
			System.out.println("Duplicate product found!!!\n");
		}
	}

	// 2
	private void removeProduct() {

		if (pm.count() != 0) {
			productList();

			System.out.println("---------------------Remove Product---------------------\n");

			System.out.print("Enter product name: ");
			String productName = sc.nextLine();

			boolean result = this.pm.removeProduct(productName);

			if (result) {
				System.out.println("Product removed successfully!!!\n");
			} else {
				System.out.println("Product not found!!!\n");
			}
		} else {
			System.out.println("Empty List!!!\n");
		}

	}

	// 3
	private void buyProduct() {

		if (pm.count() != 0) {
			productList();
			System.out.println("---------------------Buy New Product---------------------\n");

			System.out.print("Enter product name: ");
			String productName = sc.nextLine();

			System.out.print("Enter amount : ");
			int productAmount = Integer.parseInt(sc.nextLine());

			float balanceCheck = pm.getBalance();

			if (balanceCheck <= 0) {
				System.out.println("Not enough balance!!!\n");
			} else {
				if (pm.checkDuplicateProduct(productName) == false) {
					float availableBalance = (pm.getBalance()) - (pm.getProductBuyPrice(productName)) * productAmount;

					if (availableBalance <= 0) {
						System.out.println("Not enough balance!!!\n");
					} else {
						pm.setBalance(availableBalance);
						pm.buyProduct(productName, productAmount);

						System.out.println("Product Added!!!\n");
					}
				} else {
					System.out.println("No product found!!!\n");
				}

			}
		} else {
			System.out.println("No product available!!!\n");
		}

	}

	// 4
	private void sellProduct() {

		if (pm.count() != 0) {
			productList();
			System.out.println("---------------------Sell Product---------------------\n");

			System.out.print("Enter product name: ");
			String productName = sc.nextLine();

			System.out.print("Enter amount : ");
			int productAmount = Integer.parseInt(sc.nextLine());

			boolean checkAvailable = pm.checkDuplicateProduct(productName);
			int checkAvailableProduct = pm.checkAvailableProduct(productName);

			if (checkAvailable == false) {
				if (checkAvailableProduct >= productAmount) {
					float p = (pm.getProductSellPrice(productName) - pm.getProductBuyPrice(productName))
							* productAmount;
					float p1 = pm.getProductProfit(productName);

					pm.setAllProductProfit(productName, p + p1);

					float availableBalance = (pm.getBalance()) + (pm.getProductSellPrice(productName)) * productAmount;

					pm.setBalance(availableBalance);
					pm.sellProduct(productName, productAmount);

					System.out.println("Product Sold!!!\n");
				} else {
					System.out.println("Not enough product!!!\n");
				}

			} else {
				System.out.println("Invalid product!!!\n");
			}
		} else {
			System.out.println("No product available!!!\n");
		}

	}

	// 5
	private void productList() {

		System.out.println("--------------------------------------------------------");
		System.out.println("Product Name\t\tAmount\t\tProfit");
		System.out.println("--------------------------------------------------------");

		if (pm.count() != 0) {
			for (int i = 0; i < this.pm.count(); i++) {
				Product p = this.pm.getProduct(i);
				System.out.format("%10s %18s %15s", p.getProductName(), p.getProductAmount(), p.getProfit());
				System.out.print("\n");
			}

			System.out.print("\n");
		} else {
			System.out.println("Empty List\n");
		}

	}

	// 6
	private void availableBalance() {

		System.out.println("Balance: " + pm.getBalance() + " BDT\n");
	}

}
