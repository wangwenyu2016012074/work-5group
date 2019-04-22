package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Stu;
import entity.Student;

@WebServlet("/StuServlet")
public class StuServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public StuServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String flag=request.getParameter("flag");
		
		if(flag!=null&&!flag.equals("")){
			switch(flag){
			  case "all":
			  	 getAll(request,response);
			  	 break;
			  case "del":
				 delete(request,response);
				 break;
			  case "add":
				 add(request,response);
				 break;
			  case "edit":
				 edit(request,response);
				 break;
			  case "get":
				 get(request,response);
				 break;	
			  case "geted":
				  geted(request,response);
				  break;
			}		
		}
	}

	private void geted(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID=Integer.parseInt(request.getParameter("id"));
		Stu nDao = new Stu();
		Student nStudent=nDao.getStudent(ID);
		request.setAttribute("id",ID);
		request.setAttribute("name",nStudent.getName());
		request.setAttribute("gender",nStudent.getGender());
		request.setAttribute("birDate", nStudent.getBirDate());
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		Stu stu=new Stu();
	    List<Student> sList=stu.query1(name);
	    request.setAttribute("nresult", sList);
	    request.getRequestDispatcher("showget.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Student student=new Student();
		student.setBirDate(request.getParameter("birDate"));
		student.setGender(request.getParameter("gender"));
		student.setName(request.getParameter("name"));
		student.setId(Integer.parseInt(request.getParameter("id")));
		new Stu().updateStudent(student);	
		response.getWriter().print("<script language='javascript'>alert('操作成功')</script>");
		response.setHeader("refresh", "1;URL=/ManageStu/StuServlet?flag=all&edit=y");	
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("name");
		String birDate=request.getParameter("birDate");
		String gender=request.getParameter("gender");
		int id=Integer.parseInt(request.getParameter("id"));
		//Date day=new Date();    
		//SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd"); 
		//System.out.println(date.format(day));   
		Student n=new Student();
		n.setId(id);
		n.setName(name);
		n.setGender(gender);
		n.setBirDate(birDate);
		Stu nDao=new Stu();
		nDao.addStudent(n);
		try {
			response.getWriter().print("<script language='javascript'>alert('操作成功')</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setHeader("refresh", "1;URL=/ManageStu/add.jsp");		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int ID=Integer.parseInt(request.getParameter("id"));
		Stu nDao = new Stu();
		nDao.delStudent(ID);
		response.getWriter().print("<script language='javascript'>alert('操作成功')</script>");
		response.setHeader("refresh", "1;URL=/ManageStu/StuServlet?flag=all&del=y");		
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String edit=request.getParameter("edit");
		String del=request.getParameter("del");
		Stu nDao = new Stu();
		List<Student> nresult = new ArrayList<Student>();
		String current=request.getParameter("currentPage");
		String total=request.getParameter("totalPage");
		//System.out.println("ii:"+total);
		int currentPage=new Page().countPage(current, total);
		int totalPage;
		totalPage=nDao.getTotalPage();
		nresult = nDao.query(currentPage);
		if(edit!=null&&!edit.equals(""))
		{
			request.setAttribute("edit",edit);	
		}			
		else if (del!=null&&!del.equals("")) {
			request.setAttribute("del",del);	
		}
		request.setAttribute("nresult", nresult);
		request.setAttribute("totalPage",totalPage);
		request.setAttribute("currentPage",currentPage);
		request.getRequestDispatcher("showout.jsp").forward(request, response);
	}
		

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
