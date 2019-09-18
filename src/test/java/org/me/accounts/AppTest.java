package org.me.accounts;

import static org.me.accounts.util.DateUtil.getDate;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.me.accounts.bean.PaymentType;
import org.me.accounts.bean.Transaction;
import org.me.accounts.request.RelatedTransactionRequest;
import org.me.accounts.response.RelatedTransactionResponse;
import org.me.accounts.service.AccountService;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private RelatedTransactionRequest relatedTransactionRequest;

    @Before
    public void setUp() {
        Transaction transaction1 = new Transaction("Trx001", "A", "B", getDate("20/10/2018 12:00:00"), 25.00, PaymentType.PAYMENT, null);
        Transaction transaction2 = new Transaction("Trx002", "A", "C", getDate("20/10/2018 13:00:00"), 10.00, PaymentType.PAYMENT, null);
        Transaction transaction3 = new Transaction("Trx003", "A", "B", getDate("20/10/2018 14:00:00"), 25.00, PaymentType.REVERSAL, "Trx001");
        Transaction transaction4 = new Transaction("Trx004", "D", "A",  getDate("20/10/2018 15:00:00"), 50.50, PaymentType.PAYMENT, null);
        Transaction transaction5 = new Transaction("Trx005", "D", "A",  getDate("20/10/2018 16:30:00"), 70.00, PaymentType.PAYMENT, null);
        List<Transaction> transactions = new ArrayList<>(Arrays.asList(transaction1,
                transaction2, transaction3, transaction4, transaction5));
        relatedTransactionRequest =
                new RelatedTransactionRequest(transactions, "A", getDate("20/10/2018 12:00:00"), getDate("20/10/2018 15:00:00"));

    }
    @Test
    public void shouldAnswerWithTrue() {
        RelatedTransactionResponse relatedTransactionResponse = AccountService.
                findRelativeBalance(relatedTransactionRequest);
        double expectedRelativeBalance = 40.5;
        Assert.assertTrue(relatedTransactionResponse.getRelativeBalance() == expectedRelativeBalance);
        Assert.assertTrue(relatedTransactionResponse.getNumberOfTransactions() == 2);
    }

    @After
    public void tearDown() {
        relatedTransactionRequest = null;
    }

}
