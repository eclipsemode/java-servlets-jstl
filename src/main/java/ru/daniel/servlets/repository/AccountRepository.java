package ru.daniel.servlets.repository;

import ru.daniel.servlets.model.Account;

import java.util.Map;

public interface AccountRepository {
    Map<String, Account> allAccounts();
    void saveAccount(Account account);
}
