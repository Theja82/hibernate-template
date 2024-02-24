package hibernatetemplate.controller;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import hibernatetemplate.dao.Merchantdao;
import hibernatetemplate.dto.Merchant;

public class Merchantcontroller {
	private static Merchantdao dao;
	private static Scanner s = new Scanner(System.in);
	static {
		ApplicationContext c = new ClassPathXmlApplicationContext("hib-template.xml");
		dao = c.getBean(Merchantdao.class);
	}

	public static void main(String[] args) {
		System.out.println("1.save merchant");
		System.out.println("2.update merchant");
		System.out.println("3.find merchant");
		System.out.println("4.delete merchant");
		System.out.println(dao);
		switch (s.nextInt()) {
		case 1:
			save();
			break;
		case 2:
			update();
			break;
		case 3:
			findbyid();
			break;
		case 4:
			delete();
			break;

		default:
			break;
		}
	}

	public static void save() {
		Merchant m = new Merchant();
		m.setName(s.next());
		m.setEmail(s.next());
		m.setGst_number(s.next());
		m.setPassword(s.next());
		m.setPhone(s.nextLong());
		m = dao.saveMerchant(m);
		if (m != null) {
			System.out.println("merchant saved " + m.getId());
		} else {
			System.out.println("not saved");
		}

	}

	public static void update() {
		Merchant m = new Merchant();
		System.out.println("enterid");
		m.setId(s.nextInt());
		m.setName(s.next());

		m.setEmail(s.next());
		m.setGst_number(s.next());
		m.setPassword(s.next());
		m.setPhone(s.nextLong());
		m = dao.updateMerchant(m);
		if (m != null) {
			System.out.println("merchant " + m.getId() + " updated");
		} else {
			System.out.println("merchant not foundS");
		}

	}

	public static void findbyid() {

		System.out.println("enterid");
		int id = s.nextInt();
		Merchant m = dao.findbyid(id);
		if (m != null) {
			System.out.println("merchant found:" + m.getId());

		}
		else {
			System.out.println("invalid id");
		}

	}

	public static void delete() {
		System.out.println("enterid");
		int id = s.nextInt();
	boolean m = dao.deletebyid(id);
		if(m==true) {
			System.out.println("merchant" +id+"deleted");
		}
		else {
			System.out.println("invalid id");
		}

	}

}
