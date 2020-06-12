package org.perscholas.bakeryshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItem {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int itemId;
		private int orderId;
		private int productId;
		private int qty;
		
		public OrderItem(int itemId, int orderId, int productId, int qty) {
			super();
			this.itemId = itemId;
			this.orderId = orderId;
			this.productId = productId;
			this.qty = qty;
		}

		public int getItemId() {
			return itemId;
		}

		public void setItemId(int itemId) {
			this.itemId = itemId;
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}
		
		
}
