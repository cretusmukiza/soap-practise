package com.cretus.soapweb;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//Enable spring webservices
@EnableWs

//Spring configuration
@Configuration
public class WebserviceConfig {
    // MessageDispatcherServlet

    @Bean
    ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet(); 
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet,"/ws/*");
    }

    // ws/courses.wsdl
    // portType - coursePort
    // Namespace - 
    // course-details.xsd

    @Bean(name="courses")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("CoursePort");
        definition.setTargetNamespace("http://cretus.com/courses");
        definition.setLocationUri("/ws");
        definition.setSchema(coursesSchema);
        return definition;

    }
    @Bean
    public XsdSchema coursesSchema(){
        return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
    }
}
