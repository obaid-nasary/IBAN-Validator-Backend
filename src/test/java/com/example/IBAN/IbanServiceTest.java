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

    @BeforeEach
    void setUp(){
        toTest = new IbanService(ibanRepository);
    }

    @Test
    void canGetIbans() {
        // when
        toTest.getIbans();

        // then
        verify(ibanRepository).findAll();
    }

    @Test
    void addNewIban() {
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

    @Test
    void checkInvalidIbanNumber() {
        String ibanNumber = "LT47 2123 5609 6090";

        toTest.ibanValidation(ibanNumber);

        boolean check = toTest.ibanValidation(ibanNumber);

        assertThat(check).isEqualTo(false);
    }

    @Test
    void checkValidIbanNumber() {
        String ibanNumber = "LT96 3250 0471 7948 3700";

        toTest.ibanValidation(ibanNumber);

        boolean check = toTest.ibanValidation(ibanNumber);

        assertThat(check).isEqualTo(true);
    }
}