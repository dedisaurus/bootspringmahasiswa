package com.restweb.demo.restwebdemo.dao;

import com.restweb.demo.restwebdemo.model.MahasiswaModel;
import com.restweb.demo.restwebdemo.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class MahasiswaDao implements MahasiswaService {

    EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<MahasiswaModel> listMahasiswa() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from MahasiswaModel", MahasiswaModel.class).getResultList();
    }

    @Override
    public MahasiswaModel saveOrUpdateDataMhs(MahasiswaModel mahasiswaModel) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        MahasiswaModel saved = em.merge(mahasiswaModel);
        em.getTransaction().commit();
        return saved;
    }
}
