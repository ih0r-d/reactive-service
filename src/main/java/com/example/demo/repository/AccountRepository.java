package com.example.demo.repository;

import com.example.demo.model.Account;
import com.example.demo.model.Currency;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account, String> {
    Flux<Account> findByCurrency(Currency currency);
}
