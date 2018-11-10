<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<title>何不管库</title>
	<jsp:include page="toolbar.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="jqeasyui/themes/gray/easyui.css">
	
</head>
<body>

<div id="main">
<div id="datagrid_div" style="position:absolute;top:210px"></div>

<div id="realman" style="fit:auto;">
	<a href="#" id="insert" style="position:absolute;left:93%;top:177px;margin-right:30px" class="btn3" onclick="insertsh()">新增</a>
	<div class="easyui-window" id="mywin" style="height:435px;width:390px" title="新增供应商">
	<form id="insert" >
		<div style="position:absolute;top:57px;left:34px">供应商编码：</div>
		<div style="position:absolute;top:55px;left:120px"> <input id="supplierid" name="supplierid" type="text" class="easyui-textbox"/></div>
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
		<div style="position:absolute;top:380px;left:200px"><input class="easyui-linkbutton" style="width:60px;height:25px" onclick="check1()" value="提交"></div>		 
	</form>
	</div>
	<div class="easyui-window" id="mywin2" style="height:435px;width:390px" title="修改供应商">
	<form id="edit">
				<div style="position:absolute;top:57px;left:34px">供应商编码：</div>
		<div style="position:absolute;top:55px;left:120px"> <input id="supplierid2" name="supplierid2" type="text" class="easyui-textbox"/></div>
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



<script>
$(document).ready(function(){
	$.ajax({
		url:'selectSupplier',
		data:{},
		dataType: "json",
		anysc:false,
		method:'get',
		success:function(data){
			console.log(data);
			var str="<input class='eayui-datagrid' id='mydatagrid' style='width:900px;height:500px'/>";
			$("#datagrid_div").append($(str));
			$("#mydatagrid").datagrid({
				title: '&nbsp;供应商列表',
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
				sortName: 'supplierid',
				sortOrder: 'asc',
				remoteSort: false,
				columns:[[
							{ title: '公司名', field: 'companyname', width: 190, halign:'center', align: 'center'},
							{ title: '联系人1', field:'linkman1', width: 146, halign:'center', align: 'center'},
							{ title: '电话1', field:'tele1', width: 158, halign:'center', align: 'center'},	
							{ title: '联系人2', field:'linkman2', width: 146, halign:'center', align: 'center'},
							{ title: '电话2', field:'tele2', width: 158, halign:'center', align: 'center'},
							{ title: '微信', field:'wechat', width: 150, halign:'center', align: 'center'},
							{ title: '交易次数', field:'volume', width: 120, halign:'center', align: 'center',sortable:true},
							{ title: '操作', field:'operate', width: 210, halign:'center', align: 'center',formatter:operate}
							]],
				frozenColumns: [[{ title:'供应商编号',field: 'supplierid', width:182,align: 'center',sortable:true}]]

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
	var supplierid=$("#supplierid").textbox("getValue").trim();
	var companyname=$("#companyname").textbox("getValue").trim();
	var linkman1=$("#linkman1").textbox("getValue").trim();
	var tele1=$("#tele1").textbox("getValue").trim();
	var linkman2=$("#linkman2").textbox("getValue").trim();
	var tele2=$("#tele2").textbox("getValue").trim();
	var wechat=$("#wechat").textbox("getValue").trim();
	
	if(supplierid==''){err+='供应商编号不能为空<br>'};
	//---检验重复
	aa=$("#mydatagrid").datagrid("getRows");
	for(i=0;i<=aa.length-1;i++){
		if(supplierid==aa[i].supplierid.trim()){
			err+='供应商编号不能重复！<br>';
			break;
		}
	}
	if(companyname==''){err+='公司名不能为空<br>'};
	if(linkman1==''){err+='联系人1不能为空<br>'};
	if(tele1==''){err+='电话1不能为空<br>'};
	if(wechat==''){err+='微信不能为空<br>'};
	
	if(err!=''){
		$.messager.alert('系统提示',err);
		
	}else {
		insertdo(supplierid,companyname,linkman1,tele1,linkman2,tele2,wechat);
	}
}

function insertdo(supplierid,companyname,linkman1,tele1,linkman2,tele2,wechat){
	var url="insertSupplier?supplierid="+supplierid+"&companyname="+companyname+"&linkman1="+linkman1+"&tele1="+tele1+"&linkman2="+linkman2;
	url+="&tele2="+tele2+"&wechat="+wechat;
	$.ajax({
		url:url,
		async:false,
		success:function(){
			window.location.reload();
		}
	
		
	})
}

function editsh(index){
		$("#mydatagrid").datagrid("selectRow",index)
		aa=$("#mydatagrid").datagrid("getSelected");
		$("#supplierid2").textbox("setValue",aa.supplierid.trim());
		$("#supplierid2").textbox({readonly:true});
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
		var url='updateSupplier?supplierid='+$("#supplierid2").textbox("getValue")+'&companyname='+$("#companyname2").textbox("getValue");
		url+='&linkman1='+$("#linkman12").textbox("getValue")+'&tele1='+$("#tele12").textbox("getValue")+'&linkman2='+$("#linkman22").textbox("getValue");
		url+='&tele2='+$("#tele22").textbox("getValue")+'&wechat='+$("#wechat2").textbox("getValue");

		$.ajax({
			url:url,
			method:'edit',
			async:false,
			success:function(){
				window.location.reload();
			}
		})

	}
}




function deletesh(index){  
	if(window.confirm("确定删除？")){
		$("#mydatagrid").datagrid("selectRow",index)
		var aa=$("#mydatagrid").datagrid("getSelected");
		alert("删除成功");
		var url='deleteSupplier?supplierid='+aa.supplierid;
		$.ajax({
			url:url,
			method:'delete',
			async:false,
			success:function(){
				
				window.location.reload();
			}
		})

	}

}
function insertsh(){
	
	$("#mywin").window('open');
}




</script>
</body>
</html>