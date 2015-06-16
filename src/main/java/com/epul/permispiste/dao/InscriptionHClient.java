package com.epul.permispiste.dao;

import org.hibernate.*;

import com.epul.permispiste.service.ServiceHibernate;
import com.epul.permispiste.gestiondeserreurs.MonException;
import com.epul.permispiste.gestiondeserreurs.ServiceHibernateException;

import metier.*;

import java.util.*;

public class InscriptionHClient {
	private Session session;

	public InscriptionHClient() {
		session = ServiceHibernate.currentSession();
	}

	public void insert(Inscrit inscr) {
		try {
			session.beginTransaction();
			session.saveOrUpdate(inscr.getCalendrier()); //calendrier must be not null
			session.save(inscr);
			session.getTransaction().commit();
		} catch (ServiceHibernateException ex) {
			throw new ServiceHibernateException("Erreur de service Hibernate: "
					+ ex.getMessage(), ex);
		} catch (Exception ex) {
			System.out.println(ex);
			throw new MonException("Erreur  Hibernate: ", ex.getMessage());
		}
	}

	public Inscrit find(Apprenant a, Calendrier c, Jeu j) {
		Inscrit inscr = null;
		try {
			Query query = session
					.createQuery("SELECT inscr FROM Inscrit inscr WHERE inscr.apprenant = :a and inscr.calendrier = :c and inscr.jeu = :j");
			query.setParameter("a", a);
			query.setParameter("c", c);
			query.setParameter("j", j);

			inscr = (Inscrit) query.uniqueResult();
		} catch (Exception ex) {
			throw new MonException("Erreur  Hibernate: ", ex.getMessage());
		}
		return inscr;
	}
}