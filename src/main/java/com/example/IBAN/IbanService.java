package com.example.IBAN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service
@Transactional
public class IbanService extends Throwable{

    private final IbanRepository ibanRepository;

    public static final int ibanMinSize = 15;
    public static final int ibanMaxSize = 34;
    public static final BigInteger IbanMagicNumber = new BigInteger("97");

    @Autowired
    public IbanService(IbanRepository ibanRepository) {

        this.ibanRepository = ibanRepository;
    }

    /**
     *
     * @return log of all the inserted IBAN numbers
     */
    public List<Iban> getIbans(){
        return ibanRepository.findAll();
    }

    /**
     *
     * @param iban as an object to insert and save in database
     *
     * Saves new IBAN to the database also calls ibanValidation()
     * to validate and set iban.setValid() to either 1 or 0
     *
     */

    public Iban addNewIban(Iban iban) {
        if(ibanValidation(iban.getIban())) {
            iban.setValid(1);
        }else{
            iban.setValid(0);
        }
        return ibanRepository.save(iban);
    }

    /**
     *
     * @param valid as an integer to pass to the @link
     * @return IBAN based on validity either valid or invalid
     */
    public List<Iban> getIbanByValid(Integer valid){
        return ibanRepository.findIbanByValid(valid);
    }

    /**
     *
     * @param id takes as the id for IBAN number
     */
    public void deleteIban(Long id){
        ibanRepository.deleteIbanById(id);
    }

    /**
     *
     * @param iban takes as a string to pass to ibanValidation method
     * @return if an IBAN number inserted is valid or not based on
     * international rules of IBAN
     */
    public boolean ibanValidation(String iban){

        // Remove any whitespace in the string
        String accountNumber = iban.trim();
        String noSpaceAccountNumber = "";
        for (int i = 0; i <accountNumber.length(); i++) {
            noSpaceAccountNumber = accountNumber.replaceAll(" ", "");
        }

        // Check the maximum and minimum length of the strength
        if(noSpaceAccountNumber.length() < ibanMinSize || noSpaceAccountNumber.length() > ibanMaxSize){
            return false;
        }


        // Move the first four characters to the end of the string i.e. 15 for Norway the minimum, 32 for Saint Lucia the maximum
        noSpaceAccountNumber = noSpaceAccountNumber.substring(4) + noSpaceAccountNumber.substring(0,4);

        // Replace each letter with two digits, where A = 10, B = 11 and Z = 35
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

        // Turn string into a decimal integer and check the remainder of division by 97
        BigInteger ibanNumber = new BigInteger(numericIbanNumber.toString());
        return ibanNumber.mod(IbanMagicNumber).intValue() == 1;
    }

}
