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
                    <li><a href="supplier.jsp">供货商</a></li>                 
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

<table border="2" style="width:95%;height:300px;margin-left:10px">
<tr><th colspan="7">调拨单</th></tr>
<tr id="tr3"><td>&nbsp&nbsp编号&nbsp&nbsp</td><td>&nbsp&nbsp商品&nbsp&nbsp</td><td>&nbsp商品名</td><td>现有数量</td><td>调出仓库</td><td>调入仓库</td><td>调拨数量</td></tr>
	<tr>
		<td></td><td></td><td></td><td></td><td></td><td></td><td></td>
	</tr>
</table>

</div>

<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script type="text/javascript" src="js/bootsnav.js"></script>


<script>
$(document).ready(function(){
	str="<div id='orderid_div'><input class='easyui-textbox' id='orderid' style='width:125px;height:28px'/></div>";
	$("#main").append($(str));
	$("#orderid").textbox({readonly:true});
	$("#orderid_div").css({
		position:"absolute",
		top:"390px",
		left:"45px",
		display:"inline"
	})
	str="<div id='productid_div'><input class='easyui-combobox' id='productid' style='width:125px;height:28px'/></div>";
	$("#main").append($(str));
	$("#productid").combobox();
	$("#productid_div").css({
		position:"absolute",
		top:"390px",
		left:"220px",
		display:"inline"
	})
	str="<div id='productname_div'><input class='easyui-textbox' id='productname' style='width:125px;height:28px'/></div>";
	$("#main").append($(str));
	$("#productname").textbox({readonly:true});
	$("#productname_div").css({
		position:"absolute",
		top:"390px",
		left:"400px",
		display:"inline"
	})
	str="<div id='nowq_div'><input class='easyui-numberbox' id='nowq' style='width:125px;height:28px'/></div>";
	$("#main").append($(str));
	$("#nowq").numberbox({readonly:true});
	$("#nowq_div").css({
		position:"absolute",
		top:"390px",
		left:"600px",
		display:"inline"
	})
	str="<div id='fromsh_div'><input class='easyui-combobox' id='fromsh' style='width:125px;height:28px'/></div>";
	$("#main").append($(str));
	$("#fromsh").combobox({editable:false});
	$("#fromsh_div").css({
		position:"absolute",
		top:"390px",
		left:"840px",
		display:"inline"
	})
	str="<div id='tosh_div'><input class='easyui-combobox' id='tosh' style='width:125px;height:28px'/></div>";
	$("#main").append($(str));
	$("#tosh").combobox({editable:false});
	$("#tosh_div").css({
		position:"absolute",
		top:"390px",
		left:"1080px",
		display:"inline"
	})

	str="<div id='quantity_div'><input class='easyui-numberbox' id='quantity' style='width:125px;height:28px'/></div>";
	str+='<a id="send" class="easyui-linkbutton" onclick="dosend()" style="position:relative;top:20px;left:1370px;height:33px;width:70px">提交</a>';
	$("#main").append($(str));
	$("#quantity").numberbox();
	$("#quantity_div").css({
		position:"absolute",
		top:"390px",
		left:"1300px",
		display:"inline"
	})

	$("#send").linkbutton();
	
	$.ajax({
		url:'getTransferorder',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			var a='';
			//console.log(data[0].orderid+'-------'+data[0].orderid*1+'-------'+data.length);
			for(i=0;i<6-parseInt(data[0].orderid*1+data.length).toString().length;i++){
				a+='0'
			}
			$("#orderid").textbox('setValue',a+(data[0].orderid*1+data.length).toString());		
			}	
		})//---------ajax结束
	$.ajax({
		url:'getStorehouse',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			$("#fromsh").combobox({
				data:data,
				textField:"housename",
				valueField:"housename",
				panelHeight:true
			})
			}	
		})

	$.ajax({
		url:'getProduct1',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			$("#productid").combobox({
				data:data,
				textField:"productid",
				valueField:"productid",
				panelHeight:true,
				editable:false
				
			})

			}	
		})
		
	$.ajax({
		url:'getSituation',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			qdata=data;
			}	
		})
		
	$("#productid").combobox({
		onSelect:function(a){
			b="[{\"housename\":\""+a.housename.trim()+"\"}]";
			$("#fromsh").combobox({
				data:eval(b),
				textField:"housename",
				valueField:"housename",
				panelHeight:true
			})
			$("#productname").textbox('setValue',a.productname);
			
			for(i=0;i<=qdata.length-1;i++){
				if(qdata[i].productid==a.productid){
					$("#nowq").numberbox('setValue',qdata[i].quantity);
				}
			}
		}
	})
	$("#quantity").next('span').find('input').blur(function(){
		var q=$("#quantity").numberbox('getValue');
		var nq=$("#nowq").numberbox('getValue');
		if((q-nq)>0){                 //直接判断q，nq就是有问题
			console.log(q-nq);
			console.log(nq);
			alert('库存商品数量不足！');
		}
	})
	$.ajax({
		url:'getStorehouse',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			$("#tosh").combobox({
				data:data,
				textField:"housename",
				valueField:"housename",
				panelHeight:true
			})
			}	
		})

		
		
		
})

function dosend(){
	var orderid=$("#orderid").textbox('getValue');
	var productid=$("#productid").combobox('getValue');
	var fromsh=$("#fromsh").combobox('getValue');
	var tosh=$("#tosh").combobox('getValue');
	var quantity=$("#quantity").numberbox('getValue');
	
	//还差两个操作 +-商品数量，product3减数量可以用 加数量得重写一个dao
	/*$.ajax({
		url:"Product2Servlet?productid="+productid+"&perprice="+perprice+"&quantity="+quantity,
		method:"put",
		data:{"productid":productid,"perprice":perprice,"quantity":quantity},//没用 put delete只能url传参
		success:function(a){

		}
		
	})
	*/
	$.ajax({
		url:"postTransferorder",
		method:"post",
		data:{"orderid":orderid,"productid":productid,"fromsh":fromsh,"tosh":tosh,"quantity":quantity},
		success:function(a){
			alert('调拨单提交成功！');
			window.location.reload();
		}
		
	})
	
	
}
</script>


</body>
</html>