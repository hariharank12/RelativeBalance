package org.me.accounts;

import org.me.accounts.bean.Transaction;
import org.me.accounts.io.InputTransactionsCSVReader;
import org.me.accounts.request.RelatedTransactionRequest;
import org.me.accounts.response.RelatedTransactionResponse;
import org.me.accounts.service.AccountService;
import org.me.accounts.util.DateUtil;

import java.util.List;

/**
 * Relative Balance App.
 *
 */
class App
{
    public static void main( String[] args ) {
        List<Transaction> transactions = AccountService.loadTransactions(new InputTransactionsCSVReader().
                readCSV());
        RelatedTransactionRequest relatedTransactionRequest =
                new RelatedTransactionRequest(transactions, args[0], DateUtil.getDate(args[1]), DateUtil.getDate(args[2]));
        RelatedTransactionResponse relatedTransactionResponse = AccountService.findRelativeBalance(relatedTransactionRequest);
        System.out.println("Relative Balance : " + relatedTransactionResponse.getRelativeBalance());
        System.out.println("Total Count : " + relatedTransactionResponse.getNumberOfTransactions());


    }
}
