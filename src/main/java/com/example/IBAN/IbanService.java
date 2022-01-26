package com.example.IBAN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IbanService {

    private final IbanRepository ibanRepository;

    @Autowired
    public IbanService(IbanRepository ibanRepository) {
        this.ibanRepository = ibanRepository;
    }

    public List<Iban> getIbans(){
        return ibanRepository.findAll();
    }

    public void addNewIban(Iban iban){

        char beginsWithAZ = iban.getIban().charAt(0);
        if (beginsWithAZ >= 'A' && beginsWithAZ <= 'Z') {
            iban.setValid(1L);
            ibanRepository.save(iban);
        }else{
            iban.setValid(0L);
            ibanRepository.save(iban);
        }
    }


    public List<Iban> getIban(Long valid){
        return ibanRepository.findIbanByValid(valid);
    }
}
