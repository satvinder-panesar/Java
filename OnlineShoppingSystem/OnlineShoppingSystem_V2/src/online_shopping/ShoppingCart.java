package online_shopping;
import java.util.HashMap;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

public class ShoppingCart {
	String userId;
	//comma separated list of products
	String productIds;
	
	static HashMap<String, String> hmShoppingCarts = new HashMap<>();
	
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}
	
	public ShoppingCart(String userId, String productIds) {
		this.userId = userId;
		this.productIds = productIds;
	}
	
	public int addToCart() {
		String result = hmShoppingCarts.get(this.userId);
		if(result==null)
			hmShoppingCarts.put(this.userId, this.productIds);
		else
			hmShoppingCarts.replace(this.userId, result+","+this.productIds);
		return 1;
	}
	
	@Requires("true")
	@Ensures("verifyCount(result.length,old(userId))")
	public Product[] getProductsInCart(String userId) {
		String productslist = hmShoppingCarts.get(userId);
		if(productslist!=null) {
			int index=0;
			String[] productIds = productslist.split(",");
			Product[] products = new Product[productIds.length];
			for(String p:productIds) {
				products[index++]=new Product().getProduct(p);
			}
			return products;
		}else
			return new Product[0];
	}
	
	//used in contracts
	public boolean verifyCount(int count, String userId) {
		int actual_count=0;
		String productslist = hmShoppingCarts.get(userId);
		if(productslist!=null) {
			actual_count = productslist.split(",").length;
			if(actual_count==count)
				return true;
			return false;
		}else {
			if(count==actual_count)
				return true;
			return false;
		}
	}
	
	@Requires("true")
	@Ensures("verifyRemoval(old(userId),old(productId))")
	public void removeFromCart(String userId, String productId) {
		String productsInCart = hmShoppingCarts.get(userId);
		if(productsInCart.contains(","+productId)) {
			hmShoppingCarts.replace(userId, productsInCart.replace(","+productId, ""));
			return;
		}
		if(productsInCart.contains(","+productId+",")) {
			hmShoppingCarts.replace(userId, productsInCart.replace(","+productId+",", ""));
			return;
		}
		if(productsInCart.contains(productId+",")) {
			hmShoppingCarts.replace(userId, productsInCart.replace(productId+",", ""));
			return;
		}
		hmShoppingCarts.remove(userId);
	}
	
	//used in contracts
	public boolean verifyRemoval(String userId, String productId) {
		String productsInCart = hmShoppingCarts.get(userId);
		if(productsInCart==null)
			return true;
		if(!productsInCart.contains(productId))
			return true;
		return false;
	}
	
	public static void cleanup(String userId) {
		hmShoppingCarts.remove(userId);
	}
}
