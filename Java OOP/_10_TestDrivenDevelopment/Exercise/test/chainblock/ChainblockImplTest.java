package exercise.chainblock;

import junit.framework.Assert.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImplTest {
    private Chainblock chainblock;
    private List<Transaction> transactions;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
        this.transactions = new ArrayList<>();
        addMultipleTransactions();
    }

    @Test
    public void testAdd_ShouldAddTransactionInTheChainBlock() {
        chainblock.add(transactions.get(0));
        assertEquals(1, chainblock.getCount());
        chainblock.add(transactions.get(1));
        assertEquals(2, chainblock.getCount());
    }

    @Test
    public void testAdd_ShouldNotAddExistingTransaction() {
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(0));
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testContains_ShouldReturnTrueIfContainsTransaction() {
        chainblock.add(transactions.get(0));
        assertTrue(chainblock.contains(transactions.get(0)));
    }

    @Test
    public void testContains_ShouldReturnFalseIfNotContainsTransaction() {
        assertFalse(chainblock.contains(transactions.get(0)));
    }

    @Test
    public void testContainsId_ShouldReturnTrueIfContainsTransactionWithId() {
        chainblock.add(transactions.get(0));
        assertTrue(chainblock.contains(1));
    }

    @Test
    public void testContainsId_ShouldReturnFalseIfNotContainsTransactionWithId() {
        assertFalse(chainblock.contains(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatus_ShouldThrowIfNoSuchTransaction() {
        chainblock.changeTransactionStatus(1, TransactionStatus.ABORTED);
    }

    @Test
    public void testChangeTransactionStatus_ShouldChangeTransactionStatus() {
        chainblock.add(transactions.get(0));
        chainblock.changeTransactionStatus(1, TransactionStatus.UNAUTHORIZED);

        assertEquals(TransactionStatus.UNAUTHORIZED, chainblock.getById(1).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionById_ShouldThrowIfNoSuchId() {
        testGetById_ShouldThrowIfNoSuchId();
    }

    @Test
    public void testRemoveTransactionById_ShouldRemoveTransactionWithGivenId() {
        chainblock.add(transactions.get(0));
        chainblock.removeTransactionById(1);
        assertEquals(0, chainblock.getCount());
    }

    @Test
    public void testGetById_ShouldReturnTransactionWhenIdExist() {
        chainblock.add(transactions.get(0));
        Transaction transaction = chainblock.getById(1);

        assertEquals(transactions.get(0), transaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetById_ShouldThrowIfNoSuchId() {
        chainblock.getById(1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetTransactionStatus_ShouldThrowIfNoSuchTransactionWithGivenStatus() {
        chainblock.add(transactions.get(0));
        chainblock.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetTransactionStatus_ShouldReturnTransactionsWithGivenStatusSortedByAmountInDescendingOrder() {
        Iterable<Transaction> expected = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        fillChainBlock(transactions);
        Iterable<Transaction> actual = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatus_ShouldThrowWhenNoSendersWithGivenTransactionStatus() {
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.add(transactions.get(2));
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatus_ShouldReturnListWithSendersNames() {
        Iterable<String> names = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        fillChainBlock(transactions);
        Iterable<String> actual = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(names, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatus_ShouldThrowWhenNoReceiversWithGivenTransactionStatus() {
        chainblock.add(transactions.get(0));
        chainblock.add(transactions.get(1));
        chainblock.add(transactions.get(2));
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatus_ShouldReturnListWithReceiversNames() {
        Iterable<String> names = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        fillChainBlock(transactions);
        Iterable<String> actual = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(names, actual);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenById_ShouldReturnTransactionsSorted() {
        Iterable<Transaction> expected = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());
        fillChainBlock(transactions);
        Iterable<Transaction> actual = chainblock.getAllOrderedByAmountDescendingThenById();

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescending_ShouldThrowIfNoSuchTransaction() {
        fillChainBlock(transactions);
        chainblock.getBySenderOrderedByAmountDescending("Pesho");
    }

    @Test
    public void testGetBySenderOrderedByAmountDescending_ShouldReturnTransactionsWithGivenSenderSortedByAmountDescending() {
        Iterable<Transaction> expected = transactions.stream()
                .filter(t -> t.getFrom().equals("Pav"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        fillChainBlock(transactions);
        Iterable<Transaction> actual = chainblock.getBySenderOrderedByAmountDescending("Pav");

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenById_ShouldThrowIfNoSuchTransaction() {
        fillChainBlock(transactions);
        chainblock.getByReceiverOrderedByAmountThenById("Gosho");
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenById_ShouldReturnTransactionsWithGivenReceiversSortedByAmountDescending() {
        Iterable<Transaction> expected = transactions.stream()
                .filter(t -> t.getTo().equals("Pav"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        fillChainBlock(transactions);
        Iterable<Transaction> actual = chainblock.getByReceiverOrderedByAmountThenById("Pav");

        assertEquals(expected, actual);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmount_ShouldReturnEmptyCollectionIfThereIsNoSuchTransaction() {
        double amount = 2.00;
        List<Transaction> collect = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .filter(t -> t.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        assertEquals(0, collect.size());
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmount_ShouldReturnTransactionsWithGivenStatusAndAmountLessOrEqualToGiven() {
        double amount = 17.40;
        Iterable<Transaction> expected = transactions.stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .filter(t -> t.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        fillChainBlock(transactions);
        Iterable<Transaction> actual = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, amount);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescending_ShouldThrowWhenNoSuchTransaction() {
        String sender = "Ivan";
        double amount = 17.40;

        fillChainBlock(transactions);

        chainblock.getBySenderAndMinimumAmountDescending(sender, amount);
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescending_ShouldReturnTransactionsWithGivenSenderAndAmountBiggerThanGiven() {
        String sender = "Pav";
        double amount = 12.40;
        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getFrom().equals(sender))
                .filter(t -> t.getAmount() > amount)
                .collect(Collectors.toList());

        fillChainBlock(transactions);
        Iterable<Transaction> actual = chainblock.getBySenderAndMinimumAmountDescending(sender, amount);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRange_ShouldThrowWhenNoSuchTransaction() {
        String receiver = "Ivan";
        double lo = 5.00;
        double hi = 15.20;

        chainblock.getByReceiverAndAmountRange(receiver, lo, hi);
    }

    @Test
    public void testGetByReceiverAndAmountRange_ShouldReturnAllTransactionsWithGivenReceiverAndRangeAmount() {
        String receiver = "Di";
        double lo = 5.00;
        double hi = 15.20;
        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getTo().equals(receiver))
                .filter(t -> t.getAmount() >= lo && t.getAmount() < hi)
                .collect(Collectors.toList());
        fillChainBlock(transactions);
        Iterable<Transaction> actual = chainblock.getByReceiverAndAmountRange(receiver, lo, hi);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllInAmountRange_ShouldReturnEmptyCollectionIfNoSuchTransactionsInTheGivenRange() {
        double lo = 100.00;
        double hi = 150.00;

        chainblock.getAllInAmountRange(lo, hi);
    }

    @Test
    public void testGetAllInAmountRange_ShouldReturnAllTransactionsInTheGivenRange() {
        double lo = 7.00;
        double hi = 22.00;
        List<Transaction> expected = transactions.stream()
                .filter(t -> t.getAmount() >= lo && t.getAmount() <= hi)
                .collect(Collectors.toList());

        fillChainBlock(transactions);

        Iterable<Transaction> actual = chainblock.getAllInAmountRange(lo, hi);

        assertEquals(expected, actual);
    }

    private void fillChainBlock(List<Transaction> transactions) {
        transactions.forEach(chainblock::add);
    }

    private void addMultipleTransactions() {
        List<Transaction> transactionsList = List.of(
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pav", "Di", 10.00),
                new TransactionImpl(2, TransactionStatus.ABORTED, "Pav", "Bibi", 15.20),
                new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Bibi", "Di", 20.00),
                new TransactionImpl(4, TransactionStatus.UNAUTHORIZED, "Di", "Bibi", 22.00),
                new TransactionImpl(5, TransactionStatus.UNAUTHORIZED, "Bibi", "Pav", 10.50),
                new TransactionImpl(6, TransactionStatus.FAILED, "Dam", "Di", 17.40),
                new TransactionImpl(7, TransactionStatus.FAILED, "Pav", "Dam", 10.00),
                new TransactionImpl(8, TransactionStatus.ABORTED, "Dam", "Bibi", 3.00),
                new TransactionImpl(9, TransactionStatus.SUCCESSFUL, "Pav", "Di", 7.00)
        );

        transactions.addAll(transactionsList);
    }
}