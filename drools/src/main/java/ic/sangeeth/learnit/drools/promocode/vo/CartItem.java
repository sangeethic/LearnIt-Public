package ic.sangeeth.learnit.drools.promocode.vo;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@lombok.Data
public class CartItem {

	private String itemId;
	private String itemDescription;
	private String product;
	private int count;
	private String rateplan;
	private String property;
	private double price;
	private String location;
	private LocalDateTime serviceDate;
	private ZonedDateTime bookingDate;
	

	
}