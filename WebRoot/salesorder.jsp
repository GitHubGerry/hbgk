<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<title>何不管库</title>
	<jsp:include page="toolbar.jsp"/>
	<link rel="stylesheet" type="text/css" href="jqeasyui/themes/gray/easyui.css">   <!-- 8.5复出第一个页面，这个css还是要有为了下拉框 -->
	
</head>
<body>

<div id="main">
<table border=2 style="position:absolute;top:190px;width:95%;height:300px;margin-left:10px;z-index:-2">
<tr><th colspan="7">售货单</th></tr>
<tr id="tr2"><td>&nbsp编号&nbsp</td><td>&nbsp商品&nbsp</td><td>顾&nbsp&nbsp&nbsp客</td><td>仓库</td><td>单价</td><td>数量</td><td>总金额</td></tr>
	<tr>
		<td></td><td></td><td></td><td></td><td></td><td></td><td></td>
	</tr>
</table>
</div>

<script>
$(document).ready(function(){
	str="<div id='orderid_div'><input class='easyui-textbox' id='orderid' style='width:125px;height:28px'/></div>";
	$("#main").append($(str));
	$("#orderid").textbox({readonly:true});
	$("#orderid_div").css({
		position:"absolute",
		top:"420px",
		left:"40px",
		display:"inline"
	})
	str="<div id='productname_div'><input class='easyui-combobox' id='productname' style='width:125px;height:28px'/></div>";
	$("#main").append($(str));
	$("#productname").combobox();
	$("#productname_div").css({
		position:"absolute",
		top:"420px",
		left:"280px",
		display:"inline"
	})
	str="<div id='companyname_div'><input class='easyui-combobox' id='companyname' style='width:125px;height:28px'/></div>";
	$("#main").append($(str));
	$("#companyname").combobox();
	$("#companyname_div").css({
		position:"absolute",
		top:"420px",
		left:"520px",
		display:"inline"
	})
	str="<div id='housename_div'><input class='easyui-combobox' id='housename' style='width:125px;height:28px'/></div>";
	$("#main").append($(str));
	$("#housename").combobox({editable:false});
	$("#housename_div").css({
		position:"absolute",
		top:"420px",
		left:"720px",
		display:"inline"
	})
	str="<div id='perprice_div'><input class='easyui-numberbox' id='perprice' style='width:125px;height:28px' data-options='precision:2'/></div>";
	$("#main").append($(str));
	$("#perprice").numberbox();
	$("#perprice_div").css({
		position:"absolute",
		top:"420px",
		left:"900px",
		display:"inline"
	})
	str="<div id='quantity_div'><input class='easyui-numberbox' id='quantity' style='width:125px;height:28px'/></div>";
	$("#main").append($(str));
	$("#quantity").numberbox();
	$("#quantity_div").css({
		position:"absolute",
		top:"420px",
		left:"1070px",
		display:"inline"
	})
	str="<div id='amount_div'><input class='easyui-numberbox' id='amount' style='position:absolute;top:420px;width:125px;height:28px' data-options='precision:2'/></div>";
	str+='<a id="send" class="easyui-linkbutton" onclick="dosend()" style="position:absolute;top:520px;left:1370px;height:33px;width:70px">提交</a>';
	$("#main").append($(str));
	$("#amount").numberbox();
	$("#amount_div").css({
		position:"absolute",
		top:"420px",
		left:"1270px",
		display:"inline"
	})
	$("#send").linkbutton();
	
	$.ajax({
		url:'selectSalesOrder',
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
		url:'selectStorehouse',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			$("#housename").combobox({
				data:data,
				textField:"housename",
				valueField:"housename",
				panelHeight:true
			})
			}	
		})

	$.ajax({
		url:'selectProduct',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			$("#productname").combobox({
				data:data,
				textField:"productname",
				valueField:"productid",
				panelHeight:true,
				editable:false
				
			})
			}	
		})
	$("#productname").combobox({
		onSelect:function(a){
			b="[{\"housename\":\""+a.housename.trim()+"\"}]";
			console.log(b);
			$("#housename").combobox({
				data:eval(b),
				textField:"housename",
				valueField:"housename",
				panelHeight:true
			})
		}
	})
	$.ajax({
		url:'selectBuyer',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			$("#companyname").combobox({
				data:data,
				textField:"companyname",
				valueField:"buyerid",
				panelHeight:true,
				editable:false
			})
			}	
		})
		
	$("#amount").next("span").find("input").focus(function(){
		amount=$("#perprice").numberbox('getValue')*$("#quantity").numberbox('getValue');
		$("#amount").numberbox('setValue',amount);
	});
		
		
		
})

function dosend(){                                           //售货四件事：1.验证货够不够 2.创建订单3.更新顾客交易次数和平均利润百分率和最近利润百分率4.更新商品数量
	var orderid=$("#orderid").textbox('getValue');
	var productid=$("#productname").combobox('getValue');
	var buyerid=$("#companyname").combobox('getValue');
	var housename=$("#housename").combobox('getValue');
	var perprice=$("#perprice").numberbox('getValue');
	var quantity=$("#quantity").numberbox('getValue');
	var amount=$("#amount").numberbox('getValue');
	
	if(orderid=='' || productid=='' || buyerid=='' || housename=='' || perprice=='' || quantity=='' || amount==''){
		alert("请填写完整进货单！");
	}else{
		var qflag=false;
		var apc;
		$.ajax({
			url:"selectProductQuantity",
			data:{
				"productid":productid	
			},
			method:'get',//-------------------------------------------------有传回数据一定要写这句！
			async:false,
			success:function(data){
				console.log(data);
				var data=data.split(";");
				if(data[0]>=quantity){qflag=true};
				apc=data[1];
			}
		})
		if(qflag){
			
			$.ajax({
				url:"insertSalesOrder",
				data:{
					"orderid":orderid,
					"productid":productid,
					"buyerid":buyerid,
					"perprice":perprice,
					"quantity":quantity,
					"amount":amount
				},
				async:false
			})
			
			var lpp=Math.round((perprice-apc)/apc*100*100)/100;
			$.ajax({
				url:"SOupdateBuyer",
				async:false,
				data:{
					"lpp":lpp,
					"quantity":quantity,
					"buyerid":buyerid
				}
			})
			
			$.ajax({
				url:"SOupdateProducts",
				async:false,
				data:{
					"productid":productid,
					"quantity":quantity
				},
				success:function(a){
					alert("销售单提交成功!");
				}
			})
			
		}else{
			alert("库存数量不足！");
		}
	}
	window.location.reload();
}

</script>


</body>
</html>