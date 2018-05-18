<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<title>何不管库</title>
	<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
	<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
	<link rel="stylesheet" type="text/css" href="css/bootsnav.css">
	<link rel="stylesheet" type="text/css" href="gywcss/home.css">
	
	<link rel="stylesheet" type="text/css" href="jqeasyui/themes/gray/easyui.css">
	<script type="text/javascript" src="jqeasyui/jquery.min.js"></script>
    <script type="text/javascript" src="jqeasyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jqeasyui/easyui-lang-zh_CN.js"></script>	
	<script type="text/javascript" src="system/easyui_functions.js"></script>
	
	
</head>
<body>

<div id="main">
<div id="daohanglan" class="jq22-container">
	<header class="jq22-header">
		<h1>&nbsp何不管库</h1>
	</header>
<div class="demo" style="padding: 1em 0;height:100px">

<nav class="navbar navbar-default navbar-mobile bootsnav">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
            <i class="fa fa-bars"></i>
        </button>
    </div>
    <div class="collapse navbar-collapse" id="navbar-menu">
        <ul class="nav navbar-nav" data-in="fadeInDown" data-out="fadeOutUp">
            <li><a href="home.jsp">主页</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">管理&nbsp</a>
                <ul class="dropdown-menu">
                    <li><a href="storehouse.jsp" id="storehouse">仓库</a></li>
                    <li><a href="product.jsp">商品</a></li>
                    <li><a href="category.jsp">分类</a></li>
                    <li><a href="brand.jsp">品牌</a></li>
                    <li><a href="feature.jsp">规格</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" >备用</a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Custom Menu</a></li>
                            <li><a href="#">Custom Menu</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" >Sub Menu</a>
                                <ul class="dropdown-menu multi-dropdown">
                                    <li><a href="http://www.jq22.com">Custom Menu</a></li>
                                    <li><a href="#">Custom Menu</a></li>
                                    <li><a href="#">Custom Menu</a></li>
                                    <li><a href="#">Custom Menu</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>

                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">进货&nbsp</a>
                <ul class="dropdown-menu">
                    <li><a href="purchaselog.jsp">进货记录</a></li>
                    <li><a href="supplier.jsp">供应商</a></li>                 
                    <li><a href="purchaseorder.jsp">填写进货单</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">销售&nbsp</a>
                <ul class="dropdown-menu">
                    <li><a href="saleslog.jsp">销售记录</a></li>
                    <li><a href="buyer.jsp">顾客</a></li>                 
                    <li><a href="salesorder.jsp">填写售货单</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">库存&nbsp</a>
                <ul class="dropdown-menu">
                    <li><a href="situation.jsp">库存状况</a></li>
                    <li><a href="flow.jsp">库存流水</a></li>                 
                    <li><a href="transferorder.jsp">调拨</a></li>
                </ul>
            </li>
            <li><a href="#" id="contact">Contact Us</a></li>
        </ul>
    </div>
</nav>

</div>
</div>

<div id="realman" style="fit:auto;">
	<a href="#" id="insert" style="float:right;margin-right:30px" class="btn3" onclick="insertsh()">新增</a>
		<div class="easyui-window" id="mywin" style="height:435px;width:390px" title="新增顾客">
	<form id="insert" action="postBuyer" onsubmit="return check1()" method="post">
		<div style="position:absolute;top:57px;left:34px">顾客编码：</div>
		<div style="position:absolute;top:55px;left:120px"> <input id="buyerid" name="buyerid" type="text" class="easyui-textbox"/></div>
		<div style="position:absolute;top:102px;left:62px">公司名:</div>
		<div style="position:absolute;top:100px;left:120px" > <input id="companyname" name="companyname" class="easyui-textbox"/></div>
		<div style="position:absolute;top:147px;left:50px">联系人1:</div>
		<div style="position:absolute;top:145px;left:120px" > <input id="linkman1" name="linkman1" style="width:178px" class="easyui-textbox"/></div>
		<div style="position:absolute;top:192px;left:66px">电话1:</div>
		<div style="position:absolute;top:190px;left:120px" > <input id="tele1" name="tele1" style="width:178px" class="easyui-textbox"/></div>
		<div style="position:absolute;top:237px;left:50px">联系人2:</div>
		<div style="position:absolute;top:235px;left:120px" > <input id="linkman2" name="linkman2" style="width:178px" class="easyui-textbox"/></div>
		<div style="position:absolute;top:282px;left:66px">电话2:</div>
		<div style="position:absolute;top:280px;left:120px" > <input id="tele2" name="tele2" style="width:178px" class="easyui-textbox"/></div>
		<div style="position:absolute;top:327px;left:69px">微信:</div>
		<div style="position:absolute;top:325px;left:120px" > <input id="wechat" name="wechat" style="width:178px" class="easyui-textbox"/></div>	
		<div style="position:absolute;top:380px;left:120px"><input class="easyui-linkbutton" style="width:60px;height:25px" type="reset" value="重置"/></div>
		<div style="position:absolute;top:380px;left:200px"><input class="easyui-linkbutton" style="width:60px;height:25px" type="submit" value="提交"></div>		 
	</form>
	</div>
	<div class="easyui-window" id="mywin2" style="height:435px;width:390px" title="修改顾客">
	<form id="edit">
				<div style="position:absolute;top:57px;left:34px">顾客编码：</div>
		<div style="position:absolute;top:55px;left:120px"> <input id="buyerid2" name="buyerid2" type="text" class="easyui-textbox"/></div>
		<div style="position:absolute;top:102px;left:62px">公司名:</div>
		<div style="position:absolute;top:100px;left:120px" > <input id="companyname2" name="companyname2" class="easyui-textbox"/></div>
		<div style="position:absolute;top:147px;left:50px">联系人1:</div>
		<div style="position:absolute;top:145px;left:120px" > <input id="linkman12" name="linkman12" style="width:178px" class="easyui-textbox"/></div>
		<div style="position:absolute;top:192px;left:66px">电话1:</div>
		<div style="position:absolute;top:190px;left:120px" > <input id="tele12" name="tele12" style="width:178px" class="easyui-textbox"/></div>
		<div style="position:absolute;top:237px;left:50px">联系人2:</div>
		<div style="position:absolute;top:235px;left:120px" > <input id="linkman22" name="linkman22" style="width:178px" class="easyui-textbox"/></div>
		<div style="position:absolute;top:282px;left:66px">电话2:</div>
		<div style="position:absolute;top:280px;left:120px" > <input id="tele22" name="tele22" style="width:178px" class="easyui-textbox"/></div>
		<div style="position:absolute;top:327px;left:69px">微信:</div>
		<div style="position:absolute;top:325px;left:120px" > <input id="wechat2" name="wechat2" style="width:178px" class="easyui-textbox"/></div>
		<div style="position:absolute;top:380px;left:120px"><input class="easyui-linkbutton" style="width:60px;height:25px" type="reset" value="重置"/></div>
		<div style="position:absolute;top:380px;left:200px"><input class="easyui-linkbutton" style="width:60px;height:25px" value="提交" onclick="editdo()"></div>		 
	</form>
	</div>


</div>
</div>

<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script type="text/javascript" src="js/bootsnav.js"></script>


<script>
$(document).ready(function(){
	$.ajax({
		url:'getBuyer',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			var str="<input class='eayui-datagrid' id='mydatagrid' style='width:900px;height:500px'/>";
			$("#realman").append($(str));
			$("#mydatagrid").datagrid({
				title: '&nbsp;顾客列表',
				iconCls: "panelIcon",
				width:1500, 
				height:450,
				data:data,
				nowrap: true,
				autoRowHeight: true,
				rownumbers: true,
				striped: true,  //条纹化
				collapsible: true,
				singleSelect: true, 
				sortName: 'volume',
				sortOrder: 'desc',
				remoteSort: false,
				columns:[[
							{ title: '公司名', field: 'companyname', width: 170, halign:'center', align: 'center'},
							{ title: '联系人1', field:'linkman1', width: 140, halign:'center', align: 'center'},
							{ title: '电话1', field:'tele1', width: 140, halign:'center', align: 'center'},	
							{ title: '联系人2', field:'linkman2', width: 140, halign:'center', align: 'center'},
							{ title: '电话2', field:'tele2', width: 140, halign:'center', align: 'center'},
							{ title: '微信', field:'wechat', width: 130, halign:'center', align: 'center'},
							{ title: '交易次数', field:'volume', width: 115, halign:'center', align: 'center',sortable:true},
							{ title: '平均利润百分率', field:'app', width: 115, halign:'center', align: 'center'},
							{ title: '最近利润百分率', field:'lpp', width: 115, halign:'center', align: 'center'},
							
							{ title: '操作', field:'operate', width: 210, halign:'center', align: 'center',formatter:operate}
							]],
				frozenColumns: [[{ title:'供应商编号',field: 'buyerid', width:165,align: 'center'}]]

			})		
		}
		})//---------ajax结束
		$("#mywin").window('close');
		$("#mywin2").window('close');
})
function operate(val,row,index){  
    return '<a href="#" class="btn2" onclick="editsh('+index+')">修改</a>'+'<label style="width:30px"/>'+'<a href="#" class="btn2" onclick="deletesh('+index+')">删除</a>';
} 
function check1(){
	var err='';
	var buyerid=$("#buyerid").textbox("getValue").trim();
	if(buyerid==''){err+='供应商编号不能为空<br>'};
	//---检验重复
	aa=$("#mydatagrid").datagrid("getRows");
	for(i=0;i<=aa.length-1;i++){
		if(buyerid==aa[i].buyerid.trim()){
			err+='供应商编号不能重复！<br>';
			break;
		}
	}
	if($("#companyname").textbox("getValue").trim()==''){err+='公司名不能为空<br>'};
	if($("#linkman1").textbox("getValue").trim()==''){err+='联系人1不能为空<br>'};
	if($("#tele1").textbox("getValue").trim()==''){err+='电话1不能为空<br>'};
	if($("#wechat").textbox("getValue").trim()==''){err+='微信不能为空<br>'};
	
	if(err!=''){
		$.messager.alert('系统提示',err);
		return false;
	}else return true;
}
function editsh(index){  
	//------------------------别忘记form 只有get和post
		$("#mydatagrid").datagrid("selectRow",index)
		aa=$("#mydatagrid").datagrid("getSelected");
		$("#buyerid2").textbox("setValue",aa.buyerid.trim());
		$("#buyerid2").textbox({readonly:true});
		$("#companyname2").textbox("setValue",aa.companyname.trim());
		$("#linkman12").textbox("setValue",aa.linkman1.trim());
		$("#tele12").textbox("setValue",aa.tele1.trim());
		$("#linkman22").textbox("setValue",aa.linkman2.trim());
		$("#tele22").textbox("setValue",aa.tele2.trim());
		$("#wechat2").textbox("setValue",aa.wechat.trim());	
		$("#mywin2").window('open');
		
	}  

function editdo(){
	var flag=1;
	var err='';
	if($("#companyname2").textbox("getValue").trim()==''){err+='公司名不能为空<br>'};
	if($("#linkman12").textbox("getValue").trim()==''){err+='联系人不能为空<br>'};
	if($("#tele12").textbox("getValue").trim()==''){err+='电话1不能为空<br>'};
	if($("#wechat2").textbox("getValue").trim()==''){err+='微信不能为空<br>'};
	if(err!=''){
		$.messager.alert('系统提示',err);
	}else flag=2;
	if(flag==2){
		var url='editBuyer?buyerid='+$("#buyerid2").textbox("getValue")+'&companyname='+$("#companyname2").textbox("getValue");
		url+='&linkman1='+$("#linkman12").textbox("getValue")+'&tele1='+$("#tele12").textbox("getValue")+'&linkman2='+$("#linkman22").textbox("getValue");
		url+='&tele2='+$("#tele22").textbox("getValue")+'&wechat='+$("#wechat2").textbox("getValue");
		url=encodeURI(url); 
		url=encodeURI(url); //二次次编码解决url传递中文
		$.ajax({
			url:url,
			method:'edit',
			async:false,
			success:function(){
				
			}
		})
		window.location.reload();
	}
}




function deletesh(index){  
	if(window.confirm("确定删除？")){
		$("#mydatagrid").datagrid("selectRow",index)
		var aa=$("#mydatagrid").datagrid("getSelected");
		alert("删除成功");
		var url='deleteBuyer?buyerid='+aa.buyerid;
		$.ajax({
			url:url,
			method:'delete',
			async:false,
			success:function(){}
		})
		window.location.reload();
	}

}
function insertsh(){
	
	$("#mywin").window('open');
}






</script>
</body>
</html>