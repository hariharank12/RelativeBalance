package org.me.accounts.bean;

import java.util.Date;

/**
 * Created by hariharank12 on 15/09/19.
 */
public class Transaction {
    private String transactionId;
    private String fromAccountId;
    private String toAccountId;
    private Date createdDate;
    private Double amount;
    private PaymentType paymentType;
    private String relatedTransactionId;

    public Transaction(String transactionId, String fromAccountId, String toAccountId, Date createdDate,
                       Double amount, PaymentType paymentType, String relatedTransactionId) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentType = paymentType;
        this.relatedTransactionId = relatedTransactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Double getAmount() {
        return amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public String getRelatedTransactionId() {
        return relatedTransactionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;

        Transaction that = (Transaction) o;

        if (!fromAccountId.equals(that.fromAccountId)) return false;
        if (!toAccountId.equals(that.toAccountId)) return false;
        if (!amount.equals(that.amount)) return false;
        boolean equalityStatus = relatedTransactionId != null && relatedTransactionId.equals(that.transactionId) &&
                paymentType.name().equals("REVERSAL") ||
                relatedTransactionId == null && transactionId.equals(that.relatedTransactionId) && that.paymentType.name().equals("REVERSAL");

        if (equalityStatus) {
            if (this.relatedTransactionId == null) {
                this.relatedTransactionId = "D";
            }

            if (that.relatedTransactionId == null) {
                that.relatedTransactionId = "D";
            }
        }

        return equalityStatus;


    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + fromAccountId.hashCode();
        result = 31 * result + toAccountId.hashCode();
        result = 31 * result + amount.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", fromAccountId='" + fromAccountId + '\'' +
                ", toAccountId='" + toAccountId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", amount='" + amount + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", relatedTransactionId='" + relatedTransactionId + '\'' +
                '}';
    }

}
