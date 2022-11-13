package ic.sangeeth.learnit.drools.promocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ic.sangeeth.learnit.drools.promocode.service.PromoCodeService;
import ic.sangeeth.learnit.drools.promocode.service.RulesProcessingService;
import ic.sangeeth.learnit.drools.promocode.vo.Cart;
import ic.sangeeth.learnit.drools.promocode.vo.CartItem;
import ic.sangeeth.learnit.drools.promocode.vo.PromoCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/promocodes")
public class RulesProcessorController {

	@Autowired
	private RulesProcessingService rulesProcessingService;

	@Autowired
	private PromoCodeService promoCodeService;

	
	@PostMapping(value = "/apply")
	public CartItem applyMapping(@RequestBody Cart cart) throws Exception {
		log.info("Request data == {}",  cart);
		var promoCodeOptional=promoCodeService.getPromoCode(cart.getPromoCode());
		PromoCode promoCode = promoCodeOptional.isPresent()?promoCodeOptional.get():null;
		log.info("PromoCode == {}", promoCode);
		return rulesProcessingService.applyRules(cart.getCartItems().iterator().next(),promoCode);
	}

}
