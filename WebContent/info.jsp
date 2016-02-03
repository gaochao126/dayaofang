<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title></title>
    <script src="js/mui.min.js"></script>
    <link href="css/mui.min.css" rel="stylesheet"/>
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript" charset="utf-8">
      	mui.init();
		var browser = {
			versions: function() {
			var u = navigator.userAgent, app = navigator.appVersion;
				return {//移动终端浏览器版本信息 
				mobile: !!u.match(/AppleWebKit.*Mobile.*/) || !!u.match(/AppleWebKit/), //是否为移动终端
				ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
				android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
				iPhone: u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, //是否为iPhone或者QQHD浏览器
				iPad: u.indexOf('iPad') > -1, //是否iPad
				webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
				};
			}(),
			language: (navigator.browserLanguage || navigator.language).toLowerCase()
		}
	//判断终端为android时，传递规格参数
	//	alert(" android终端: " + browser.versions.android);
	function showHtmlcallJava2(obj){
		if(browser.versions.android==true){
			var str = window.jsObj.HtmlcallJava(obj); 
			var price = document.getElementById(obj).value;

			$(document).ready(function(){
    			var format =  $("input[name="+obj+"]").val();
    			$("#trueformat").html("");
				$("#trueformat").html(format);
    		})
			var zhekou = document.getElementById("nihid").value;
			var newprice = zhekou * price;
			$("#newprice").html(newprice);
			$("#oldprice").html(price);
		}
		//判断终端为IOS时，传递规格参数
		else if(browser.versions.ios==true){
			var str = ABC.HtmlcallJava(obj);
			var price = document.getElementById(obj).value;
			$(document).ready(function(){
				var format =  $("input[name="+obj+"]").val();
				$("#trueformat").html("");
				$("#trueformat").html(format);
    		})
			var zhekou = document.getElementById("nihid").value;
			var newprice = zhekou * price;
			$("#newprice").html(newprice);
			$("#oldprice").html(price);
		}
	}
	function get(obj){
	
			var price = document.getElementById(obj).value;

			$(document).ready(function(){
    		var format = $("[name="+obj+"]").val();
    		document.getElementById("trueformat").innerHTML=format;	
    		})
		
			var zhekou = document.getElementById("nihid").value;
				
			var newprice = zhekou * price;

			$("#newprice").html(newprice);
			$("#oldprice").html(price);
	}



    </script>
    <script>
  
    	/*$(document).ready(function(){
    	alert("dsalkfjas");
    		$("[name='li_spe']").click(function(){
    		//
    			var test=$("[name='span_spe']").val();
    			alert(test);
    			
    		});
    	})*/
    	
   	function getAttr(obj){	
	
   		alert(obj);
   		return obj;
    }
    
    
    	
    </script>
	<style>
    	.li_style{margin-left: -14px; padding-left:27px; font-size: 14px;}
    	.tab_style{width: 100%;border: solid thin #CCCCCC; color: #999999;}
    	.tr_style{background-color: #DFF0D8; }
    	.td1_style{border-right: solid thin #CCCCCC;width: 20%; padding-left: 5px; padding-top: 2px; padding-bottom: 2px;}
    	.td2_style{width: 80%; padding-left: 5px; padding-top: 2px; padding-bottom: 2px;}
    	.mui-segmented-control .mui-control-item{
    		color: #008A3A;
  			border-color: #008A3A;
  			border-left: 1px solid #008A3A;
    	}
    	.mui-segmented-control .mui-control-item.mui-active {
 			 color: #fff;
  			 background-color:#008A3A;
		}
		.spe_price{
			color: #FF0000; font-size: 24px; font-weight: 600;margin-top: 30px; 
		}
		.spe_img{
			width: 80px; height: 80px;
		}
		.spe_detail_unch{
			float: left;margin-top: 5px; margin-bottom: 10px;height: 35px; padding-top: 5px; padding-bottom: 5px;
		}
		.spe_detail_ch{
			float: left;margin-top: 5px; margin-bottom: 10px;height: 35px; padding-top: 5px; padding-bottom: 5px;
			background-color: #EFEFF1;
		}
		
    </style>
</head>
<body>
	<div class="mui-content">
		<div id="slider" class="mui-slider" style="background-color:#FCECD2; text-align: center;">
				<div class="mui-slider-group mui-slider-loop">
					<s:iterator value="dataObj.detail.img">
						<div class="mui-slider-item">
							<img style="height: 200px;" src="<s:property value="img_src"/>" />
						</div>
					</s:iterator>
				</div>
				<div class="mui-slider-indicator">
				<%-- <s:iterator value="img" status="v">
					<s:if test="v.index == 0">
						<div class="mui-indicator mui-active"></div>
					</s:if>
					<s:else>
						<div class="mui-indicator"></div>
					</s:else>
				</s:iterator> --%>
				</div>
				
		</div>
		<div class="mui-content" style="margin-top: -10px;">
		<ul class="mui-table-view">
				
                <li id="1stli" class="mui-table-view-cell li_style">
                	<!-- 现价 -->
					<span id="newprice" style="color: #FF0000;font-size: 16px;">￥<fmt:formatNumber value="${dataObj.detail.prod.prod_discount*dataObj.detail.prod.prod_price}" pattern="#0.00"/></span><br>
					<!-- 原价 -->
					<span id="oldprice"  style="color:#999999; text-decoration: line-through;margin-right: 15px;">￥<fmt:formatNumber value="${dataObj.detail.prod.prod_price}" pattern="#0.00"/></span>
				</li>
                
                <input id="nihid" type="hidden" name="discount" value="<s:property value="dataObj.detail.prod.prod_discount"/>" />
                
				<li class="mui-table-view-cell li_style">
				<span style="font-size: 16px; font-weight: bold;"><s:property value="dataObj.detail.prod.prod_name"/></span><br>
				<span  style="color: #999999;">规格 ：<span id="trueformat"><s:property value="dataObj.detail.prod.prod_format"/></span></span><br>
				<span style="color: #999999;">厂家 ：<s:property value="dataObj.detail.prod.prod_chandi"/></span>
				</li>
                
				<li class="mui-table-view-cell li_style">
				<a href="#picture" style="font-size: 16px;" id="choose_spe">
					<i class="mui-icon mui-icon-paperplane mui-pull-left" style="font-size: 20px; margin-left: -10px; margin-right: 5px; color: #008A3A;"></i>
					选择规格</a>
				</li>
				<li class="mui-table-view-cell mui-collapse li_style">
					<a class="mui-navigate-right" href="#" style="font-size: 16px;">
						<i class="mui-icon mui-icon-bars mui-pull-left" style="font-size: 18px; margin-left: -10px; margin-right: 5px; color: #008A3A;"></i>
						产品详情说明书
					</a>
					<div class="mui-collapse-content">
						<table class="tab_style">
							<tr class="tr_style">
								<td class="td1_style">名称</td>
								<td class="td2_style"><s:property value="dataObj.detail.prod.prod_name"/></td>
							</tr>
							<tr>
								<td class="td1_style">规格</td>
								<td class="td2_style"><s:property value="dataObj.detail.prod.prod_format"/></td>
							</tr>
							<tr class="tr_style">
								<td class="td1_style">主要成分</td>
								<td class="td2_style"><s:property value="dataObj.detail.prod.prod_chengfen"/></td>
							</tr>
							<tr>
								<td class="td1_style">主治功能</td>
								<td class="td2_style"><s:property value="dataObj.detail.prod.prod_function"/></td>
							</tr>
							<tr class="tr_style">
								<td class="td1_style">用法用量</td>
								<td class="td2_style"><s:property value="dataObj.detail.prod.prod_usage"/></td>
							</tr>
							<tr>
								<td class="td1_style">存储条件</td>
								<td class="td2_style"><s:property value="dataObj.detail.prod.prod_storage"/></td>
							</tr>
							<tr class="tr_style">
								<td class="td1_style">包装</td>
								<td class="td2_style"><s:property value="dataObj.detail.prod.prod_pack"/></td>
							</tr>
							<tr>
								<td class="td1_style">不良反应</td>
								<td class="td2_style"><s:property value="dataObj.detail.prod.prod_bad"/></td>
							</tr>
							<tr class="tr_style">
								<td class="td1_style">批准文号</td>
								<td class="td2_style"><s:property value="dataObj.detail.prod.prod_certno"/></td>
							</tr>
							<tr>
								<td class="td1_style">生产企业</td>
								<td class="td2_style"><s:property value="dataObj.detail.prod_chandi"/></td>
							</tr>
							<tr class="tr_style">
								<td class="td1_style">有效期</td>
								<td class="td2_style"><s:property value="dataObj.detail.prod.prod_keepdate"/></td>
							</tr>
						</table>
						
					</div>
				</li>
				<li class="mui-table-view-cell mui-collapse li_style">
					<a class="mui-navigate-right" href="#" style="font-size: 16px;">
							<i class="mui-icon mui-icon-chat mui-pull-left" style="font-size: 18px; margin-left: -10px; margin-right: 5px; color: #008A3A;"></i>
							评论
					</a>
					<div class="mui-collapse-content">
						<div id="segmentedControl" class="mui-segmented-control" style="border: solid thin #008A3A;">
							<a class="mui-control-item mui-active" href="#all">
								全部(<s:property value="dataObj.detail.allvalue"/>)
							</a>
							<a class="mui-control-item" href="#nice">
								好评(<s:property value="dataObj.detail.goodvalue"/>)
							</a>
							<a class="mui-control-item" href="#medium">
								中评(<s:property value="dataObj.detail.medilvalue"/>)
							</a>
							<a class="mui-control-item" href="#bad">
								差评(<s:property value="dataObj.detail.badvalue"/>)
							</a>
						</div>
						<div class="mui-content-padded">
							<div id="all" class="mui-control-content mui-active">
								<ul class="mui-table-view" style="margin-top: -10px;">
								<s:iterator value="dataObj.detail.allDiscuss">
									<li class="mui-table-view-cell" style="margin-left: -20px;">
										<span>评分：<s:property value="prod_score"/></span>
										<span style="color: #FFFF00;">
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star"></span>
										</span><br>
										<span><s:property value="dis_mess"/></span><br>
										<span style="color: #999999; font-size: 14px;">
											<span><s:property value="dis_name"/></span>
											<span class="mui-pull-right"><s:property value="dis_time"/></span>
										</span>
									</li>
								</s:iterator>
								</ul>
							</div>
							
							<div id="nice" class="mui-control-content">
							<ul class="mui-table-view">
							<s:iterator value="dataObj.detail.goodDiscuss">
								<li class="mui-table-view-cell" style="margin-left: -20px;">
										<span>评分：<s:property value="prod_score"/></span>
										<span style="color: #FFFF00;">
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star"></span>
										</span><br>
										<span><s:property value="dis_mess"/></span><br>
										<span style="color: #999999; font-size: 14px;">
											<span><s:property value="dis_name"/></span>
											<span class="mui-pull-right"><s:property value="dis_time"/></span>
										</span>
								</li>
							</s:iterator>
							</ul>
							</div>
							
							<div id="medium" class="mui-control-content">
							<ul class="mui-table-view">
							 <s:iterator value="dataObj.detail.midelDiscuss">
								<li class="mui-table-view-cell" style="margin-left: -20px;">
										<span>评分：<s:property value="prod_score"/></span>
										<span style="color: #FFFF00;">
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star"></span>
										</span><br>
										<span><s:property value="dis_mess"/></span><br>
										<span style="color: #999999; font-size: 14px;">
											<span><s:property value="dis_name"/></span>
											<span class="mui-pull-right"><s:property value="dis_time"/></span>
										</span>
								</li>
								</s:iterator>
							</ul>
							</div>
							
							<div id="bad" class="mui-control-content">
								<ul class="mui-table-view">
									<s:iterator value="dataObj.detail.badDiscuss">
										<li class="mui-table-view-cell" style="margin-left: -20px;">
										<span>评分：<s:property value="prod_score"/></span>
										<span style="color: #FFFF00;">
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star-filled"></span>
											<span class="mui-icon mui-icon-star"></span>
										</span><br>
										<span><s:property value="dis_mess"/></span><br>
										<span style="color: #999999; font-size: 14px;">
											<span><s:property value="dis_name"/></span>
											<span class="mui-pull-right"><s:property value="dis_time"/></span>
										</span>
								</li >
								</s:iterator>
								</ul>
							</div>
						</div>
					</div>
				</li>
				<li class="mui-table-view-cell li_style">
					<a href="tel:023-62919872" style="font-size: 16px;">
						<i style="font-size: 20px; margin-left: -10px; margin-right: 5px; color: #008A3A;" class="mui-icon mui-icon-phone mui-pull-left"></i>
						联系客服：023-62919872
					</a>
					
				</li>
			</ul>
			<!-- 选择规格弹出层 -->
			<div id="picture" class="mui-popover mui-popover-action mui-popover-bottom">
				<ul class="mui-table-view" style="background-color: #FFFFFF;" id="ul_spe">
					<s:iterator value="dataObj.detail.formats">
						<li class="mui-radio mui-right mui-col-xs-12 spe_detail_unch" name="li_spe"  style="background-color:#DDD; margin-top:2px;"  >
						<span id = "spanP" name="span_spe1" style="display:block; width:100%; height:100%;" onclick='showHtmlcallJava2(<s:property value="format_id"/>+"")'> ￥  <s:property value="prod_price"/>&nbsp;&nbsp;<s:property value="prod_format"/> </span>
						<input id="<s:property value="format_id"/>" type="hidden" name="price" value="<s:property value="prod_price"/>" />
						<input type="hidden" name="<s:property value="format_id"/>" value="<s:property value="prod_format"/>" />
						</li>
					</s:iterator>
				</ul>
				<ul class="mui-table-view">
					<li class="mui-table-view-cell">
						<a href="#picture" style="color:#FFF; font-size:18px; background-color:#3C844B"><b>确定</b></a>
					</li>
				</ul>
			</div>
	</div>
	<!--
    	作者：1016818475@qq.com
    	时间：2015-02-26
    	描述：控制轮播时间为5秒
    -->
	<script type="text/javascript">
    	var slider=mui("#slider");
    	slider.slider({
    		interval:5000
    	});
    </script>
    <script type="text/javascript">
            //该方法主要的思路是通过修改对应节点的样式修改背景颜色
            function change_bg(){
                var items=document.getElementById("ul_spe").childNodes;//获取li节点
                for(var i=0;i<items.length;i++){//循环每个li节点
                    if(items[i].nodeName=="LI"){//如果子节点是LI标签的话
                        items[i].onclick=function(){//绑定click事件
                            var all_li=this.parentNode.childNodes;//获取所有li节点
                            for(var j=0;j<all_li.length;j++){
                                all_li[j].className="mui-radio mui-right mui-col-xs-12 spe_detail_unch";//将所有的li节点的背景还原
                            }
                            this.className="mui-radio mui-right mui-col-xs-12 spe_detail_ch";//将当前的li节点的背景设为对应的背景
                        }
                    }
                }
            }
            change_bg();
        </script>
</body>
</html>