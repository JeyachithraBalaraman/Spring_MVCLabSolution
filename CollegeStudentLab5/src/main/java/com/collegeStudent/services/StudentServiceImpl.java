package com.collegeStudent.services;

import java.util.List;

import javax.transaction.Transactional;

import com.collegeStudent.model.Student;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentServiceImpl implements StudentService {
	// Create session
	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public void saveStudent(Student student) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();

	}

	@Transactional
	public Student findById(int id) {
		Transaction tx = session.beginTransaction();
		Student tempStudent = session.get(Student.class, id);
		tx.commit();
		return tempStudent;

	}

	@Transactional
	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();
		Student tempStudent = session.get(Student.class, id);
		if (tempStudent != null) {
			session.delete(tempStudent);
			tx.commit();
		}

	}

	@Transactional
	public List<Student> getAllStudent() {
		Transaction tx = session.beginTransaction();
		List<Student> listStudent = session.createQuery("from Student").list();
		tx.commit();
		return listStudent;
	}

}
