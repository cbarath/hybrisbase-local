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
package com.performance.security;

import com.octanner.auth.OCTannerAuth;
import com.octanner.auth.OCTannerAuthData;
import com.octanner.auth.impl.OCTannerAuthImpl;
import com.performance.controllers.pages.AbstractLoginPageController;
import com.thoughtworks.xstream.converters.ConversionException;
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2b.services.B2BCustomerService;
import de.hybris.platform.b2b.services.B2BUnitService;
import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import de.hybris.platform.servicelayer.user.impl.DefaultUserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class OctannerUserDetailsService implements UserDetailsService
{

	@Resource
	private UserService userService;
	private ModelService modelService;
	private B2BCustomerService b2bCustomerService;
	private B2BUnitService b2bUnitService;
	//private ItemModel itemmodel;
	private CustomerAccountService customerAccountService;

	@Autowired
	public UserModel usermodel;

	public UserDetails loadUserByUsername(String bearerToken)
			throws UsernameNotFoundException, DataAccessException
	{
		System.out.println("bearrerToken recieved :: " + bearerToken);
		OCTannerAuthData oCTannerAuthData = getOCTTokenData(bearerToken);
		System.out.println(ToStringBuilder.reflectionToString(oCTannerAuthData));
		StringUtils.isBlank("");
		@SuppressWarnings("deprecation")
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
		UserDetails user = new User(bearerToken, "password", true, true, true, true, authorities);
		System.out.println("*************User id is***********" + " " + oCTannerAuthData.getUserId());

		/* oCTannerAuthData.getUserId
		Sttring userid = "123@octanner.com";*/

		UserModel userModel =userService.getUserForUID(StringUtils.lowerCase(oCTannerAuthData.getUserId()));
		System.out.println("***Checking if user is disabled or not***" +usermodel.isLoginDisabled());


		/* DefaultUserService defaultuserservice = new DefaultUserService();
		usermodel = defaultuserservice.getUserForUID(StringUtils.lowerCase(oCTannerAuthData.getUserId()));
*/

		if((userService.isUserExisting(StringUtils.lowerCase(oCTannerAuthData.getUserId()))) && !(usermodel.isLoginDisabled()))
		{
			System.out.println("******************user exists in Hybris***********");
		}
		else
		{
			System.out.println("user does not exist in Hybris" + " " + oCTannerAuthData.getUserId());

			/* B2BCustomerModel customer = modelService.create(B2BCustomerModel.class);
			//getCustomerAccountService().register(customer, registerData.getPassword());

			customer.setUid(oCTannerAuthData.getUserId());
			customer.setName("Test User");
			customer.setEmail("dn@test.com");

			final PrincipalGroupModel itemmodel = new PrincipalGroupModel();
			b2bCustomerService.addMember(itemmodel, b2bUnitService.getUnitForUid("pronto")); */


			//groupModel.setUid("b2bcustomergroup");
			//customer.setDefaultB2BUnit(b2bUnitModel);
			//modelService.save(customer);



			throw new UsernameNotFoundException("user does not exist in Hybris"+oCTannerAuthData.getUserId());
		}

		/* if(userModel!=null && !userModel.isLoginDisabled())
		{
			System.out.println("user exists in Hybris with uid" +userModel.getUid());

		} */

		return user;
	}

	public OCTannerAuthData getOCTTokenData(String token)
	{
		OCTannerAuthData result = null;
		try
		{

			OCTannerAuth authenticator = new OCTannerAuthImpl("81ca9f21318178682b924246f3812b99c61cb0a7989efabdd4254589b112ea9a");
			result = authenticator.decodeToken(token);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
