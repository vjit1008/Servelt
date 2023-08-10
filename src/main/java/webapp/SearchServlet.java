package webapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neebalgurukul.model.Student;
import com.neebalgurukul.service.StudentService;

@WebServlet(urlPatterns = "/search.do")
public class SearchServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
	StudentService studentService = new StudentService();
	String searchQuery = request.getParameter("search");

	List<Student> StudenList = studentService.getAllStudent(searchQuery);

	try {
	    request.setAttribute("searchResult", StudenList);
	    request.getRequestDispatcher("/WEB-INF/views/searchResult.jsp").forward(request, response);
	} catch (ServletException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
