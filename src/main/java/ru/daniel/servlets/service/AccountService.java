package ru.daniel.servlets.service;

import ru.daniel.servlets.exception.EmptyFieldException;
import ru.daniel.servlets.exception.UserIsAlreadyExistsException;
import ru.daniel.servlets.model.Account;

import java.util.Map;

public interface AccountService {
    Map<String, Account> allAccounts();
    void saveAccount(String name, String password, double balance) throws UserIsAlreadyExistsException, EmptyFieldException;
}
