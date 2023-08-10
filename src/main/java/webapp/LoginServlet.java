package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neebalgurukul.service.LoginService;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {

	System.out.println("Inside LoginServlet....");
	request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
	LoginService loginService = new LoginService();
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	System.out.println("I/P Parameter :" + name + " , " + password);

	request.setAttribute("name", name);
	if (loginService.isValidUser(name, password)) {
	    try {
		request.getRequestDispatcher("/WEB-INF/views/search.jsp").forward(request, response);
	    } catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	} else {
	    request.setAttribute("errorMessage", "Invalid Credentials!");
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
