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
        sessionFactory.getCurrentSession().save(cashPair);
    }

    public CashPair getCashPair(String key){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CashPair.class);
        criteria.add(
            Restrictions.eq("key", key)
        );
        return (CashPair) criteria.uniqueResult();
    }
}
