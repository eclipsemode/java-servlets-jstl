package ru.daniel.servlets.service.impl;

import ru.daniel.servlets.exception.EmptyFieldException;
import ru.daniel.servlets.exception.UserIsAlreadyExistsException;
import ru.daniel.servlets.model.Account;
import ru.daniel.servlets.repository.AccountRepository;
import ru.daniel.servlets.service.AccountService;
import ru.daniel.servlets.util.ObjectFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.accountRepository = ObjectFactory.getInstance().create(AccountRepository.class);
    }

    @Override
    public Map<String, Account> allAccounts() {
        return accountRepository.allAccounts();
    }

    @Override
    public void saveAccount(String name, String password, double balance) throws UserIsAlreadyExistsException, EmptyFieldException {
        if (accountRepository.allAccounts().containsKey(name)) {
            throw new UserIsAlreadyExistsException("User already exists");
        }
        if (name.equals("") || password.equals("")) {
            throw new EmptyFieldException("Name and password cannot be empty");
        }

        Account newUser = new Account(name, password, balance);

        accountRepository.saveAccount(newUser);
    }
}
