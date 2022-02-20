package com.ua.education.configuration;

import com.ua.education.facade.BookingFacade;
import com.ua.education.model.User;
import com.ua.education.model.impl.UserImpl;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class XmlBaseApplicationStarter {

    public static void main(String[] args) {
        ApplicationContext context = getApplicationContextXml("controller.xml");
        BookingFacade bookingFacade = context.getBean("bookingFacadeImpl", BookingFacade.class);
        System.out.println(bookingFacade.getClass().getName());

        User created = bookingFacade.createUser(new UserImpl(5, "Alice", "alice@gmail.com"));
        System.out.print(bookingFacade.getUserById(5));
    }

    public static ApplicationContext getApplicationContextXml(String pathToXml) {
        ApplicationContext context = new ClassPathXmlApplicationContext(pathToXml);
        return context;
    }

    public static ApplicationContext getGenericApplicationContext(String pathToXml) {
        GenericApplicationContext genericContext =  new GenericApplicationContext();
        new XmlBeanDefinitionReader(genericContext).loadBeanDefinitions(pathToXml);
        return genericContext;
    }
}
