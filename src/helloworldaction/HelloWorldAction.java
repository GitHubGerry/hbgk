package helloworldaction;

public class HelloWorldAction extends com.opensymphony.xwork2.ActionSupport{

	      @Override
	      public String execute() throws Exception {
	          System.out.println("正在执行的Action222。。。");
	          // 返回视图 SUCCESS，这是框架定义
	          return ERROR;
	          
	      }
}
