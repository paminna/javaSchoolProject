package com.example.server.service;

import com.example.server.dto.AccountDto;
import com.example.server.entity.Account;
import com.example.server.repository.AccountRepository;
import com.example.server.utils.Currency;
import com.example.server.utils.JpaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.server.utils.CurrencyEnum.EURO;
import static com.example.server.utils.CurrencyEnum.RUBLE;
import static com.example.server.utils.CurrencyEnum.DOLLAR;

@Service
public class AccountServiceImpl extends JpaService<Account, Integer, AccountRepository, AccountDto> implements AccountService {

    @Autowired
    ModelMapper modelMapper;

    protected AccountServiceImpl() {
        super(AccountRepository.class, Account.class, AccountDto.class);
    }

    @Override
    public AccountDto toDto(Account account) {
        AccountDto accountDto = modelMapper.map(account, AccountDto.class);
        return accountDto;
    }

    @Override
    public List<AccountDto> findAccountsByPersonId(Integer personId) {
        return getDao().findAccountsByPersonId(personId).stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<AccountDto> findAllAccounts() {
        return getDao().findAll().stream().map(this::toDto).collect(Collectors.toList());
    }


    @Override
    public Optional<AccountDto> findAccountsByPerson_IdAndType(Integer id, String type){
        return getDao().findAccountsByPerson_IdAndType(id, type).map(this::toDto);
    }

    public void convert(String from, String to, Integer personId){
        AccountDto convertFrom = this.findAccountsByPerson_IdAndType(personId, from).isPresent()
                ? this.findAccountsByPerson_IdAndType(personId, from).get() : null;
        AccountDto convertTo = this.findAccountsByPerson_IdAndType(personId, from).isPresent()
                ? this.findAccountsByPerson_IdAndType(personId, to).get() : null;
        Map<String, BigDecimal> currency = new HashMap<>();
        currency.put("euro", new BigDecimal(90.0));
        currency.put("dollar", new BigDecimal(80.0));
        if (convertTo.getType().equals(Currency.DOLLAR)){
            convertFrom.setBalance(convertFrom.getBalance().divide(currency.get("dollar")));
            this.save(modelMapper.map(convertFrom, Account.class));
        } else if (convertTo.getType().equals(Currency.EURO)){
            convertFrom.setBalance(convertFrom.getBalance().divide(currency.get("euro")));
            this.save(modelMapper.map(convertFrom, Account.class));
        }
    }
}
