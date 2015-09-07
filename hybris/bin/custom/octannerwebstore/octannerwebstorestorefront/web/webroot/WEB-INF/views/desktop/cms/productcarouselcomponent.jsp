<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/desktop/product" %>
<%@ taglib prefix="component" tagdir="/WEB-INF/tags/shared/component" %>


<head>
<style>
.custom-width{
	width:160px;
	}
	 .table-container .title{
    	font-size:1.167em;
    	font-weight:normal;
    	color:#ffffff;
        background-color: #3c3c3c;
    	padding:10px 0 10px 20px;
    	text-transform:uppercase;
    	margin:0 0 20px 0;
    }
	</style>
</head>


<c:choose>

	<c:when test="${not empty productData}">
		<div class="table-container">
		<div class="title">
			<h5>${title}<span class="label label-default"></span></h5>
			</div>
			<c:choose>

				<c:when test="${component.popup}">
					<div class="container-fluid">
                     	<div class="row-fluid">
						<c:forEach items="${productData}" var="product">

							<c:url value="${product.url}/quickView" var="productQuickViewUrl"/>
							<div class="col-md-3 custom-width" >
								<a href="${productQuickViewUrl}" class="popup scrollerProduct">
									<div class="thumb">
										<product:productPrimaryImage product="${product}" format="product"/>
									</div>

									<div class="priceContainer">
										<format:fromPrice priceData="${product.price}"/>
									</div>
									<div class="details">
											${product.name}
									</div>
								</a>
							</div>
						</c:forEach>
					</div></div>
				</c:when>

				<c:otherwise>

					<div class="row">
						<c:forEach items="${productData}" var="product">
							<c:url value="${product.url}" var="productUrl"/>
							<div class="col-md-3 custom-width" >
								<a href="${productUrl}" class="scrollerProduct">
									<div class="thumb">
										<product:productPrimaryImage product="${product}" format="product"/>
									</div>
									<div class="priceContainer">
										<format:fromPrice priceData="${product.price}"/>
									</div>
									<div class="details">
											${product.name}
									</div>
								</a>
							</div>
						</c:forEach>
					</div>
				</c:otherwise>

			</c:choose>

		</div>
	</c:when>

	<c:otherwise>
		<component:emptyComponent/>
	</c:otherwise>

</c:choose>
