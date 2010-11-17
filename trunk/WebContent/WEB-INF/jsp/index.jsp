<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title><spring:message code="store.name"/></title>
</head>

<style type="text/css">
a:link   	{color: gray; text-decoration: none}
a:visited 	{color: gray; text-decoration: none}
a:hover 	{color: black; background-color: white; text-decoration: underline}

body {margin:0; padding:0; background:#BBBBBB;}

#category {text-align:left; padding-left:2px; font-size:16px; position: relative; top: 80px; left:10px; border-bottom: gray 2px solid; width:780px}
#footer {text-align:left; padding-left:2px; font-size:16px; position: relative; top: 80px; left:10px; border-top: gray 2px solid; width:780px}

#outer_container_1	{margin:0px auto; width:700px; padding:0 10px; background:#EEEEEE; border:1px solid #999;}
#thumbScroller_1	{position:relative; margin:auto;}
#thumbScroller_1	{width:700px;}
#thumbScroller_1, #thumbScroller_1 .container, #thumbScroller_1 .content{height:170px;}
#thumbScroller_1	{overflow:hidden;}
#thumbScroller_1 .container		{position:relative; left:0;}
#thumbScroller_1 .content		{width:260px; float:left;}
#thumbScroller_1 .content div	{padding:10px 15px; height:100%; font-family:Verdana, Geneva, sans-serif; font-size:13px;}
#thumbScroller_1 	img{border:5px solid #fff;}

#outer_container_2	{margin:10px auto; width:700px; padding:0 10px; background:#EEEEEE; border:1px solid #999;}
#thumbScroller_2	{position:relative; margin:auto;}
#thumbScroller_2	{width:700px;}
#thumbScroller_2, #thumbScroller_2 .container, #thumbScroller_2 .content{height:170px;}
#thumbScroller_2	{overflow:hidden;}
#thumbScroller_2 .container		{position:relative; left:0;}
#thumbScroller_2 .content		{width:260px; float:left;}
#thumbScroller_2 .content div	{padding:10px 15px; height:100%; font-family:Verdana, Geneva, sans-serif; font-size:13px;}
#thumbScroller_2 	img{border:5px solid #fff;}

</style>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
		<script src="js/cufon-yui.js" type="text/javascript"></script>
		<script src="js/Bebas_400.font.js" type="text/javascript"></script>
		<script type="text/javascript">
			Cufon('.cn_wrapper h1,h2', {
				textShadow: '-1px 1px black'
			});
		</script>
        <style type="text/css">
          span.reference a{
			text-shadow:1px 1px 1px #fff;
			color:#999;
			text-transform:uppercase;
            text-decoration:none;
            position:fixed;
            right:10px;
            top:10px;
            font-size:13px;
			font-weight:bold;
          }
          span.reference a:hover{
            color:#555;
          }
		  h1.title{
			  color:#777;
			  font-size:30px;
			  margin:10px;
			  font-weight:normal;
			  text-shadow:1px 1px 1px #fff;
			}
      </style>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<body>
<center>
<table width="800" height="1050" border="0" cellpadding="0" cellspacing="0"><tr>
<td width="1px" bgcolor="#888888"></td>
<td bgcolor="white" valign="top">
<div id="category">
<table width="770"><tr>
<td align="left">
	<a href="index.oz">HOME</a>
	<c:forEach items="${categoryList}" var="category">
		| <a href="category.oz?cid=<c:out value="${category.id }"/>"><c:out value="${category.name }"/></a> 
	</c:forEach>
	</td>
	<td align="right">
		<a href="cart.oz">Shopping Cart</a> | <a href="invoice.oz">Invoice Status</a>
	</td>
</tr></table>
</div>


		<div class="cn_wrapper" style="position:relative; left:-120; top:10;">
			<div id="cn_preview" class="cn_preview">
				<c:forEach items="${eventList[0].items}" var="eventItem">
				<div class="cn_content" style="top:5px;">
					<img src="<c:out value="${eventItem.pictureUrl}"/>" alt=""/>
					<h1><c:out value="${eventItem.itemName}"/></h1>
					<span class="cn_date"><fmt:formatDate type="date" value="${eventItem.lastUpdate}"/></span>
					<span class="cn_category"><c:out value="${eventItem.price}"/> AUD</span>
					<a href="item.oz?id=<c:out value="${eventItem.itemId}"/>" class="cn_more">Read more</a>
				</div>
				</c:forEach>
			</div>
			<div id="cn_list" class="cn_list">
				<div class="cn_page" style="display:block;">
					<c:forEach items="${eventList[0].items}" var="eventItem">
					<div class="cn_item">
						<h2><c:out value="${eventItem.itemName}"/></h2>
						<p>Short Description</p>
					</div>
					</c:forEach>
				</div>
				<div class="cn_nav">
					<a id="cn_prev" class="cn_prev disabled"></a>
					<a id="cn_next" class="cn_next"></a>
				</div>
			</div>
		</div>


<div style="position:relative; left:600; top:-300;">
<table>
	<tr><td align="left">[= Notice =]</td></tr>
	<c:forEach items="${noticeList}" var="notice">
	<tr><td align="left"><a href="notice.oz?nid=<c:out value="${notice.noticeId }"/>"><c:out value="${notice.title }"/></a></td></tr>
	</c:forEach>
</table>
</div>

<div id="outer_container_1">
<c:out value="${eventList[1].eventName}"/>
<div id="thumbScroller_1">
	<div class="container">
		<c:forEach items="${eventList[1].items}" var="eventItem">
    	<div class="content">
        	<div><a href="item.oz?id=<c:out value="${eventItem.itemId}"/>"><img src="<c:out value="${eventItem.pictureUrl }"/>" title="The path" alt="The path" class="thumb" /></a></div>
        </div>
		</c:forEach>
	</div>
</div>
</div>

<div id="outer_container_2">
<c:out value="${eventList[2].eventName}"/>
<div id="thumbScroller_2">
	<div class="container">
		<c:forEach items="${eventList[2].items}" var="eventItem">
    	<div class="content">
        	<div><a href="item.oz?id=<c:out value="${eventItem.itemId}"/>"><img src="<c:out value="${eventItem.pictureUrl}"/>" title="The path" alt="The path" class="thumb" /></a></div>
        </div>
		</c:forEach>
	</div>
</div>
</div>

<div id="footer">
<a href="contactus.oz">contact us</a>,  <a href="aboutus.oz">about us</a>, ...
</div>


</td>
<td width="1px" bgcolor="#888888"></td>
</tr></table></center>



<script>
	$outer_container_1=$("#outer_container_1");
	$thumbScroller_1=$("#thumbScroller_1");
	$thumbScroller_1_container=$("#thumbScroller_1 .container");
	$thumbScroller_1_content=$("#thumbScroller_1 .content");
	$thumbScroller_1_thumb=$("#thumbScroller_1 .thumb");

	var sliderWidth=$thumbScroller_1.width();
	var itemWidth=$thumbScroller_1_content.width();

	$thumbScroller_1_content.each(function (i) {
		totalContent=i*itemWidth;	
		$thumbScroller_1_container.css("width",totalContent+itemWidth);
	});

	$thumbScroller_1.mousemove(function(e){
		var mouseCoords=(e.pageX - this.offsetLeft);
	  	var mousePercentY=mouseCoords/sliderWidth;
	  	var destY=-(((totalContent-(sliderWidth-itemWidth))-sliderWidth)*(mousePercentY));
	  	var thePosA=mouseCoords-destY;
	  	var thePosB=destY-mouseCoords;
	  	if(mouseCoords==destY){
			$thumbScroller_1_container.stop();
	  	}
	  	if(mouseCoords>destY){
			$thumbScroller_1_container.css("left",-thePosA);
	  	}
	  	if(mouseCoords<destY){
			$thumbScroller_1_container.css("left",thePosB);
	  	}
	});

	var fadeSpeed=300;
	
	$thumbScroller_1_thumb.each(function () {
		var $this=$(this);
		$this.fadeTo(fadeSpeed, 0.5);
	});

	$thumbScroller_1_thumb.hover(
		function(){ //mouse over
			var $this=$(this);
			$this.stop().fadeTo(fadeSpeed, 1);
		},
		function(){ //mouse out
			var $this=$(this);
			$this.stop().fadeTo(fadeSpeed, 0.5);
		}
	);


	$outer_container_2=$("#outer_container_2");
	$thumbScroller_2=$("#thumbScroller_2");
	$thumbScroller_2_container=$("#thumbScroller_2 .container");
	$thumbScroller_2_content=$("#thumbScroller_2 .content");
	$thumbScroller_2_thumb=$("#thumbScroller_2 .thumb");

	var sliderWidth=$thumbScroller_2.width();
	var itemWidth=$thumbScroller_2_content.width();

	$thumbScroller_2_content.each(function (i) {
		totalContent=i*itemWidth;	
		$thumbScroller_2_container.css("width",totalContent+itemWidth);
	});

	$thumbScroller_2.mousemove(function(e){
		var mouseCoords=(e.pageX - this.offsetLeft);
	  	var mousePercentY=mouseCoords/sliderWidth;
	  	var destY=-(((totalContent-(sliderWidth-itemWidth))-sliderWidth)*(mousePercentY));
	  	var thePosA=mouseCoords-destY;
	  	var thePosB=destY-mouseCoords;
	  	if(mouseCoords==destY){
			$thumbScroller_2_container.stop();
	  	}
	  	if(mouseCoords>destY){
			$thumbScroller_2_container.css("left",-thePosA);
	  	}
	  	if(mouseCoords<destY){
			$thumbScroller_2_container.css("left",thePosB);
	  	}
	});

	var fadeSpeed=300;
	
	$thumbScroller_2_thumb.each(function () {
		var $this=$(this);
		$this.fadeTo(fadeSpeed, 0.5);
	});

	$thumbScroller_2_thumb.hover(
		function(){ //mouse over
			var $this=$(this);
			$this.stop().fadeTo(fadeSpeed, 1);
		},
		function(){ //mouse out
			var $this=$(this);
			$this.stop().fadeTo(fadeSpeed, 0.5);
		}
	);
</script>
</body>
</html>