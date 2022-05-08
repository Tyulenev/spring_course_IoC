package org.example.hibernate.main;

import org.example.hibernate.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainHibernate {
    private static SessionFactory factory;

    public static void main(String[] args) {
        factory = new Configuration()
                .configure("hibernate.cfg.xml") // Если назван - hibernate.cfg.xml, то можно не указывать
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

//        addDataToTable();
//        getDataFromTableById(21);
//        getAllDataFromTable();
//        changeDataInTable();
        deleteDataFromTable();
    }

    public static void addDataToTable() {


        try{
            Session session = factory.getCurrentSession();
            Employee emp1 = new Employee("ALexey", "Mikaelan", "HR", 1800);
            session.beginTransaction();
            session.save(emp1);
            session.getTransaction().commit();
            System.out.println("DONE!");
            System.out.println(emp1);
        }
        finally {
            factory.close();
        }
    }

    public static Employee getDataFromTableById(int id) {
        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp = session.get(Employee.class, id);
            session.getTransaction().commit();
            System.out.println(emp);
            return emp;
        }
        finally {
            factory.close();
        }
    }

    public static void getAllDataFromTable() {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employee> emps = session.createQuery("from Employee") //Employee - класс а не таблица. HQL
                    .getResultList();
            System.out.println("Всего работников: " + emps.size());
            for (Employee e : emps) {
                System.out.println(e);
            }
        }
        finally {
            factory.close();
        }
    }

    public static void changeDataInTable() {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("UPDATE Employee set salary= 980 " +
                    "where salary<980 ").executeUpdate();
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }

    public static void deleteDataFromTable() {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employee> emps = session.createQuery("from Employee") //Employee - класс а не таблица. HQL
                    .getResultList();
            for (Employee e : emps) {
                if (e.getSalary()<=980) {
                    session.delete(e);
                }
            }
//            session.createQuery("DELETE Employee " +
//                    "where surname = 'Berezov'").executeUpdate();
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
