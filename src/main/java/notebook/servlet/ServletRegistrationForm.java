package notebook.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class ServletRegistrationForm extends HttpServlet {

    private Map<String, String> userDataMap = new HashMap<>();

    {
        initializeuserDataMap();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // set response headers
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().println("Hello!");

        PrintWriter writer = resp.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("		<head>\r\n")
                .append("			<title>Form input</title>\r\n")
                .append("		</head>\r\n")
                .append("		<body>\r\n")
                .append("			<form id=\"auth\" action=\"welcome\" method=\"POST\">\r\n");
        userDataMap.forEach((k, v) -> writer
                .append("				<p>Enter your " + k + ": \r\n")
                .append("				<input type=\"text\" name=\"" + k + "\" form=\"auth\"/>\r\n</p>"));
        writer.append("				<p><input type=\"submit\" value=\"Submit\" form=\"auth\"/></p>\r\n")
                .append("			</form>\r\n")
                .append("		</body>\r\n")
                .append("</html>\r\n");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*  String lastName = req.getParameter("lastName");*/

        userDataMap.forEach((k, v) -> userDataMap.put(k, req.getParameter(k)));

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("		<head>\r\n")
                .append("			<title>Form input</title>\r\n")
                .append("		</head>\r\n")
                .append("		<body>\r\n");

        userDataMap.forEach((k, v) -> writer
                .append("			<form action=\"welcome\" method=\"GET\">\r\n")
                .append("				Your " + k + ":  " + v + "\r\n")
                .append("			</form>\r\n"));
        writer.append("		</body>\r\n")
                .append("</html>\r\n");

    }

    private void initializeuserDataMap() {

        userDataMap.put("lastName", "");
        userDataMap.put("firstName", "");
    }

}
