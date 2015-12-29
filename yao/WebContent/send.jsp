<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>
<html>
<head>
	<title>宝易互通示例——商户发送</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body >
	<h1>宝易互通示例——商户发送</h1>
	<form name="ExampleForm" action="https://www.umbpay.com/pay2_1_/paymentImplAction.do" method="post">
	
	<input  name="merchantid"  type="text" value=<s:property value="merchantid"/>>
	<input  name="merorderid"  type="text" value=<s:property value="merorderid"/>>
	<input  name="amountsum"  type="text" value=<s:property value="amountsum"/>>
	<input  name="subject"  type="text" value=<s:property value="subject"/>>
	<input  name="currencytype"  type="text" value=<s:property value="currencytype"/>>
	<input  name="autojump"  type="text" value=<s:property value="autojump"/>>
	<input  name="waittime"  type="text" value=<s:property value="waittime"/>>
	<input  name="merurl"  type="text" value=<s:property value="merurl"/>>
	<input  name="informmer"  type="text" value=<s:property value="informmer"/>>
	<input  name="informurl"  type="text" value=<s:property value="informurl"/>>
	<input  name="confirm"  type="text" value=<s:property value="confirm"/>>
	<input  name="merbank"  type="text" value=<s:property value="merbank"/>>
	<input  name="tradetype"  type="text" value=<s:property value="tradetype"/>>
	<input  name="bankInput"  type="text" value=<s:property value="bankInput"/>>
	<input  name="interface"  type="text" value=<s:property value="strInterface"/>>
	<input  name="bankcardtype"  type="text" value=<s:property value="bankcardtype"/>>
	<input  name="pdtdetailurl"  type="text" value=<s:property value="pdtdetailurl"/>>
	<input  name="mac"  type="text" value=<s:property value="mac"/>>
	<input  name="remark"  type="text" value=<s:property value="remark"/>>
	<input  name="pdtdnm"  type="text" value=<s:property value="pdtdnm"/>>

	
	<!--<form action="recive_xml_mess_api" method="post">
	
	<input  name="merchantid"  type="text" value="1162"/>
	<input  name="merorderid"  type="text" value="123456"/>
	<input  name="amountsum"  type="text" value="0.1"/>
	<input  name="currencytype"  type="text" value="01"/>
	<input  name="subject"  type="text" value="1162000"/>
	<input  name="state"  type="text" value="1"/>
	<input  name="paybank"  type="text" value="ICBC"/>
	<input  name="banksendtime"  type="text" value="2015-04-29"/>
	<input  name="merrecvtime"  type="text" value="2015-04-29"/>
	<input  name="interface"  type="text" value="5.00"/>
	<input  name="mac"  type="text" value="vzvavdfbvsdvaqvrgngfsbvrn"/>
	
	
	<input name="submit" type="submit" value=" 到宝易互通支付 " >
	</form>
		
	--><!--</form>
	
--><!--<script type="text/javascript" language="javascript">

    function submitform()
    {
        document.ExampleForm.submit();
    }
    window.onload = submitform;
</script>
	
--></body>
</html>
