package com.example.IBAN;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class IbanServiceTest {

    @Mock
    private IbanRepository ibanRepository;
    private IbanService toTest;

    /**
     * @BeforeEach is used to signal that the annotated method should be executed before each invocation of @Test
     */
    @BeforeEach
    void setUp(){
        toTest = new IbanService(ibanRepository);
    }

    /**
     * Tests if all the IBAN numbers log prints
     */
    @Test
    void canGetAllIbans() {
        // when
        toTest.getIbans();

        // then
        verify(ibanRepository).findAll();
    }

    /**
     * Tests if adding new is successful
     */
    @Test
    void addsNewIban() {
        // given
        Iban iban = new Iban(
                "LT47 2123 5609 6090"
        );
        // when
        toTest.addNewIban(iban);

        // then
        ArgumentCaptor<Iban> ibanArgumentCaptor = ArgumentCaptor.forClass(Iban.class);

        verify(ibanRepository).save(ibanArgumentCaptor.capture());

        Iban capturedIban = ibanArgumentCaptor.getValue();

        assertThat(capturedIban).isEqualTo(iban);
    }

    /**
     * Tests if the entered IBAN number is invalid
     */

    @Test
    void checksInvalidIbanNumber() {

        // given
        String invalidIbanNumber = "LT47 2123 5609 6090";

        // when
        toTest.ibanValidation(invalidIbanNumber);

        // then
        boolean check = toTest.ibanValidation(invalidIbanNumber);
        assertThat(check).isEqualTo(false);
    }

    /**
     * Tests if entered IBAN number is valid
     */
    @Test
    void checksValidIbanNumber() {

        // given
        String validIbanNumber = "NL02 ABNA 0123 4567 89";

        // when
        toTest.ibanValidation(validIbanNumber);

        // then
        boolean check = toTest.ibanValidation(validIbanNumber);
        assertThat(check).isEqualTo(true);
    }
}