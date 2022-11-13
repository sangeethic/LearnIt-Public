package ic.sangeeth.learnit.drools.promocode.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import ic.sangeeth.learnit.drools.promocode.vo.PromoCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PromoCodeService {

	public Optional<PromoCode> getPromoCode(String promocode) {
		return getPromoCodes().stream().filter(p->p.getCode().equals(promocode)).findFirst();

	}
	
	public Set<PromoCode> getPromoCodes() {
		var promoCodes = new HashSet<PromoCode>(); 

		/**
		 * 1 Nov_Promo_01 HKIA Prop1 01/11/22 30/11/22 15/11/22 30/11/22 10 percentage
		 * 
		 */

		var locations=new HashSet<String>();
		locations.add("HKIA");
		locations.add("BIAL");
		
		var properties=new HashSet<String>();
		properties.add("Prop1");
		properties.add("Prop2");
		
		var products=new HashSet<String>();
		products.add("Red Flower Boque");
		products.add("Yellow Flower Boque");
		
		var ratePlans=new HashSet<String>();
		ratePlans.add("NOV_FIRST_50");
		ratePlans.add("DEC_FIRST_100");
		
		var novPromo = PromoCode.builder().id("123").code("Nov_Promo_01").locations(locations).properties(properties).products(products).rateplans(ratePlans)
				.bookingStartDate(null).bookingEndDate(null).serviceStartDate(null).serviceEndDate(null).discount(10.0).discountType("Percentage").build();

		promoCodes.add(novPromo);
		log.info("Promocodes == {}",novPromo);

		return promoCodes;

	}
}
