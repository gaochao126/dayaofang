<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href="http://cdn.bootcss.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  <link href="http://static.bootcss.com/www/assets/css/site.min.css?v3" rel="stylesheet">
<title>无标题文档</title>
</head>
<style>
.p_style{
	
	padding-top:5px;
	border-top:#CCC solid thin;
	margin-top:25px}
.score1{
	color:#FDC502;
	font-size:16px;
	}
.score2{
	color:#000; font-size:14px;
	}
.user_time{
	color:#999;
	}
</style>
<body>
<div class="navbar-fixed-top">
<div class="row" style="background-color:#008A3A; color:#FFF; padding-left:15px;">
	<p class="text-center" style="font-size:16px; margin-bottom:-1px; padding-top:7px; padding-bottom:2px">
	<span class="pull-left"><span class="glyphicon glyphicon glyphicon-chevron-left" style="font-size:16px;"></span>
    	<a href="toproducts!toInformation?gid=<s:property value="prodid"/>" style="color:#FFF">&nbsp;返回</a>
    </span><label style="margin-left:-50px; font-size:18px;">商品评论</label>
    </p>
</div>
	
</div>
<div class="product-tabs">
        <ul id="myTab" class="nav nav-tabs">
			<li class="active" style="width:25%;"><a href="#all_comment" style="font-weight:bold; text-align:center;" data-toggle="tab">全部评价(<s:property value="allvalue"/>)</a></li>
			<li class="" style="width:25%;"><a href="#good" style="font-weight:bold; text-align:center;" data-toggle="tab">好评(<s:property value="goodvalue"/>)</a></li>
			<li class="" style="width:25%;"><a href="#ordinary" style="font-weight:bold;  text-align:center;" data-toggle="tab">中评(<s:property value="medilvalue"/>)</a></li>
            <li class="" style="width:25%;"><a href="#bad" style="font-weight:bold; text-align:center;" data-toggle="tab">差评(<s:property value="badvalue"/>)</a></li>
		</ul>
        <div id="myTabContent" class="tab-content" style="padding-left:5px; padding-right:5px;">
        
			<div class="tab-pane active" id="all_comment">
            	<s:iterator value="allDiscuss">
            	<p style="padding-top:5px">
            		<span class="score1">
                    	<span class="score2">评分：<s:property value="prod_scroe"/></span>
                    	<span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </span><br>
                	<span><s:property value="dis_mess"/></span><br>
                	<span class="user_time"><span class="pull-left"><s:property value="customer.user_username"/></span><span class="pull-right" style="margin-right:5px"><s:property value="dis_time"/></span></span>
                </p>
			   </s:iterator>
            </div><!--全部评价-->
            
            <s:iterator value="goodDiscuss">
			<div class="tab-pane comment_detail" id="good">
          		<p style="padding-top:5px">
            		<span class="score1">
                    	<span class="score2">评分：<s:property value="prod_scroe"/></span>
                    	<span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </span><br>
                	<span><s:property value="dis_mess"/></span><br>
                	<span class="user_time"><span class="pull-left"><s:property value="customer.user_username"/></span><span class="pull-right" style="margin-right:5px"><s:property value="dis_time"/></span></span>
                </p>
               
            </div><!--好评-->
           </s:iterator>
           
          
            <div class="tab-pane comment_detail" id="ordinary">
             <s:iterator value="midelDiscuss">
          		<p style="padding-top:5px">
            		<span class="score1">
                    	<span class="score2">评分：<s:property value="prod_scroe"/></span>
                    	<span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </span><br>
                	<span><s:property value="dis_mess"/></span><br>
                	<span class="user_time"><span class="pull-left"><s:property value="customer.user_username"/></span><span class="pull-right" style="margin-right:5px"><s:property value="dis_time"/></span></span>
                </p>
              </s:iterator>
            </div><!--中评-->
            
            <div class="tab-pane comment_detail" id="bad">
            	<s:iterator value="badDiscuss">
            	<p style="padding-top:5px">
            		<span class="score1">
                    	<span class="score2">评分：<s:property value="prod_scroe"/></span>
                    	<span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </span><br>
                	<span><s:property value="dis_mess"/></span><br>
                	<span class="user_time"><span class="pull-left"><s:property value="customer.user_username"/></span><span class="pull-right" style="margin-right:5px"><s:property value="dis_time"/></span></span>
                </p>   
               </s:iterator>         
            </div>
            <!--差评-->
		</div>
    </div>
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/unveil/1.3.0/jquery.unveil.min.js"></script>
<script src="http://cdn.bootcss.com/scrollup/2.4.0/jquery.scrollUp.min.js"></script>
<script src="http://cdn.bootcss.com/toc/0.3.2/toc.min.js"></script>
<script src="http://static.bootcss.com/www/assets/js/site.min.js"></script>
<script src="http://cdn.bootcss.com/holder/2.4.1/holder.js"></script>
</body>
</html>
