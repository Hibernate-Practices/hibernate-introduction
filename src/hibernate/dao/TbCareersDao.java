/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.dao;

import hibernate.model.TbCareers;
import hibernate.model.TbStudents;
import hibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lab5-E
 */
public class TbCareersDao {
    private Session session;
    private Transaction transaction;
    
    public long InsertRow(TbCareers objTbCareer) throws HibernateException{
        long rowId = 0;        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            rowId = (Long) session.save(objTbCareer);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new HibernateException("Error in access to data... \b ->", ex);
        } finally{
            session.close();
        }       
        return rowId;
    }
    
    public void UpdateRow(TbCareers objTbCareer) throws HibernateException{
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(objTbCareer);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            throw  new HibernateException("Error in access to data...  \b ->"+ex);
        } finally {
            session.close();
        }
    }
    
    public void DeleteRow(TbCareers objTbCareer) throws HibernateException{
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(objTbCareer);
            transaction.commit();            
        } catch (HibernateException ex) {
            transaction.rollback();
            throw  new HibernateException("Error in access to data...  \b ->"+ex);
        } finally {
            session.close();
        }
    }
    
    public TbCareers SelectRow(long IdRow) throws HibernateException{
        TbCareers objTbCareer = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            objTbCareer = (TbCareers) session.get(TbCareers.class, IdRow);            
        } catch (HibernateException ex) {
            throw  new HibernateException("Error in access to data...  \b ->"+ex);
        } finally {
            session.close();
        }
        return objTbCareer;
    }
    
    public List<TbCareers> SelectRows() throws HibernateException{
        List<TbCareers> listTbCareers = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            listTbCareers = session.createSQLQuery("SELECT * FROM Tb_Careers").addEntity(TbCareers.class).list();            
        } catch (HibernateException ex) {
            throw  new HibernateException("Error in access to data...  \b ->"+ex);
        } finally {
            session.close();
        }
        return listTbCareers;
    }
    
    public List<Object[]> SelectStudentsAndCareerRows(String conditions) throws HibernateException{
        SQLQuery SqlQuery;
        List<Object[]>  list = null;
        String query = "SELECT * FROM Tb_Careers, Tb_Students WHERE Tb_Students.fl_fk_career=Tb_Careers.fl_pk_career";
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            SqlQuery = session.createSQLQuery(query);
            SqlQuery.addEntity(TbCareers.class);
            SqlQuery.addEntity(TbStudents.class);
            list = SqlQuery.list();
        } catch (HibernateException ex) {
            throw  new HibernateException("Error in access to data...  \b ->"+ex);
        } finally {
            session.close();
        }
        return list;
    }
    
    public static void main(String[] args) {
        TbCareersDao objTbCareersDao = new TbCareersDao();
//        List<TbCareers> listTbCareers = objTbCareersDao.SelectRows();
//        for (TbCareers listTbCareer : listTbCareers) {
//            System.out.println(listTbCareer.toString());
//        }
        
//        System.out.println(objTbCareersDao.SelectRow(1).toString());

        List<Object[]>  list = objTbCareersDao.SelectStudentsAndCareerRows("");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(((Object[]) list.get(i))[0]);     //account bean, actually this is in reverse order - so this is user bean
            System.out.println(((Object[]) list.get(i))[1]);     //user bean         & this account bean
        }
    }
}
