import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionContext;
import lombok.Data;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Data
public class JxSession implements HttpSession {

    private int sessionId;
    private Date createdTime;
    private Map<String, Object> storage;

    public JxSession() {
        sessionId = ThreadLocalRandom.current().nextInt(1000);
        storage = new HashMap<>();
        createdTime = new Date();
    }

    @Override
    public long getCreationTime() {
        return createdTime.getTime();
    }

    @Override
    public String getId() {
        return String.valueOf(sessionId);
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public void setMaxInactiveInterval(int interval) {
    }

    @Override
    public int getMaxInactiveInterval() {
        return 0;
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return null;
    }

    @Override
    public Object getAttribute(String name) {
        System.out.println("get attribute: " + name);
        return storage.get(name);
    }

    @Override
    public Object getValue(String name) {
        return storage.get(name);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public String[] getValueNames() {
        return null;
    }

    @Override
    public void setAttribute(String name, Object value) {
        storage.put(name, value);
    }

    @Override
    public void putValue(String name, Object value) {
        storage.put(name, value);
    }

    @Override
    public void removeAttribute(String name) {
        storage.remove(name);
    }

    @Override
    public void removeValue(String name) {
        storage.put(name, null);
    }

    @Override
    public void invalidate() {
        storage = new HashMap<>();
    }

    @Override
    public boolean isNew() {
        return false;
    }
}
