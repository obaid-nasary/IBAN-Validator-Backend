package com.example.IBAN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class IbanService {

    private final IbanRepository ibanRepository;

    public static final int ibanMinSize = 15;
    public static final int ibanMaxSize = 34;
    public static final BigInteger IbanMagicNumber = new BigInteger("97");

    @Autowired
    public IbanService(IbanRepository ibanRepository) {

        this.ibanRepository = ibanRepository;
    }

    public List<Iban> getIbans(){

        return ibanRepository.findAll();
    }

    public Iban addNewIban(Iban iban){
        if (ibanValidation(iban.getIban())) {
            iban.setValid(1);
            return ibanRepository.save(iban);
        }else{
            iban.setValid(0);
            return ibanRepository.save(iban);
        }
    }


    public List<Iban> getIban(Integer valid){
        return ibanRepository.findIbanByValid(valid);
    }

    public static boolean ibanValidation(String iban){

        String accountNumber = iban.trim();

        String noSpaceAccountNumber = "";
        for (int i = 0; i <accountNumber.length(); i++) {
            noSpaceAccountNumber = accountNumber.replaceAll(" ", "");
        }

        if(noSpaceAccountNumber.length() < ibanMinSize || noSpaceAccountNumber.length() > ibanMaxSize){
            return false;
        }

        noSpaceAccountNumber = noSpaceAccountNumber.substring(4) + noSpaceAccountNumber.substring(0,4);

        StringBuilder numericIbanNumber = new StringBuilder();
        int numericValue;
        for (int i = 0; i < noSpaceAccountNumber.length(); i++) {
            numericValue = Character.getNumericValue(noSpaceAccountNumber.charAt(i));
            if(-1 >= numericValue){
                return false;
            }else{
                numericIbanNumber.append(numericValue);

            }

        }
        BigInteger ibanNumber = new BigInteger(numericIbanNumber.toString());
//        System.out.printf(String.valueOf(ibanNumber.mod(IbanMagicNumber).intValue() == 1));
        return ibanNumber.mod(IbanMagicNumber).intValue() == 1;
    }

}
