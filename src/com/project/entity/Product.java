package com.project.entity;

public class Product {

	private String productName;
	private float productBuyPrice;
	private float productSellPrice;
	private int productAmount;
	private float profit;

	public Product(String productName, float productBuyPrice, float productSellPrice, int productAmount, float profit) {
		this.productName = productName;
		this.productBuyPrice = productBuyPrice;
		this.productSellPrice = productSellPrice;
		this.productAmount = productAmount;
		this.profit = profit;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductBuyPrice() {
		return productBuyPrice;
	}

	public void setProductBuyPrice(float productBuyPrice) {
		this.productBuyPrice = productBuyPrice;
	}

	public float getProductSellPrice() {
		return productSellPrice;
	}

	public void setProductSellPrice(float productSellPrice) {
		this.productSellPrice = productSellPrice;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	public float getProfit() {
		return profit;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}
}
