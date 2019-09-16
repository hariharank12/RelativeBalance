package org.me.accounts.service;

import org.me.accounts.bean.PaymentType;
import org.me.accounts.bean.Transaction;
import org.me.accounts.request.RelatedTransactionRequest;
import org.me.accounts.response.RelatedTransactionResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by hariharank12 on 15/09/19.
 */
public class AccountService {

    public static List<Transaction> loadTransactions(String[][] transactionValues) {
        List<Transaction> transactions = new ArrayList<>();
        for (String[] row : transactionValues) {
            if (null != row[0]) {
                String transactionId = row[0].trim();
                String fromAccountId = row[1].trim();
                String toAccountId = row[2].trim();
                Date createdDate = null;
                Double amount = null;
                PaymentType paymentType = null;
                try {
                    createdDate = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss").parse(row[3].trim());
                    amount = Double.valueOf(row[4].trim());
                    paymentType = PaymentType.valueOf(row[5].trim());
                } catch (ParseException e) {
                    System.err.println(e.getMessage());
                }
                String relatedTransactionId = (row.length == 7 ? row[6].trim() : null);
                Transaction transaction = new Transaction(transactionId, fromAccountId, toAccountId, createdDate,
                        amount, paymentType, relatedTransactionId);
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    public static RelatedTransactionResponse findRelativeBalance(RelatedTransactionRequest relatedTransactionRequest) {
        Set<Transaction> transactions = new HashSet<>(relatedTransactionRequest.getAllTransactionsFromCSV());
        String accountId = relatedTransactionRequest.getAccountId();
        transactions.removeIf(t -> t.getRelatedTransactionId() != null && t.getRelatedTransactionId().length() > 0);
        List<Transaction> totalTransactionsForGivenAccount = transactions.stream().
                filter(t -> (t.getToAccountId().equals(accountId) || t.getFromAccountId().equals(accountId)) &&
                        (relatedTransactionRequest.getFromDate().compareTo(t.getCreatedDate())<=0 &&
                                relatedTransactionRequest.getToDate().compareTo(t.getCreatedDate())>=0) ).
                map(t -> t).collect(Collectors.toList());
        double totalCreditAmount = totalTransactionsForGivenAccount.stream().filter(t -> t.getToAccountId().equals(accountId)).
                map(t -> t.getAmount()).reduce(0.00, (e1, e2) -> e1 + e2);
        double totalDebitAmount = totalTransactionsForGivenAccount.stream().filter(t -> t.getFromAccountId().equals(accountId)).
                map(t -> t.getAmount()).reduce(0.00, (e1, e2) -> e1 + e2);
        double relativeBalance = totalCreditAmount - totalDebitAmount;
        return new RelatedTransactionResponse(totalTransactionsForGivenAccount, relativeBalance);
    }

}
