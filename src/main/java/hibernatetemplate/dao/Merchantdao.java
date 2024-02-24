package hibernatetemplate.dao;

import javax.management.QueryExp;
import javax.persistence.Query;

//import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import hibernatetemplate.dto.Merchant;

public class Merchantdao {
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public Merchant saveMerchant(Merchant m) {
		template.save(m);
		return m;
	}

	public Merchant updateMerchant(Merchant merchant) {
		Merchant m = template.get(Merchant.class, merchant.getId());
		if (m != null) {
			m.setName(merchant.getName());
			m.setEmail(merchant.getEmail());
			m.setGst_number(merchant.getGst_number());
			m.setPassword(merchant.getPassword());
			m.setPhone(merchant.getPhone());
			return m;
		} else {
			return null;
		}

	}

	public Merchant findbyid(int id) {
		Merchant m = template.get(Merchant.class, id);
		return m;
	}

	public boolean deletebyid(int id) {
		Merchant m = findbyid(id);
		if (m != null) {
			template.delete(m);
			return true;
		} else {
			return false;
		}
	}
	
}
