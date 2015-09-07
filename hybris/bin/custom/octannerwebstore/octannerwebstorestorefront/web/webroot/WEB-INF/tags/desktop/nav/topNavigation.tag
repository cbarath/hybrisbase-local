<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<head>
<style>
/*
## Navigation
********************************************************************/

#nav_1{
	/*border:1px dotted #a5a5a5;
	border-width:1px 0 ;*/
	background-color: #3c3c3c;

	position:relative;
	z-index:100;
}


/*
#### 1. Navigation Level
********************************************************************/


#nav_1  li.La > a{
	display:block;
	line-height:2.750em;
	padding: 0 12px;
	color: #ffffff;
    text-transform: uppercase;/*make the nav bar items upper case*/
}


#nav_1 li.La:hover{
    background-color: #0068b3;
}

#nav_1 li.parent:hover > a{

	/*background:#eee ;*/
	margin:0 0 -1px 0;
	padding-bottom:1px;
	box-shadow: 4px 4px 4px rgba(0,0,0,0.4);
}

#nav_1 li.parent:hover > a{
	border-left:1px dotted #bfbfbf;
	border-right:1px dotted #bfbfbf;
	padding-left:11px;
	padding-right:11px;
}

/*
#### 2. Navigation Level
********************************************************************/
#nav_1 ul.Lb{
	display:none;
}


#nav_1 li.La:hover ul.Lb,
#nav_1 li.La a:focus + ul.Lb{
	display:block;
    background-color: #ffffff;
}




#nav_1 ul.Lb{
	position:absolute;
	background:#ffffff;
	left: auto;
	right: auto;
	text-align:left;
	padding:20px;
	border:1px solid #bfbfbf;
	z-index:99;
	border-top:0;
	width: 160px;
	top:34px;
	box-shadow: 4px 4px 4px rgba(0,0,0,0.4);
}



#nav_1 ul.Lb li.Lb{
	float:left;

}


#nav_1 ul.Lb li.Lb span.nav-submenu-title{
	display:block;
	font-weight:bold;
	text-transform:uppercase;
	font-size:1.167em;
	margin:0 0 10px 0;
}




#nav_1 ul.Lb li.Lb .Lc{
	float:left;
	width:181px;
}


/*
#### Facet Block
********************************************************************/

.nav_column .item li.nav_selected {
    background-color: #E3E3E3;
}

.facet_block li{
	padding-left: 3px;
}

.facet_block li:hover a{
	color: #0068b3;
}

/*
#### Special Offer
********************************************************************/

#nav_1 > ul > li:last-child{
	float:left;
}





#nav_1 .La.special_offer{
	background:#eee;

}
</style>
</head>


<nav class="navbar navbar-inverse">
<div id="nav_1" class="container-fluid">
	<cms:pageSlot position="NavigationBar" var="component" element="ul" class="clear_fix nav navbar-nav">
		<cms:component component="${component}"/>
	</cms:pageSlot>
</div>
</nav>