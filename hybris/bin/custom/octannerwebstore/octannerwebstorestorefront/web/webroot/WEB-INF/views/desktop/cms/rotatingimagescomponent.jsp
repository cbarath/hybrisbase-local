<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<head>
<style>
@media (min-width: 992px) and (max-width: 1199px) {
 .container, img{
 float:left;
  max-width: 100%;
}
}
@media (min-width: 768px) and (max-width: 991px) {
 .container, img{
float:left;
  max-width: 75%;
}
}
@media (max-width: 767px) {
 .container, img{
float:left;
  max-width: 50%;
}
}

@media (max-width: 480px) {
 .container, img{
  float:left;
  max-width: 25%;
}
}
</style>
</head>


<div class="container"><div class="row">
<div class="slider_component">
	<div id="homepage_slider" class="svw">
		<ul>
			<c:forEach items="${banners}" var="banner" varStatus="status">
				<c:if test="${ycommerce:evaluateRestrictions(banner)}">
					<c:url value="${banner.urlLink}" var="encodedUrl" />
					<li><a tabindex="-1" href="${encodedUrl}"<c:if test="${banner.external}"> target="_blank"</c:if>>
					<img src="${banner.media.url}" alt="${not empty banner.headline ? banner.headline : banner.media.altText}" title="${not empty banner.headline ? banner.headline : banner.media.altText}"/>
					</a></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>
</div>
</div></div>
