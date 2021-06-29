package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.project.entity.Product;

public class ProductManager {

	private float balance = 0;
	private float productProfit = 0;
	private List<Product> listOfProduct;

	// List of all products
	public ProductManager() {
		this.listOfProduct = new ArrayList<>();
	}

	public int addProduct(Product p) {
		this.listOfProduct.add(p);

		return count();
	}

	// Fetch all products
	public Product getProduct(int index) {
		if (index < 0 || index >= count()) {
			return null;
		}

		return this.listOfProduct.get(index);
	}

	// Remove Products
	public boolean removeProduct(String productName) {

		int index = -1;
		for (int i = 0; i < count(); i++) {

			String x = this.listOfProduct.get(i).getProductName();
			String y = productName;

			if (x.equals(y)) {
				index = i;
				break;
			}

		}

		if (index != -1) {
			this.listOfProduct.remove(index);
			return true;
		}

		return false;
	}

	// Products Selling Price
	public float getProductSellPrice(String productName) {
		float productPrice = 0;

		for (int i = 0; i < count(); i++) {

			String x = this.listOfProduct.get(i).getProductName();
			String y = productName;

			if (x.equals(y)) {

				productPrice = listOfProduct.get(i).getProductSellPrice();

				break;
			}
		}

		return productPrice;
	}

	// Products Buying Price
	public float getProductBuyPrice(String productName) {
		float productPrice = 0;

		for (int i = 0; i < count(); i++) {

			String x = this.listOfProduct.get(i).getProductName();
			String y = productName;

			if (x.equals(y)) {

				productPrice = listOfProduct.get(i).getProductBuyPrice();

				break;
			}
		}

		return productPrice;
	}

	// Individual Profit of all Products
	public float getProductProfit(String productName) {
		float productProfit = 0;

		for (int i = 0; i < count(); i++) {

			String x = this.listOfProduct.get(i).getProductName();
			String y = productName;

			if (x.equals(y)) {

				productProfit = listOfProduct.get(i).getProfit();

				break;
			}
		}

		return productProfit;
	}

	// Buy Product
	public void buyProduct(String productName, int productAmount) {
		for (int i = 0; i < count(); i++) {

			String x = this.listOfProduct.get(i).getProductName();
			String y = productName;

			if (x.equals(y)) {

				int pAmount = listOfProduct.get(i).getProductAmount();
				listOfProduct.get(i).setProductAmount(productAmount + pAmount);

				break;
			}
		}
	}

	// Sell Product
	public void sellProduct(String productName, int productAmount) {
		for (int i = 0; i < count(); i++) {

			String x = this.listOfProduct.get(i).getProductName();
			String y = productName;

			if (x.equals(y)) {

				int pAmount = listOfProduct.get(i).getProductAmount();
				listOfProduct.get(i).setProductAmount(pAmount - productAmount);

				break;
			}
		}
	}

	// Individual Profit set
	public void setAllProductProfit(String productName, float productProfit) {
		for (int i = 0; i < count(); i++) {

			String x = this.listOfProduct.get(i).getProductName();
			String y = productName;

			if (x.equals(y)) {

				listOfProduct.get(i).setProfit(productProfit);

				break;
			}
		}
	}

	// Duplicate Product Check
	public boolean checkDuplicateProduct(String productName) {
		int flag = 1;

		if (count() != 0) {
			for (int i = 0; i < count(); i++) {

				String x = this.listOfProduct.get(i).getProductName();
				String y = productName;

				if (x.equals(y)) {

					flag = 0;
					break;
				}
			}

			if (flag == 1)
				return true;
			else
				return false;
		} else {
			return true;
		}
	}

	// Available Product Check
	public int checkAvailableProduct(String productName) {
		int am = 0;
		if (count() != 0) {
			for (int i = 0; i < count(); i++) {

				String x = this.listOfProduct.get(i).getProductName();
				String y = productName;

				if (x.equals(y)) {

					am = listOfProduct.get(i).getProductAmount();
					break;
				}
			}

		}

		return am;
	}

	public int count() {
		return this.listOfProduct.size();
	}

	public float getProductProfit() {
		return productProfit;
	}

	public void setProductProfit(float productProfit) {
		this.productProfit = productProfit;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
