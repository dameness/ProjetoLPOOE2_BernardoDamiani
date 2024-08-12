/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.projetolpooe2_bernardodamiani.dao;

import br.edu.ifsul.cc.lpoo.projetolpooe2_bernardodamiani.model.Disciplina;
import br.edu.ifsul.cc.lpoo.projetolpooe2_bernardodamiani.model.Professor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vanessalagomachado
 */
public class PersistenciaJPA implements InterfacePersistencia {

    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("pu_projeto_lpoo");
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        return entity.find(c, id);
    }

    @Override
    public void persist(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.persist(o);
        entity.getTransaction().commit();
    }

    @Override
    public void remover(Object o) throws Exception {
        entity.getTransaction().begin();
        entity.remove(o);
        entity.getTransaction().commit();
    }
    
    public List<Professor> getProfessores(){  
        return entity.createQuery("select p from Professor p", Professor.class).getResultList();
    }
    
     public List<Disciplina> getDisciplinas(){  
        return entity.createQuery("select d from Disciplina d", Disciplina.class).getResultList();
    }

}
