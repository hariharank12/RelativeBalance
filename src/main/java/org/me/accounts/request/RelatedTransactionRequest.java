package org.me.accounts.request;

import org.me.accounts.bean.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Created by hariharank12 on 15/09/19.
 */
public class RelatedTransactionRequest {
    private final List<Transaction> allTransactionsFromCSV;
    private final String accountId;
    private final Date fromDate;
    private final Date toDate;

    public RelatedTransactionRequest(List<Transaction> allTransactionsFromCSV, String accountId, Date fromDate, Date toDate) {
        this.allTransactionsFromCSV = allTransactionsFromCSV;
        this.accountId = accountId;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public List<Transaction> getAllTransactionsFromCSV() {
        return allTransactionsFromCSV;
    }

    public String getAccountId() {
        return accountId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }


}
