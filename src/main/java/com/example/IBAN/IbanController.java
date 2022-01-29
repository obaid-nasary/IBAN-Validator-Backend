package com.example.IBAN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IbanController {


    private final IbanService ibanService;

    @Autowired
    public IbanController(IbanService ibanService) {
        this.ibanService = ibanService;

    }

    /**
     * @return the log all of all inserted IBAN numbers
     */

    @GetMapping("/iban")
    public List<Iban> getIbans() {
        return ibanService.getIbans();
    }

    /**
     * @param newIban as an object to insert and save in database
     * @return a message to clarify if the IBAN is valid or not
     */

    @PostMapping("/iban/")
    public ResponseEntity addIban(@RequestBody Iban newIban) {
        ibanService.addNewIban(newIban);
        if (newIban.getValid() == 1){
            return new ResponseEntity("The IBAN is valid", HttpStatus.OK);
        }
        return new ResponseEntity("The IBAN is invalid", HttpStatus.OK);
    }

    /**
     * @param valid takes values as 1 for true/valid and 0 for false/invalid IBAN number and
     * @return the log of IBAN numbers based on parameter value
     */

    @GetMapping("/iban/{valid}")
    public List<Iban> getSingleIban(@PathVariable("valid") Integer valid) {
        return ibanService.getIban(valid);
    }

}
