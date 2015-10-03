package com.performance.custom;

import com.octanner.auth.OCTannerAuth;
import com.octanner.auth.OCTannerAuthData;
import com.octanner.auth.impl.OCTannerAuthImpl;
import de.hybris.platform.b2b.services.B2BCustomerService;
import de.hybris.platform.b2b.services.B2BUnitService;
import de.hybris.platform.commercefacades.product.PriceDataFactory;
import de.hybris.platform.commercefacades.product.data.PriceData;
import de.hybris.platform.commercefacades.product.data.PriceDataType;
import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.jalo.user.*;
import de.hybris.platform.product.PriceService;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.spring.security.CoreUserDetails;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.HybrisInitFilter;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.util.ParameterParser;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jms.connection.SessionProxy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;

import org.springframework.security.provisioning.UserDetailsManager;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.*;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.user.User;
import org.springframework.web.util.CookieGenerator;

public class OctannerUserDetailsService implements UserDetailsService, AuthenticationManager {
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
    private PriceDataFactory priceDataFactory;

    @Resource(name = "priceService")
    private PriceService priceService;

    @Resource(name = "productService")
    private ProductService productService;


    CoreUserDetails userDetails;

    public UserDetails loadUserByUsername(String bearerToken)
            throws UsernameNotFoundException, DataAccessException {

        System.out.println("bearerToken recieved :: " + bearerToken);
        String[] tokens = StringUtils.split(bearerToken, "|||");
        //String [] tokens = bearerToken.split("|||");
        System.out.println("tokens length " + tokens.length);

        String accessToken = tokens[0];
        String params = tokens[1];
        System.out.println("accessToken : " + accessToken);
        System.out.println("params : " + params);
        OCTannerAuthData oCTannerAuthData = getOCTTokenData(accessToken);
        System.out.println(ToStringBuilder.reflectionToString(oCTannerAuthData));
        EncryptionEngine encryptionEngine = new EncryptionEngine(EncryptionTypeEnum.AES256);
        String parameters = null;
        try {
            parameters = URLDecoder.decode(new String(encryptionEngine.decrypt(params)), "UTF-8");
            System.out.println("decoded url =  " + parameters);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String, String> queryMap = getURIQueries(parameters);
        if (queryMap != null) {
            Set<String> keys = queryMap.keySet();
            for (String key : keys) {
                System.out.println("Name=" + key);
                System.out.println("Value=" + queryMap.get(key));
            }
        }

        String userid = queryMap.get("employeeId") + queryMap.get("stp");
        userModel = userService.getUserForUID(userid);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new GrantedAuthorityImpl("ROLE_CUSTOMERGROUP"));
        authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
        //Check user exist in 1 or not with where
        //userService.
        System.out.println("User[" + userid + "] exists : " + userService.isUserExisting(userid));
        System.out.println(ToStringBuilder.reflectionToString(userService.getUserForUID(userid)));
        User user;

        System.out.println("ENTERING THE HYBRIS CHECK");
        if (userService.isUserExisting(userid) && !(userModel.isLoginDisabled())) {
            //login user...
            //user = userrDetailsService.loadUserByUsername(userid);  //new User(userid, password, true, true, true, true, authorities);
            System.out.println("ENTERED");
            user = UserManager.getInstance().getUserByLogin(userid);
            System.out.println("User IS " + ">>>>>>>>>>>>>>>>" + ToStringBuilder.reflectionToString(user.getLogin()));
            boolean enabled = !user.isLoginDisabledAsPrimitive();
            String password = user.getEncodedPassword(JaloSession.getCurrentSession().getSessionContext());
            if (password == null) {
                password = "1234";
            }
            System.out.println("Password is" + password);
            System.out.println("User.GETLOGIN IS " + ">>>>>>>>>>>>>>>>" + user.getLogin());
            userDetails = new CoreUserDetails(user.getLogin(), password, enabled, true, true, true, authorities, JaloSession.getCurrentSession().getSessionContext().getLanguage().getIsoCode());
            Authentication request = new UsernamePasswordAuthenticationToken(userDetails, password);
            System.out.println("Request is " + "" + ToStringBuilder.reflectionToString(request));
            System.out.println("Authentication get name is" + "" + request.getName());
            System.out.println("Authentication get principal is" + "" + request.getPrincipal());
            System.out.println("Authentication get credentials is" + "" + request.getCredentials());
            Authentication auth = authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(auth);
            System.out.println(ToStringBuilder.reflectionToString(SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
            return userDetails;

            //UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
            //SecurityContextHolder.getContext().setAuthentication(auth);
        } else {
            System.out.println("user does not exist in Hybris" + " " + userid);
            throw new UsernameNotFoundException("user does not exist in Hybris" + userid);
        }
    }


    public OCTannerAuthData getOCTTokenData(String token) {
        OCTannerAuthData result = null;
        try {

            OCTannerAuth authenticator = new OCTannerAuthImpl("81ca9f21318178682b924246f3812b99c61cb0a7989efabdd4254589b112ea9a");
            result = authenticator.decodeToken(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private Map<String, String> getURIQueries(String strUri) {

        Map queryMap = null;
        ParameterParser paramParser = new ParameterParser();
        //String strUri = URIUtil.getQuery(url);
        System.out.println("strUri " + strUri);
        if (strUri != null) {
            List list = paramParser.parse(strUri, '&');
            queryMap = getQueryMap(list);
        }
        System.out.println(queryMap);
        return queryMap;
    }

    private Map<String, String> getQueryMap(List<NameValuePair> list) {
        if (list == null) {
            return null;
        } else {
            HashMap queryMap = new HashMap();
            Iterator i$ = list.iterator();

            while (i$.hasNext()) {
                NameValuePair nameValuePair = (NameValuePair) i$.next();
                queryMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return queryMap;
        }
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        System.out.print("Entered Authentication");
        final String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
        System.out.print(" Authentication username is" +authentication.getName());
        User user = UserManager.getInstance().getUserByLogin(userDetails.getUsername());
        JaloSession.getCurrentSession().setUser(user);
        return this.createSuccessAuthentication(authentication, userDetails);
    }

    protected Authentication createSuccessAuthentication(Authentication authentication, UserDetails user) {
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user.getUsername(), authentication.getCredentials(), user.getAuthorities());
        result.setDetails(authentication.getDetails());
        return result;
    }
}