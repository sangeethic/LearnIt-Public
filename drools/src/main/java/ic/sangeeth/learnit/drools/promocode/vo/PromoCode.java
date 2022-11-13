package ic.sangeeth.learnit.drools.promocode.vo;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Builder;

@lombok.Data
@Builder
public class PromoCode {

	private String id;
	private String code;
	private Set<String> properties;
	private Set<String> locations;
	private Set<String> products;
	private double price;
	private Set<String> rateplans;
	private LocalDateTime serviceStartDate;
	private LocalDateTime serviceEndDate;
	private LocalDateTime bookingStartDate;
	private LocalDateTime bookingEndDate;
	private double discount ;
	private String discountType ;

	
}