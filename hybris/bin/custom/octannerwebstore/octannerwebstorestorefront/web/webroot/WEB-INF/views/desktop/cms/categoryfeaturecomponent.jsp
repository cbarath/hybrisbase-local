<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
  <style>
 .row .title h2{
     background-color: #3c3c3c;
     font-size: 1.167em;
     margin: 0 15px 0 0;
     padding: 15px 0 15px 0;
     width:215px;
     height:40px
 }
.row .action img{
    display: none;
}
 .row .title h2:hover{
     background-color: #0068b3;
 }

 .row .title h2 a{
      color: #ffffff;
      text-transform: uppercase;
      padding-left: 25px
  }
 .c-width{
 	width:230px;
 	}
  	</style>
  </head>

<c:url value="${url}" var="componentLinkUrl"/>
<c:set value="${not empty component.title ? component.title : component.category.name}" var="componentTitle"/>
<c:set value="${not empty component.description ? component.description : component.category.description}" var="componentDescription"/>

<div class="row">
	<div class="title">
		<h2><a href="${componentLinkUrl}">${componentTitle}</a></h2>
	</div>
	<div class="thumb">
		<a href="${componentLinkUrl}"><img title="${componentTitle}" alt="${componentTitle}" src="${not empty component.media.url ? component.media.url : component.category.thumbnail.url}"></a>
	</div>
	<div class="details">
		<a href="${componentLinkUrl}">${componentDescription}</a>
	</div>
	<div class="action">
		<theme:image code="img.iconArrowCategoryTile" alt="${componentTitle}"/>
	</div>
</div>

