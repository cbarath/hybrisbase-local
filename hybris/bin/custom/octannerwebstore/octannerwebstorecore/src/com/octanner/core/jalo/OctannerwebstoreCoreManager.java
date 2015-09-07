/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *  
 */
package com.octanner.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.octanner.core.constants.OctannerwebstoreCoreConstants;
import com.octanner.core.setup.CoreSystemSetup;

import org.apache.log4j.Logger;


/**
 * Don't use. User {@link CoreSystemSetup} instead.
 */
@SuppressWarnings("PMD")
public class OctannerwebstoreCoreManager extends GeneratedOctannerwebstoreCoreManager
{
	@SuppressWarnings("unused")
	private static Logger LOG = Logger.getLogger(OctannerwebstoreCoreManager.class.getName());

	public static final OctannerwebstoreCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (OctannerwebstoreCoreManager) em.getExtension(OctannerwebstoreCoreConstants.EXTENSIONNAME);
	}
}
