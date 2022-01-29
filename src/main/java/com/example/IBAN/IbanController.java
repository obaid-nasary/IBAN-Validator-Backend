package com.example.IBAN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IbanController {



    private final IbanService ibanService;

    @Autowired
    public IbanController(IbanService ibanService) {
        this.ibanService = ibanService;

    }

    /**
     *
     * @return
     */

    @GetMapping("/iban")
    public List<Iban> getIbans(){

        return ibanService.getIbans();
    }

    /**
     *
     * @param newIban
     */

    @PostMapping("/iban/")
    public void addIban(@RequestBody Iban newIban){

        ibanService.addNewIban(newIban);
    }

    /**
     *
     * @param valid
     * @return
     */

    @GetMapping("/iban/{valid}/")
    public List<Iban> getSingleIban(@PathVariable("valid") Integer valid){

        return ibanService.getIban(valid);
    }











    //    @GetMapping("/iban/{ibanNumber}")
//    public EntityModel<?> singleIban(@PathVariable Iban ibanNumber) throws Exception {
//
//        Optional<Iban> ibanOptional = ibanRepository.findIbanByIban(ibanNumber.getIban());
//            if(ibanOptional.equals("1")){
//                throw new Exception("Iban is valid");
//            }
//
//            return
//
//        //Staff staff = staffRepository.findById(staffId).orElseThrow(() -> new IllegalStateException("Employee with " + staffId + " ID does not exist"));
//
//
//        Boolean iban = ibanRepository.findBy(valid).orElseThrow(()-> new IllegalStateException("Invalid IBAN"))
//
//                if(!iban.isValid()){
//                    throw new IllegalStateException("IBAN is invalid");
//                }
//
//                return assembler.toModel(iban);
//    }



//    @GetMapping("/iban/")
//    List<Iban> allIbans(){
//        return ibanRepository.findAll();
//    }


}
