package com.octanner.core.custom;


import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.impl.DefaultCartFactory;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.site.BaseSiteService;
import de.hybris.platform.store.services.BaseStoreService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bharath on 8/18/2015.
 */

public class OctannerCartFactory extends DefaultCartFactory
{

    @Autowired
    ModelService modelService;

    @Autowired
    BaseSiteService baseSiteService;

    @Autowired
    BaseStoreService baseStoreService;

    @Override
    protected CartModel createCartInternal()
    {
        CartModel cartInternal = super.createCartInternal();
        cartInternal.setPurchaseOrderNumber(cartInternal.getCode());
        cartInternal.setSite(baseSiteService.getCurrentBaseSite());
        cartInternal.setStore(baseStoreService.getCurrentBaseStore());
        return cartInternal;
    }

}