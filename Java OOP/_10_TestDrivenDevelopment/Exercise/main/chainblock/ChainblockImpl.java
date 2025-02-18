package exercise.chainblock;

import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> transactionMap;

    public ChainblockImpl() {
        this.transactionMap = new LinkedHashMap<>();
    }

    public int getCount() {
        return transactionMap.size();
    }

    public void add(Transaction transaction) {
        transactionMap.putIfAbsent(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return transactionMap.containsKey(transaction.getId());
    }

    public boolean contains(int id) {
        return transactionMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        checkId(id);
        Transaction transaction = transactionMap.get(id);
        transaction.setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        checkId(id);
        transactionMap.remove(id);
    }

    public Transaction getById(int id) {
        checkId(id);
        return transactionMap.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {

        List<Transaction> list = transactionMap.values().stream()
                .filter(t -> t.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        String message = "No such transaction with given status: " + status;
        throwException(list.size() == 0, message);

        return list;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> list = transactionMap.values().stream()
                .filter(t -> t.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        String message = "No such senders with given transaction status: " + status;
        throwException(list.size() == 0, message);

        return list;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> list = transactionMap.values().stream()
                .filter(t -> t.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        String message = "No such receivers with given transaction status: " + status;
        throwException(list.size() == 0, message);

        return list;
    }

    private static void throwException(boolean list, String message) {
        if (list) {
            throw new IllegalArgumentException(message);
        }
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactionMap.values().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> list = transactionMap.values().stream()
                .filter(t -> t.getFrom().equals(sender))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        String message = "No transaction with given sender: " + sender;
        throwException(list.size() == 0, message);
        return list;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> list = transactionMap.values().stream()
                .filter(t -> t.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        String message = "No transaction with given receiver: " + receiver;
        throwException(list.size() == 0, message);
        return list;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return transactionMap.values().stream()
                .filter(t -> t.getStatus().equals(status))
                .filter(t -> t.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> collect = transactionMap.values().stream()
                .filter(t -> t.getFrom().equals(sender))
                .filter(t -> t.getAmount() > amount)
                .collect(Collectors.toList());

        String message = "No such transaction with sender: " + sender + " and amount bigger than: " + amount;
        throwException(collect.size() == 0, message);

        return collect;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> collect = transactionMap.values().stream()
                .filter(t -> t.getTo().equals(receiver))
                .filter(t -> t.getAmount() >= lo && t.getAmount() < hi)
                .collect(Collectors.toList());

        String message = "No such transaction with receiver: " + receiver + " in given range from: " + lo + " to: " + hi;
        throwException(collect.size() == 0, message);

        return collect;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> collection = transactionMap.values().stream()
                .filter(t -> t.getAmount() >= lo && t.getAmount() <= hi)
                .collect(Collectors.toList());

        String message = "No such transaction between range: "+ lo + " to " + hi;

        throwException(collection.size() == 0, message);
        return collection;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }

    private void checkId(int id) {
        throwException(!transactionMap.containsKey(id), "No transaction with id: " + id);
    }
}
