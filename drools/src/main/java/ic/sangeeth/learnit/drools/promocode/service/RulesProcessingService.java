package ic.sangeeth.learnit.drools.promocode.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import ic.sangeeth.learnit.drools.promocode.vo.Cart;
import ic.sangeeth.learnit.drools.promocode.vo.CartItem;
import ic.sangeeth.learnit.drools.promocode.vo.PromoCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RulesProcessingService {

	//@Autowired
	private final KieContainer kieContainer;

	public RulesProcessingService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	
	public CartItem applyRules(CartItem cartItem, PromoCode promoCode) {
		KieSession kieSession = kieContainer.newKieSession();

		log.info("Executing rules ...");

		kieSession.insert(cartItem);
		kieSession.insert(promoCode);
		kieSession.setGlobal("logger", log);
		int x=kieSession.fireAllRules();
		log.info("Rules Fired {}",x );
		log.info("Latest Cart Values after rules applied {}",cartItem);
		kieSession.dispose();
		return cartItem;
		
		
	}
	public void applyRules(Cart cart, PromoCode promoCode) {
		KieSession kieSession = kieContainer.newKieSession();

		log.info("Executing rules ...");

		kieSession.insert(cart);
		kieSession.insert(promoCode);
		kieSession.setGlobal("logger", log);
		int x=kieSession.fireAllRules();
		log.info("Rules Fired {}",x );
		log.info("Latest Cart Values after rules applied {}",cart);
		kieSession.dispose();
		
	}
}
