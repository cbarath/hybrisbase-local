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
import com.octanner.core.model.CustomPriceRowModel;
import com.performance.controllers.pages.AbstractLoginPageController;
import com.performance.controllers.pages.LoginPageController;
import com.performance.custom.OctannerAutoLogin;
import com.performance.security.impl.DefaultAutoLoginStrategy;
import com.thoughtworks.xstream.converters.ConversionException;
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2b.services.B2BCustomerService;
import de.hybris.platform.b2b.services.B2BUnitService;
import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.persistence.SystemEJB;
import de.hybris.platform.persistence.security.EJBCannotDecodePasswordException;
import de.hybris.platform.persistence.security.PasswordEncoder;
import de.hybris.platform.product.PriceService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import de.hybris.platform.servicelayer.user.impl.DefaultUserService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
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
	public UserModel userModel;

	@Autowired
	public SessionService sessionService;

	@Autowired
	PriceService priceService;

	/** The auto login strategy. */
	/* @Autowired
	private OctannerAutoLogin ocTannerAutoLoginStrategy; */


	public UserDetails loadUserByUsername(String bearerToken)
			throws UsernameNotFoundException, DataAccessException
	{
		OCTannerAuthData oCTannerAuthData = null;
		oCTannerAuthData = getOCTTokenData(bearerToken);
		String u = oCTannerAuthData.getUserId();
		String x = oCTannerAuthData.getClientId();
		String userid = u+"@"+x;                                            //User UID   //String userid = StringUtils.lowerCase(oCTannerAuthData.getUserId());
		userModel = userService.getUserForUID(userid);

		PriceRowModel priceRow = new PriceRowModel();    //modelService.create(PriceRowModel.class);
		priceRow.setUnitFactor(Integer.valueOf(2));
		System.out.println("unit factor is" +priceRow.getUnitFactor());

		//final ProductModel currentProduct = (ProductModel)productService.getProductForCode("3881017").getEurope1Prices();
		//System.out.println("product is "+currentProduct);




		if((userService.isUserExisting(userid) && !(userModel.isLoginDisabled())))
		{
			System.out.println("bearrerToken recieved :: " + bearerToken);
			UserDetails user = null;
			try {
				//oCTannerAuthData = getOCTTokenData(bearerToken);
				System.out.println(ToStringBuilder.reflectionToString(oCTannerAuthData));
				StringUtils.isBlank("");
				@SuppressWarnings("deprecation")
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
				user = new User(bearerToken, "password", true, true, true, true, authorities);

				Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);


			} catch (Exception e) {
				System.out.println("Exception while logging in , will throw  UsernameNotFoundException:: " + e.getMessage());
				throw new UsernameNotFoundException("exception while creating user object", e);
			}
			//final int userpoints = 1000;                                                           //Userpoints
			final String cf = "2";                                                                        // conversion facto
			// sessionService.setAttribute("UNIT_FACTOR", cf);


			System.out.println("*************User id is***********" + " " + userid);
			System.out.println("***Checking if user is disabled or not***" + userModel.isLoginDisabled());    //checking user disabled or not.


			String encod = userModel.getPasswordEncoding();
			System.out.println("User encoding  is " + encod);        //get encoding type for password

			String encodpass = userModel.getEncodedPassword();
			//System.out.println("User pass  is " +encodpass);      //get the encoded password

			final PasswordEncoder enc = Registry.getCurrentTenant().getJaloConnection().getPasswordEncoder(encod);
			String userpass = "";
			try {
				userpass = enc.decode(encodpass);
				System.out.println("User  password  is " + userpass);    //gets the password
			} catch (EJBCannotDecodePasswordException e) {
				e.printStackTrace();
			}


			System.out.println("******************user exists in Hybris****************");
			Collection<OrderModel> orders = userModel.getOrders();
			System.out.println("Number of orders is:" + " :" + orders.size());


			//PriceRowModel priceRow = new PriceRowModel();
			//modelService.create(PriceRowModel.class);

			//priceRow.setUnitFactor(2);
			//modelService.save(priceRow);


			// (CustomPriceRowModel) modelService.get(PK.parse(""));

			//customPriceRowModel.getOctcf();
			//modelService.save(customPriceRowModel);

			//modelService.save(customPriceRowModel);

			//System.out.println("Conversion factor is set" +priceRow.getUnitFactor());

			//OctannerAutoLogin customLogin = new OctannerAutoLogin();
			//customLogin.login(userid, userpass,request,response);

			return user;
		}

		else
		{
			System.out.println("user does not exist in Hybris" + " " +userid);
			throw new UsernameNotFoundException("user does not exist in Hybris"+userid);

		}

	}

	public OCTannerAuthData getOCTTokenData(String token)
	{
		OCTannerAuthData result = null;

			OCTannerAuth authenticator = new OCTannerAuthImpl("81ca9f21318178682b924246f3812b99c61cb0a7989efabdd4254589b112ea9a");
			result = authenticator.decodeToken(token);

		return result;
	}

}



		/* oCTannerAuthData.getUserId
		Sttring userid = "123@octanner.com";*/
		/* DefaultUserService defaultuserservice = new DefaultUserService();
		usermodel = defaultuserservice.getUserForUID(StringUtils.lowerCase(oCTannerAuthData.getUserId()))
*/
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
		/* if(userModel!=null && !userModel.isLoginDisabled())
		{
			System.out.println("user exists in Hybris with uid" +userModel.getUid());

		} */
