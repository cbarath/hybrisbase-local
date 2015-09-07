<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="checkout" tagdir="/WEB-INF/tags/desktop/checkout/single" %>

<spring:url value="/checkout/single/summary/getCheckoutCart.json" var="getCheckoutCartUrl" />

<script type="text/javascript"> // set vars
	 var getCheckoutCartUrl = '${getCheckoutCartUrl}';
</script>



<div id="checkoutContentPanel" data-checkout-cart-url="${getCheckoutCartUrl}" class="clearfix summaryFlow">

 <!-- KPIT : start: To align box in center -->
<div align="center">
	<checkout:summaryFlowDeliveryAddress deliveryAddress="${deliveryAddress}" costCenter="${costCenter}"/>
	<checkout:summaryFlowPayment />
</div>

 <!-- KPIT: Put div tags to hide boxes -->
<!--  <div style="visibility:hidden"> -->
	<checkout:summaryFlowPaymentType />	
	<checkout:summaryFlowCostCenter costCenter="${costCenter}" />
<!-- </div>	-->
	
	
<!-- KPIT: Put div tags to hide boxes -->
   <!-- <div style="visibility:hidden"> -->
	<checkout:summaryFlowDeliveryMode deliveryMode="${deliveryMode}" />
<!-- </div>	-->
</div>