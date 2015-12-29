<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>详情</title>

    <!-- Sets initial viewport load and disables zooming  -->
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, minimal-ui">

    <!-- Makes your prototype chrome-less once bookmarked to your phone's home screen -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">

    <!-- Include the compiled Ratchet CSS -->
    <link href="css/ratchet.css" rel="stylesheet" type="text/css">

  <!-- Include the compiled Ratchet JS -->
  <script src="js/ratchet.js"></script>
  <script src="js/push.js"></script>
  <script src="js/sliders.js"></script>
  <script type="text/javascript">
  	function showDeriction(){
		var div=document.getElementById("deriction");
		if (div.style.display == "block") {
            div.style.display = "none";
        } else if (div.style.display == "none") {
            div.style.display = "block"
        }
		}
	function Go(){
		var gid = document.getElementById("gid").value;
		window.location.href='toproducts!todiscuss?gid='+gid;
		}
  </script>
  <style>
  .row_text{
	  background-color:#D9FFE2; color:#000;
	  }
  </style>
  </head>
 
  <body>

    <!-- Make sure all your bars are the first things in your <body> -->
   <!-- <header class="bar bar-nav">
      <h1 class="title">aaa</h1><a href="ratchet.html">Ratchet</a>
    </header>-->

    <!-- Wrap all non-bar HTML in the .content div (this is actually what scrolls) -->
    <div class="content">
       <div class="slider" id="mySlider" style="background-color:#CCC">
        <div class="slide-group">
        	<div class="slide">
            	<!--<img  width="100%" height="40%" src=" images/<s:property value="prod.img.img1_src"/>"/>
            	--><img style="height: 40%; width: 100%" src="images/<s:property value="prod.img.img1_src"/>" alt="...">
            </div>
            <div class="slide">
            	<img style="height: 40%; width: 100%"  src="images/<s:property value="prod.img.img1_src"/>" alt="...">
            </div>
            <div class="slide">
            	<img style="height: 40%; width: 100%"  src="images/<s:property value="prod.img.img1_src"/>" alt="...">
            </div>
        </div>
       </div>                
       
       <ul class="tab-view" style="margin-left:-50px; margin-top:-5px;">
       	<li class="table-view-cell">
        	<p style="color:#C00">￥<fmt:formatNumber value="${prod.prod_discount*prod.prod_price}" pattern="#0.00"/></p>
            <p style="color:#000;">
            	<span style="text-decoration:line-through; color:#999; margin-right:10px">￥<fmt:formatNumber value="${prod.prod_price}" pattern="#0.00"/></span>
            	节省<span>￥<fmt:formatNumber value="${prod.prod_price-prod.prod_discount*prod.prod_price}" pattern="#0.00"/></span>
            </p>
        </li>
        <li class="table-view-cell">
        	<span><s:property value="prod.prod_name"/></span>
            <p>规格：<span><s:property value="prod.prod_format"/></span></p>
            <p>厂家：<span><s:property value="prod_chandi"/></span></p>
        </li>
        <li class="table-view-cell" media>
        	<a class="navigate-right" onClick="showDeriction()">
      		 <span class=" media-object pull-left icon icon-bars" style="color:#090;"></span>
             <div class="media-body">
        		产品详情说明书
      		</div>
    		</a>
        </li>
        <div class="card" style="margin-left:20px; display:none; font-size:14px" id="deriction">
  			<ul class="table-view" >
    			<li class="table-view-divider row_text">名称</li>
    			<li class="table-view-divider"><s:property value="prod.prod_name"/></li>
    			<li class="table-view-divider row_text">规格</li>
    			<li class="table-view-divider"><s:property value="prod.prod_format"/></li>
    			<li class="table-view-divider row_text">主要成分</li>
                <li class="table-view-divider"><s:property value="prod.prod_chengfen"/></li>
    			
                <li class="table-view-divider row_text">主治功能</li>
    			<li class="table-view-divider"><s:property value="prod.prod_function"/></li>
    			<li class="table-view-divider row_text">用法用量</li>
    			<li class="table-view-divider"><s:property value="prod.prod_usage"/></li>
    			<li class="table-view-divider row_text">存储条件</li>
                <li class="table-view-divider"><s:property value="prod.prod_storage"/></li>
    			<li class="table-view-divider row_text">包装</li>
    			<li class="table-view-divider"><s:property value="prod.prod_pack"/></li>
                <li class="table-view-divider row_text">不良反应</li>
    			<li class="table-view-divider"><s:property value="prod.prod_bad"/></li>
    			<li class="table-view-divider row_text">批准文号</li>
    			<li class="table-view-divider"><s:property value="prod.prod_certno"/></li>
    			<li class="table-view-divider row_text">生产企业</li>
                <li class="table-view-divider"><s:property value="prod_chandi"/></li>
    			<li class="table-view-divider row_text">有效期</li>
    			<li class="table-view-divider"><s:property value="prod.prod_keepdate"/></li>
  			</ul>
		</div>
        <li class="table-view-cell media">
    		<a class="navigate-right" onClick="Go();">
      		<span class="media-object pull-left icon icon-pages" style="color:#090"></span>
      		<div class="media-body">
            	评论
            	<input type="hidden" id = "gid" value="<s:property value="prodid"/>" />
      		</div>
            <span class="badge" style="color:#C00"><s:property value="allvalue"/></span>
   			</a>
  		</li>
        <li class="table-view-cell media">
        	
            	<span class="media-object pull-left icon icon-person" style="color:#090"></span>
                <div class="media-body">
                	联系客服 &nbsp;&nbsp;<a href="tel:023-62919872">023-62919872</a>
                </div>
           
        </li>
       </ul>
      
    </div>
<script type="text/javascript">

</script>
  </body>
</html>