package my.service;

import my.dao.CashPairDAO;
import my.dao.bean.CashPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Transactional
public class CashService {

    @Autowired
    CashPairDAO cashPairDAO;

    private Map<String,String> concurrentHashMap = new ConcurrentHashMap();


    public CashPair setCash(String key, String value){
        concurrentHashMap.put(key, value);
        CashPair cashPair = new CashPair(key, value);
        //cashPairDAO.save(cashPair);
        return cashPair;
    }

    public CashPair getCash(String key){
        CashPair cashPair;
        String value = concurrentHashMap.get(key);

        if(value != null){
            cashPair = new CashPair(key, value);
        } else {
            cashPair = cashPairDAO.getCashPair(key);
        }
        return cashPair;
    }
}
