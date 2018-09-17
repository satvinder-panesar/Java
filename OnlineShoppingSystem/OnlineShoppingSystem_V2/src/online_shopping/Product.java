package online_shopping;
import java.util.HashMap;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

public class Product {
	String productName;
	String productType;	
	String productSubType;
	String productUserType;
	int productCost;
	String sellerId;
	int shippingCost;
	boolean CODFlag;
	int returnTimeframe;
	String productStatus;
	String productId;
	
	static HashMap<String, Product> hmProducts = new HashMap<>();
	
	static HashMap<String, String> hmProductTypes = new HashMap<>();
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String productName, String productType, String productSubType, String productUserType, int productCost, String sellerId, int shippingCost, boolean CODFlag,
			int returnTimeframe, String productStatus) {
		this.productName = productName;
		this.productType=productType;
		this.productSubType=productSubType;
		this.productUserType=productUserType;
		this.productCost = productCost;
		this.sellerId = sellerId;
		this.shippingCost = shippingCost;
		this.CODFlag = CODFlag;
		this.returnTimeframe = returnTimeframe;
		this.productStatus = productStatus;
		this.productId=""+System.currentTimeMillis();
	}
	
	public int addProduct() {
		hmProducts.put(this.productId, this);
		
		if(!hmProductTypes.containsKey(this.productType)) {
			hmProductTypes.put(this.productType, this.productSubType);
		}else {
			String value = hmProductTypes.get(this.productType);
			if(!value.contains(this.productSubType)) {
				hmProductTypes.replace(this.productType, value+","+this.productSubType);
			}
		}
		
		return 1;
	}
	
	@Requires("true")
	@Ensures("verifyCount(result.length)")
	public Product[] getNewProducts() {
		Product[] arr=new Product[hmProducts.size()];
		int index=0;
		for(String key:hmProducts.keySet()) {
			Product temp=hmProducts.get(key);
			if(temp.productStatus.equals("NEW")) {
				arr[index]=temp;
				index++;
			}
		}
		
		if(index>0) {
			Product[] newProducts=new Product[index];
			for(int i=0;i<index;i++) {
				newProducts[i]=arr[i];
			}
			return newProducts;
		}else
		{
			return new Product[0];
		}
		
	}
	
	//used in contracts
	public boolean verifyCount(int count) {
		Product[] arr=new Product[hmProducts.size()];
		int actual_count=0;
		for(String key:hmProducts.keySet()) {
			Product temp=hmProducts.get(key);
			if(temp.productStatus.equals("NEW")) {
				arr[actual_count]=temp;
				actual_count++;
			}
		}
		if(count==actual_count)
			return true;
		return false;
	}
	
	public int verifyProduct(String[] productIds) {
		for(String pid:productIds) {
			if(pid==null) {
				break;
			}
			Product temp = hmProducts.get(pid);
			if(temp!=null) {
				temp.productStatus="VERIFIED";
			}				
		}
		return 1;
	}
	
	public String[] getProductTypes() {
		String[] productTypes = new String[hmProductTypes.size()];
		int index=0;
		for(String key:hmProductTypes.keySet()) {
			productTypes[index++]=key;
		}
		return productTypes;
	}
	
	public String[] getProductSubTypes(String productType) {
		String productSubTypes = hmProductTypes.get(productType);
		return productSubTypes.split(",");		
	}
	
	public Product[] searchProducts(String productUserType, String productType, String productSubType) {
		
		Product[] temp = new Product[hmProducts.size()];
		int index=0;
		
		for(String key:hmProducts.keySet()) {
			Product product=hmProducts.get(key);
			if(productUserType.equals("Any")) {
				if(product.productType.equals(productType) && product.productSubType.equals(productSubType) 
						&& product.productStatus.equals("VERIFIED"))
					temp[index++]=product;
			}else {
				if(product.productUserType.equals(productUserType) && product.productType.equals(productType) 
						&& product.productSubType.equals(productSubType) && product.productStatus.equals("VERIFIED"))
					temp[index++]=product;
			}
		}	
		
		Product[] products = new Product[index];
		for(int i=0;i<index;i++) {
			products[i]=temp[i];
		}
		
		return products;
	}
	
	public int updateProductStatus(String productId, String status) {
		Product p = hmProducts.get(productId);
		if(p!=null)
			p.productStatus=status;
		return 1;
	}
	
	public Product getProduct(String productId) {
		return hmProducts.get(productId);
	}
	
	public void cleanup() {
		Product.hmProducts=null;
		Product.hmProductTypes=null;
	}
	
}
