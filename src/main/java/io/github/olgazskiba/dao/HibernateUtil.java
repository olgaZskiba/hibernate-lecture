package io.github.olgazskiba.dao;

import io.github.olgazskiba.bean.Boy;
import org.hibernate.AnnotationException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.imageio.spi.ServiceRegistry;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory==null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = loadProperties();
                settings.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Boy.class);

                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }


    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

    private static Properties loadProperties(){
        Properties properties = new Properties();

        try(InputStream in = new FileInputStream("src/main/resources/jis6.properties")){
            properties.load(in);
        } catch (Exception e) {
        System.out.println("Cannnot find properties");
        return null;
        }
        return properties;
        }
    }

