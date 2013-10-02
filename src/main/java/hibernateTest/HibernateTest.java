package hibernateTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import model.*;

public class HibernateTest {
	private static SessionFactory sessionFactory;
	
	public HibernateTest(){
		sessionFactory = new AnnotationConfiguration()
			.configure()
			.addPackage("model")
			.addAnnotatedClass(SellService.class)
			.addAnnotatedClass(ServiceItem.class)
			.addAnnotatedClass(RateItem.class)
			.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void main(String[] args){
		HibernateTest blar = new HibernateTest();
		blar.createAndStoreEvent();
	}
	
	 private void createAndStoreEvent() {
	        Session session = getSessionFactory().getCurrentSession();
	        session.beginTransaction();

	        SellService sellService = new SellService();
	        sellService.setName("Blerg");

	        session.save(sellService);
	        
	        RateItem ri1 = new RateItem();
	        ri1.setBusinessKey("RI1");
	        RateItem ri2 = new RateItem();
	        ri2.setBusinessKey("RI2");

	        session.save(ri1);
	        session.save(ri2);
	        
	        ServiceItem serviceItem = new ServiceItem();
	        serviceItem.setBusinessKey("SI001");
	        serviceItem.setSellService(sellService);
	        serviceItem.getRateItems().add(ri1);
	        serviceItem.getRateItems().add(ri2);

	        session.save(serviceItem);
	        
	        session.getTransaction().commit();
	    }
}
