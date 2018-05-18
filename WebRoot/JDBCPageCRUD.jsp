<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*,java.text.SimpleDateFormat,java.util.Date"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
  <table border="1">
  
  <tr><th>bookid</th><th>name</th><th>writer</th><th>phouse</th><th>date</th></tr>
  
	<%request.setCharacterEncoding("utf-8");
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=jqdemos","sa","sqlserver2008");	
	Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	
	String Cbookid=request.getParameter("Cbookid");
	String Cname=request.getParameter("Cname");
	String Cwriter=request.getParameter("Cwriter");
	String Cphouse=request.getParameter("Cphouse");
	String Cdate=request.getParameter("Cdate");
	String Csql="";
	if(Cbookid==null || Cbookid.equals("")){	
	}else{
		Csql="insert into mybooks(bookid,name,writer,phouse,date) values('"+Cbookid+"','"+Cname+"','"+Cwriter+"','"+Cphouse+"','"+Cdate+"')";
	}	
	stmt.executeUpdate(Csql);  //执行新增
	
	String Uwhichrow=request.getParameter("Uwhichrow");
	String Uvalue=request.getParameter("Uvalue");
	String Uwhichrow2=request.getParameter("Uwhichrow2");
	String Uvalue2=request.getParameter("Uvalue2");
	String Usql="";
	if(Uwhichrow==null || Uwhichrow.equals("")){	
	}else{
		Usql="update mybooks set "+Uwhichrow+"='"+Uvalue+"' where "+Uwhichrow2+"='"+Uvalue2+"'";
		System.out.println(Usql);
	}
	stmt.executeUpdate(Usql);  //执行修改
	
	String Dwhichrow=request.getParameter("Dwhichrow");
	String Dvalue=request.getParameter("Dvalue");
	String Dsql="";
	if(Dwhichrow==null || Dwhichrow.equals("")){
	}else{
		Dsql="delete mybooks where "+Dwhichrow+"='"+Dvalue+"'";
	}
	stmt.executeUpdate(Dsql);  //执行删除
	
	String whichrow=request.getParameter("whichrow");
	String value=request.getParameter("value");	
	String sql="select * from mybooks";
	if(whichrow==null || whichrow.equals("")){
		sql="select * from mybooks";
	}else{
		sql="select * from mybooks where "+whichrow+" like '%"+value+"%'";
	}
			
	stmt.executeQuery(sql);  	//执行查询
	ResultSet rs=stmt.getResultSet();
	if(!rs.next()){		//数据库空指针判断 或者try-catch
	}else{
		System.out.println(1);
		int countPerPage=10;
		int rowCount;
		int pageCount;
		int curPage;
		int i;
		rs.last();
		rowCount=rs.getRow();
		pageCount=((rowCount%countPerPage)==0)?(rowCount/countPerPage):(rowCount/countPerPage+1);
		String strCurPage=request.getParameter("page");
		if (strCurPage == null || strCurPage.equals("")) {
			curPage = 1; // URL中不带参数的情况
		} else {

		curPage=Integer.parseInt(strCurPage);}
		
			rs.absolute((curPage-1)*countPerPage+1);//rs 定位到当前页第一行
			
			for(i=0;i<countPerPage&&!rs.isAfterLast();rs.next(),i++){	
				String bookid=rs.getString(1);
				String name=rs.getString(2);
				String writer=rs.getString(3);
				String pHouse=rs.getString(5);
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");		//日期转字符我可以直接getString取，但是这样标准。	
				String date=sdf.format(rs.getDate(6));
	%>
				<tr>
				<td><%=bookid %></td>
				<td><%=name %></td>
				<td><%=writer %></td>
				<td><%=pHouse %></td>
				<td><%=date %></td>
				</tr>
		<%}%>	
	<tr>	
	

	<td><%out.println("<a href='" + request.getRequestURL()+ "?page=1'>首页</a>");%></td>
	<td><%out.println("<a href='" + request.getRequestURL() + "?page="+ (curPage == 1 ? curPage : curPage - 1) + "'>上一页</a>");%></td>
	<td><%out.println("<a href='" + request.getRequestURL() + "?page="+ (curPage == pageCount ? curPage : curPage + 1)+ "'>下一页</a>");%></td>
	<td><%out.println("<a href='" + request.getRequestURL() + "?page="+ pageCount + "'>末页</a>");}%> </td>
	</tr>
	

	</table>
	<br>
	<form action="" method="post">
	查哪列？<input class='text' name='whichrow'/>值中包含什么？<input class='text' name='value'>
	<input type="submit" value="查询">		
	</form>
	<br>
	<form action="" method="post">
	增加一行<br><input class='text' name='Cbookid'/> <input class='text' name='Cname'> <input class='text' name='Cwriter'> <input class='text' name='Cphouse'> <input class='text' name='Cdate'>
	<input type="submit" value="增加">		
	</form>
	<br>
	<form action="" method="post" >
	修改哪列？<input class='text' name='Uwhichrow'/>值为？<input class='text' name='Uvalue'><br><br>
	条件是当<input class='text' name='Uwhichrow2'>列值为<input class='text' name='Uvalue2'>时
	<input type="submit" value="修改">		
	</form>
	<br>
	<form action="" method="post">
	删除哪行？<input class='text' name='Dwhichrow'/>值为？<input class='text' name='Dvalue'/>
	<input type="submit" value="删除">		
	</form>

	<%rs.close();
	conn.close();
	stmt.close(); %>
  </body>
</html>
