package com.example.server.service;

import com.example.server.dto.AccountDto;
import com.example.server.entity.Account;
import com.example.server.repository.AccountRepository;
import com.example.server.utils.JpaService;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Сервис для работы с аккаунтом
 */
@Log
@Service
public class AccountServiceImpl extends JpaService<Account, Integer, AccountRepository, AccountDto> implements AccountService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PersonServiceImpl personService;

    protected AccountServiceImpl() {
        super(AccountRepository.class, Account.class, AccountDto.class);
    }

    /**
     * конвертация entity в dto
     * @param account
     * @return
     */
    @Override
    public AccountDto toDto(Account account) {
        AccountDto accountDto = modelMapper.map(account, AccountDto.class);
        return accountDto;
    }

    /**
     * возвращает список аккаунтов по определенному человеку
     * @param personId
     * @return
     */
    @Override
    public List<AccountDto> findAccountsByPersonId(Integer personId) {
        return getDao().findAccountsByPersonId(personId).stream().map(this::toDto).collect(Collectors.toList());
    }

    /**
     * возвращает все аккаунты из базы данных
     * @return
     */
    @Override
    public List<AccountDto> findAllAccounts() {
        return getDao().findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    /**
     * возвращает аккаунт для определнного человека и валюты
     * @param id
     * @param type
     * @return
     */
    @Override
    public Optional<AccountDto> findAccountByPerson_IdAndType(Integer id, String type) {
        return getDao().findAccountByPerson_IdAndType(id, type).map(this::toDto);
    }

    /**
     * конвертация рублей в евро/доллары, сохранение в базу данных
     * @param from
     * @param to
     * @param personId
     * @return
     */
    @Override
    public String convert(String from, String to, Integer personId) {
        AccountDto convertFrom = this.findAccountByPerson_IdAndType(personId, from).isPresent()
                ? this.findAccountByPerson_IdAndType(personId, from).get() : null;
        convertFrom.setPersonDto(personService.findPersonById(personId).get());
        AccountDto convertTo = this.findAccountByPerson_IdAndType(personId, to).isPresent()
                ? this.findAccountByPerson_IdAndType(personId, to).get() : null;
        convertTo.setPersonDto(personService.findPersonById(personId).get());
        BigDecimal tmpTo = convertTo.getBalance();
        Map<String, BigDecimal> currency = new HashMap<>();
        currency.put("euro", new BigDecimal(90.0));
        currency.put("dollar", new BigDecimal(80.0));
        if (convertTo.getType().equals("dollar")) {
            convertTo.setBalance(tmpTo.add(convertFrom.getBalance().divide(currency.get("dollar"),
                    2, RoundingMode.HALF_UP)));
        } else if (convertTo.getType().equals("euro")) {
            convertTo.setBalance(tmpTo.add(convertFrom.getBalance().divide(currency.get("euro"),
                    2, RoundingMode.HALF_UP)));
        }
        convertFrom.setBalance(new BigDecimal(0));
        this.save(modelMapper.map(convertFrom, Account.class));
        this.save(modelMapper.map(convertTo, Account.class));
        return "converted result " + convertTo.getBalance().toString();
    }

    /**
     * возвращает аккаунт для залогиневшегося человека
     * @param login
     * @param password
     * @return
     */
    @Override
    public List<AccountDto> getAccountByLogin(String login, String password) {
        Integer personId = personService.findPersonByLoginAndPassword(login, password).isPresent() ?
                personService.findPersonByLoginAndPassword(login, password).get().getId() : null;
        if (personId != null) {
            List<AccountDto> accounts = this.findAccountsByPersonId(personId);
            if (accounts != null)
                return accounts;
            log.info("No accounts found by person id " + personId.toString());
        }
        log.info("No such person");
        return null;
    }
}
