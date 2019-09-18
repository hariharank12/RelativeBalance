package org.me.accounts.response;

import org.me.accounts.bean.Transaction;

import java.util.List;

/**
 * Created by hariharank12 on 15/09/19.
 */
public class RelatedTransactionResponse {
    private final List<Transaction> filteredTransactions;
    private final Double relativeBalance;

    public RelatedTransactionResponse(List<Transaction> filteredTransactions, Double relativeBalance) {
        this.filteredTransactions = filteredTransactions;
        this.relativeBalance = relativeBalance;
    }

    private List<Transaction> getFilteredTransactions() {
        return filteredTransactions;
    }

    public Double getRelativeBalance() {
        return relativeBalance;
    }

    public int getNumberOfTransactions() {
        return getFilteredTransactions().size();
    }

}
