package com.implementation;

import java.util.HashMap;
import java.util.Map;
import com.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtilCMS 
{
	private static StandardServiceRegistry registry = null;
	private static SessionFactory sf = null;
	
	public static SessionFactory getSessionFactory()
	{
		if(sf == null)
		{
			Map<String, Object> settings = new HashMap<>();
			
			settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/college_management");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "root");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			settings.put(Environment.HBM2DDL_AUTO, "update");
			settings.put(Environment.SHOW_SQL, "true");
			
			registry = new StandardServiceRegistryBuilder().applySettings(settings).build();
			MetadataSources mds = new MetadataSources(registry);
			mds.addAnnotatedClass(Student.class);
			mds.addAnnotatedClass(Batch.class);
			mds.addAnnotatedClass(Faculty.class);
			mds.addAnnotatedClass(Course.class);
			Metadata md = mds.getMetadataBuilder().build();
			sf = md.getSessionFactoryBuilder().build();
		}
		return sf;
	}
}
