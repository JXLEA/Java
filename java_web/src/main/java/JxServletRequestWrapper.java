import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpSession;

public class JxServletRequestWrapper extends HttpServletRequestWrapper implements HttpServletRequest {

    private HttpServletRequest request;
    public JxSession session;

    public JxServletRequestWrapper(HttpServletRequest request) {
        super(request);
        session = new JxSession();
    }

    @Override
    public HttpSession getSession() {
        System.out.println("Hello from custom session");
        return session;
    }
}
