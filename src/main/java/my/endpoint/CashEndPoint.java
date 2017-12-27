package my.endpoint;

import my.dao.bean.CashPair;
import my.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cash")
public class CashEndPoint {

    @Autowired
    CashService cashService;

    @PostMapping
    public Object setValue(@RequestParam String key, @RequestParam String value) {
        CashPair cashPair = cashService.setCash(key, value);
        return ResponseEntity.ok(cashPair);
    }

    @GetMapping
    public Object getValue(@RequestParam String key){
        return cashService.getCash(key);
    }
}
