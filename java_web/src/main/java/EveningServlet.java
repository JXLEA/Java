import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/evening")
public class EveningServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final var name = "name";
        var session = req.getSession();
        var yourNameSession = Optional.ofNullable(session.getAttribute(name));
        var yourNameRequest = Optional.ofNullable(req.getParameter(name));

        var finalName = yourNameRequest.orElseGet(() -> String.valueOf(yourNameSession.orElse("Buddy")));
        session.setAttribute(name, finalName);
        resp.getWriter().print(String.format("Good evening, %s", finalName));
    }
}
