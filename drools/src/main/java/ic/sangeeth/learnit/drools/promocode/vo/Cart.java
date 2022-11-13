package ic.sangeeth.learnit.drools.promocode.vo;

import java.util.Set;

@lombok.Data
public class Cart {

	private String cartId;
	private Set<CartItem> cartItems;
	private String promoCode;

	
}