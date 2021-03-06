<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <title>API-TESTER</title>
        <script type="text/javascript" src="js/jquery-1.5.1.js"></script>
        <script type="text/javascript" src="js/json_beauty.js"></script>
        <script type="text/javascript" src="js/sjs-loader.js"></script>
        <script type="text/javascript" src="js/api.js"></script>
        <style type="text/css">
        input, select {
        	font-size: 12px;
        	color: #000;
        	border: 1px solid #bababa;
        	margin: 0;
        }
        </style>
    </head>
    <body style="font-family: 'Courier New';">
        <div id="command">
            <label for="cmd">API接口</label>
            <select name="cmd" id="cmd" onchange="displayCommand()">
                <option>------- 初始化接口-------</option>
            </select>
            <label id="chooseBoxLabel" for="chooseBox">选中测试<input type="checkbox" id="chooseBox" name="chooseBox"></label>
            <input id="testTime" type="text" style="width: 30px; height: 15px; font-family: 'Courier New';" value="1">
            <input type="button" onclick="execute()" value="单项测试">
            <input type="button" id="autoTest" name="autoTest" value="自动化测试" onclick="autoTest()">
            <label id="detailResult"></label>
            <label id="resultNo"></label>
            <label id="stopLabel" style="float: right; margin-right: 13px;">
                <input type="button" id="autoTest" name="autoTest" value="停止检测" onclick="stopTest()">
            </label>
            <label id="msgLabel" style="float: right; margin-right: 10px;">
                <input type="button" onclick="format_input()" value="格式化代码">
            </label>
        </div>
        <hr>
        <div id="in" style="width: 410px; height: 530px; float: left">
            <textarea id="request" style="width: 400px; height: 530px; font-family: 'Courier New';"> </textarea>
        </div>
        <div id="out" style="width: 835px; height: 530px; float: left">
            <textarea id="response" style="width: 835px; height: 530px; font-family: 'Courier New';" readonly> </textarea>
        </div>
        <br>
        <div id="error_window" style="width: 1230px; height: 50px; margin-top: 523px">
            <textarea id="console" style="width: 1245px; height: 60px" readonly></textarea>
        </div>
    </body>
</html>