package deutscherv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.Startup;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/start")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public StartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		try(PrintWriter out = response.getWriter()) {
			out.println("Hello " + (name != null ? name : "World") + "!");
			
		};
	
	}

}
