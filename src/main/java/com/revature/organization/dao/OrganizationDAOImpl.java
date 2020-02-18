package com.revature.organization.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.organization.model.Organization;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Organization> get() {
		Session curentSession = entityManager.unwrap(Session.class);
		Query<Organization> query = curentSession.createQuery("from Organization", Organization.class);
		List<Organization> list = query.getResultList();
		return list;
	}

	@Override
	public Organization get(int id) {
		Session curentSession = entityManager.unwrap(Session.class);
		Organization organizationObject = curentSession.get(Organization.class, id);
		return organizationObject;
	}

	@Override
	public void save(Organization org) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(org);
		
	}
	

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Organization organizationObject=currentSession.get(Organization.class,id);
		currentSession.delete(organizationObject);
	}

}
