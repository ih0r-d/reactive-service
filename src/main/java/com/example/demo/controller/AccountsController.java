package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Currency;
import com.example.demo.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountsController {
    private final AccountRepository accountRepository;

    public AccountsController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/search/currency")
    public Flux<Account> findByCurrency(@RequestParam String currency) {
        return accountRepository.findByCurrency(Currency.fromValue(currency));
    }

    @GetMapping("/{id}")
    public Mono<Account> findById(@PathVariable String id) {
        return accountRepository.findById(id);
    }

    @PostMapping("/")
    public Mono<Account> createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @PostMapping("/batch")
    public Flux<Account> createAccount(@RequestBody Flux<Account> accounts) {
        return accountRepository.saveAll(accounts);
    }

    @GetMapping("/")
    public Flux<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


}
