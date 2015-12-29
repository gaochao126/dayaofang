
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title></title>
    <script src="js/mui.min.js"></script>
    <link href="css/mui.min.css" rel="stylesheet"/>
    <script type="text/javascript" charset="utf-8">
      	mui.init();
    </script>
    <style>
    	.li_style{margin-left: -14px; padding-left:27px; font-size: 14px;}
    	.tab_style{width: 100%;border: solid thin #CCCCCC; color: #999999;}
    	.tr_style{background-color: #DFF0D8; }
    	.td1_style{border-right: solid thin #CCCCCC;width: 30%; padding-left: 5px; padding-top: 2px; padding-bottom: 2px;}
    	.td2_style{width: 70%; padding-left: 5px; padding-top: 2px; padding-bottom: 2px;}
    	.mui-segmented-control .mui-control-item{
    		color: #008A3A;
  			border-color: #008A3A;
  			border-left: 1px solid #008A3A;
    	}
    	.mui-segmented-control .mui-control-item.mui-active {
 			 color: #fff;
  			 background-color:#008A3A;
		}
    </style>
</head>
<body>
	<div class="mui-content">
	<div id="slider" class="mui-slider">
			<div class="mui-slider-group mui-slider-loop">
				<div class="mui-slider-item">
					<img style="height: 200px;" src="images/<s:property value="prod.img.img1_src"/>" />
				</div>
				<div class="mui-slider-item">
					<img style="height: 200px;" src="images/<s:property value="prod.img.img1_src"/>" />
				</div>
				<div class="mui-slider-item">
					<img style="height: 200px;" src="images/<s:property value="prod.img.img1_src"/>" />
				</div>
				<div class="mui-slider-item">
					<img style="height: 200px;" src="images/<s:property value="prod.img.img1_src"/>" />
				</div>



				
			</div>
			<div class="mui-slider-indicator">
				<div class="mui-indicator "></div>
				<div class="mui-indicator "></div>
				
			</div>
			
	</div>
	<div class="mui-content" style="margin-top: -10px;">
		<ul class="mui-table-view">
				<li class="mui-table-view-cell li_style">
					<span style="color: #FF0000;font-size: 16px;">￥<fmt:formatNumber value="${prod.prod_discount*prod.formats.prod_price}" pattern="#0.00"/></span><br>
					<span style="color:#999999; text-decoration: line-through;margin-right: 15px;">￥<fmt:formatNumber value="${prod.formats.prod_price}" pattern="#0.00"/></span>
					节省了<span>￥<fmt:formatNumber value="${prod.formats.prod_price-prod.prod_discount*prod.formats.prod_price}" pattern="#0.00"/></span>
				</li>
				<li class="mui-table-view-cell li_style">
				<span style="font-size: 16px; font-weight: bold;"><s:property value="prod.prod_name"/></span><br>
				<span style="color: #999999;">规格 ：<span><s:property value="prod.prod_format"/></span></span><br>
				<span style="color: #999999;">厂家 ：<span><s:property value="prod_chandi"/></span></span>
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
								<td class="td2_style"><s:property value="prod.prod_name"/></td>
							</tr>
							<tr>
								<td class="td1_style">规格</td>
								<td class="td2_style"><s:property value="prod.prod_format"/></td>
							</tr>
							<tr class="tr_style">
								<td class="td1_style">主要成分</td>
								<td class="td2_style"><s:property value="prod.prod_chengfen"/></td>
							</tr>
							<tr>
								<td class="td1_style">主治功能</td>
								<td class="td2_style"><s:property value="prod.prod_function"/></td>
							</tr>
							<tr class="tr_style">
								<td class="td1_style">用法用量</td>
								<td class="td2_style"><s:property value="prod.prod_usage"/></td>
							</tr>
							<tr>
								<td class="td1_style">存储条件</td>
								<td class="td2_style"><s:property value="prod.prod_storage"/></td>
							</tr>
							<tr class="tr_style">
								<td class="td1_style">包装</td>
								<td class="td2_style"><s:property value="prod.prod_pack"/></td>
							</tr>
							<tr>
								<td class="td1_style">不良反应</td>
								<td class="td2_style"><s:property value="prod.prod_bad"/></td>
							</tr>
							<tr class="tr_style">
								<td class="td1_style">批准文号</td>
								<td class="td2_style"><s:property value="prod.prod_certno"/></td>
							</tr>
							<tr>
								<td class="td1_style">生产企业</td>
								<td class="td2_style"><s:property value="prod_chandi"/></td>
							</tr>
							<tr class="tr_style">
								<td class="td1_style">有效期</td>
								<td class="td2_style"><s:property value="prod.prod_keepdate"/></td>
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
								全部(<s:property value="allvalue"/>)
							</a>
							<a class="mui-control-item" href="#nice">
								好评(<s:property value="goodvalue"/>)
							</a>
							<a class="mui-control-item" href="#medium">
								中评(<s:property value="medilvalue"/>)
							</a>
							<a class="mui-control-item" href="#bad">
								差评(<s:property value="badvalue"/>)
							</a>
						</div>
						<div class="mui-content-padded">
							<div id="all" class="mui-control-content mui-active">
								<ul class="mui-table-view" style="margin-top: -10px;">
								<s:iterator value="allDiscuss">
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
							<s:iterator value="goodDiscuss">
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
							 <s:iterator value="midelDiscuss">
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
									<s:iterator value="badDiscuss">
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
					<s:iterator value="formats">
						<li class="mui-table-view-cell" style="margin-left: -20px;"> <s:property value="format.prod_format"/></li>			
					</s:iterator>
				</li>
				<li class="mui-table-view-cell li_style">
					<a href="tel:023-62919872" style="font-size: 16px;">
						<i style="font-size: 20px; margin-left: -10px; margin-right: 5px; color: #008A3A;" class="mui-icon mui-icon-phone mui-pull-left"></i>
						联系客服：023-62919872
					</a>
					
				</li>
			</ul>
	</div>
	<!--
    	作者：1016818475@qq.com
    	时间：2015-02-26
    	描述：控制轮播时间为5秒
    -->
	<script type="text/javascript">
    	var slider=mui("#slider");
    	slider.slider({
    		interval:4000
    	});
    </script>
</body>
</html>