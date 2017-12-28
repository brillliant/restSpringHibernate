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


    public CashPair setCash(String name, String value){
        concurrentHashMap.put(name, value);
        CashPair cashPair = new CashPair(name, value);
        cashPairDAO.save(cashPair);
        return cashPair;
    }

    public CashPair getCash(String name){
        CashPair cashPair;
        String value = concurrentHashMap.get(name);

        if(value != null){
            cashPair = new CashPair(name, value);
        } else {
            cashPair = cashPairDAO.getCashPair(name);
            if(cashPair != null && cashPair.getName() != null && cashPair.getValue() != null) {
                concurrentHashMap.put(cashPair.getName(), cashPair.getValue());
            }
        }
        return cashPair;
    }
}
