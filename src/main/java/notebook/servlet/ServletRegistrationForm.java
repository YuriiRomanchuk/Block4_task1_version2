package notebook.servlet;

import notebook.controller.DataController;
import notebook.controller.ViewDataController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ServletRegistrationForm extends HttpServlet {

    private Map<String, String> userDataMap = new HashMap<>();
    private ViewDataController viewDataController = new ViewDataController(System.in);
    private DataController dataController = new DataController(viewDataController);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        initializeUserDataMap();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

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

        List<String> errorsData = new ArrayList<>();

        userDataMap.forEach((k, v) -> userDataMap.put(k, req.getParameter(k)));
        dataController.processUserData(userDataMap, errorsData);

        if (errorsData.size() > 0) {

            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");

            for (String errorsDatum : errorsData) {
                resp.getWriter().println(errorsDatum);
            }

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
                    .append("				<input type=\"text\" name=\"" + k + "\" value=\"" + v + "\" form=\"auth\"/>\r\n</p>"));
            writer.append("				<p><input type=\"submit\" value=\"Submit\" form=\"auth\"/></p>\r\n")
                    .append("			</form>\r\n")
                    .append("		</body>\r\n")
                    .append("</html>\r\n");

        } else {

            resp.getWriter().println("Yeahhhhhh!!!!!");

            userDataMap.forEach((k, v) -> {
                try {
                    resp.getWriter().println(k + ": " + v);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }

    }

    private void initializeUserDataMap() {

        userDataMap.clear();

        userDataMap.put("lastName", "");
        userDataMap.put("firstName", "");
        userDataMap.put("middleName", "");
        userDataMap.put("nickname", "");
        userDataMap.put("groupName", "");
        userDataMap.put("comment", "");
        userDataMap.put("skype", "");
        userDataMap.put("email", "");
        userDataMap.put("homePhoneNumber", "");
        userDataMap.put("mobilePhoneNumber", "");
        userDataMap.put("mobilePhoneNumberSecond", "");

        userDataMap.put("city", "");
        userDataMap.put("street", "");
        userDataMap.put("houseNumber", "");
        userDataMap.put("flatNumber", "");
        userDataMap.put("index", "");
    }

}