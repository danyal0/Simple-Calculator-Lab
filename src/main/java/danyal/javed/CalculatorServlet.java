package danyal.javed;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Calculator</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<a href='/Lab11_war_exploded'>Go back</a>" +
                "</body>\n" +
                "</html>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession();
        double number1 = Double.parseDouble(request.getParameter("number1"));
        double number2 = Double.parseDouble(request.getParameter("number2"));
        double number3 = Double.parseDouble(request.getParameter("number3"));
        double number4 = Double.parseDouble(request.getParameter("number4"));
        Calculator calculator = new Calculator();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        calculator.setNumber1(number1);
        calculator.setNumber2(number2);
        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Calculator</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"CalculatorServlet\" method=\"post\">\n" +
                "    <input type=\"number\" name=\"number1\" step=\"any\" value=\"" + number1 + "\"> +\n" +
                "    <input type=\"number\" name=\"number2\" step=\"any\" value=\"" + number2 + "\"> =\n" +
                "    <input type=\"number\" name=\"result1\" value=\"" + calculator.sum() + "\" disabled><br>\n" +
                "    <input type=\"number\" name=\"number3\" step=\"any\" value=\"" + number3 + "\"> x\n" +
                "    <input type=\"number\" name=\"number4\" step=\"any\" value=\"" + number4 + "\"> =\n");
        calculator.setNumber1(number3);
        calculator.setNumber2(number4);
        out.print("    <input type=\"number\" name=\"result2\" value=\"" + calculator.multiply() + "\" disabled><br>\n" +
                "    <input type=\"submit\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }
}
