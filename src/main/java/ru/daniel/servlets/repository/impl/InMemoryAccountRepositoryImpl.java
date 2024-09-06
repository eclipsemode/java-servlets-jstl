package ru.daniel.servlets.repository.impl;

import ru.daniel.servlets.model.Account;
import ru.daniel.servlets.repository.AccountRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAccountRepositoryImpl implements AccountRepository {
    private final Map<String, Account> accountRepo;

    public InMemoryAccountRepositoryImpl() {
        accountRepo = new ConcurrentHashMap<>();
        loadAccInDB();
    }

    private void loadAccInDB() {

        Account user1 = new Account("user1", "password1", 532.20);
        Account user2 = new Account("user2", "password2", 348.28);
        Account user3 = new Account("user3", "password3", 870.60);

        accountRepo.put(user1.getName(), user1);
        accountRepo.put(user2.getName(), user2);
        accountRepo.put(user3.getName(), user3);
    }

    @Override
    public Map<String, Account> allAccounts() {
        return accountRepo;
    }

    @Override
    public void saveAccount(Account account) {
        accountRepo.put(account.getName(), account);
    }
}
