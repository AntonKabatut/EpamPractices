package listener;

import entity.Sport;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class AppContextListener implements ServletContextListener {

    Map<String, Sport> map;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        map = new HashMap<>();
        map.put("football", new Sport());
        map.put("basketball", new Sport());
        map.put("biathlon", new Sport());

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("map", map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
