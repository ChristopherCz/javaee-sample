package deutscherv.control;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

import deutscherv.entity.Merch;

@ApplicationScoped
public class MerchbestandFactory {

	
	@Produces
	@ApplicationScoped
	public Merchbestand createMerchSamples(@New Merchbestand merch) {
		merch.add(new Merch(1,"Banner 4x4",true));
		merch.add(new Merch(2,"LTD Tourbox",false));
		merch.add(new Merch(3,"Shirt 'No Solace'",true));
		merch.add(new Merch(4,"Shirt 'Redemption'",true));
		return merch;
	
	}
}
