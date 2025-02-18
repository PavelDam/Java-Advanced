package exercise.chainblock;

public interface Transaction {
    int getId();

    String getFrom();

    String getTo();

    double getAmount();

    TransactionStatus getStatus();

    void setStatus(TransactionStatus status);

}
