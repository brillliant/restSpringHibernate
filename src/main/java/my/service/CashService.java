package my.service;

import my.dao.bean.CashPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CashService {

    private Map<String,String> concurrentHashMap = new ConcurrentHashMap();

    public CashPair setCash(String key, String value){
        concurrentHashMap.put(key, value);
        CashPair cashPair = new CashPair(key, value);
        return cashPair;
    }

    public CashPair getCash(String key){
        CashPair cashPair;
        String value = concurrentHashMap.get(key);
        cashPair = new CashPair(key, value);
        return cashPair;
    }
}
