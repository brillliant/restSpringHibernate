package my.dao;

import my.dao.bean.CashPair;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CashPairDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void save(CashPair cashPair){
        sessionFactory.getCurrentSession().saveOrUpdate(cashPair);
    }

    public CashPair getCashPair(String name){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CashPair.class);
        criteria.add(
            Restrictions.eq("name", name)
        );
        return (CashPair) criteria.uniqueResult();
    }
}
