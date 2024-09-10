package com.awsS3.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.awsS3.model.FileVo;

@Repository
public class FileDaoImp implements FileDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveFileDetails(FileVo fileVo) {
		
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            session.saveOrUpdate(fileVo);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	}
//	 @Override
//	    public void insertBlock(BlockVo blockVo) {
//	        try {
//	            Session session = sessionFactory.getCurrentSession();
//	            session.saveOrUpdate(blockVo);
//	        } catch (Exception e) {
//	            System.out.println(e);
//	        }
//	    }
//
//	    @Override
//	    public List<BlockVo> searchBlock() {
//	        List<BlockVo> list = new ArrayList<BlockVo>();
//	        try {
//	            Session session = sessionFactory.getCurrentSession();
//	            Query query = session.createQuery("from BlockVo where status=true");
//	            list = (List<BlockVo>) query.list();
//	        } catch (Exception e) {
//	            System.out.println(e);
//	        }
//	        return list;
//	    }

	@SuppressWarnings("unchecked")
	@Override
	public List<FileVo> getAllFiles() {
		List<FileVo> list = new ArrayList<FileVo>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from FileVo");
            list = (List<FileVo>) query.list();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
	}

}
