package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neebalgurukul.service.LoginService;
import com.neebalgurukul.service.StudentService;

@WebServlet(urlPatterns = "/register.do")
public class StudentServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	System.out.println("Inside LoginServlet");
	request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
	LoginService loginService = new LoginService();
	StudentService studentService = new StudentService();
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String course = request.getParameter("course");
	int age = Integer.parseInt(request.getParameter("age"));
	String username = request.getParameter("username");
	String password = request.getParameter("password");

//		System.out.println("I/P Parameter :" + name + " , " + password);

	request.setAttribute("name", name);
	request.setAttribute("email", email);
	request.setAttribute("course", course);
	request.setAttribute("age", age);
	request.setAttribute("username", username);
	request.setAttribute("password", password);

	if (!studentService.isPresent(username)) {
	    try {
		loginService.insertLogin(username, password);
		studentService.insertStudent(name, email, course, age, username);
		request.getRequestDispatcher("/WEB-INF/views/search.jsp").forward(request, response);
	    } catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	} else {
	    request.setAttribute("errorMessage", "The username already Exists!, pleas login");
	    try {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	    } catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
}
