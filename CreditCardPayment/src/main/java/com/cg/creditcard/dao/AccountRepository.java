package com.cg.creditcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.creditcard.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
@Query(value = " from Account account where account.account_id=?1")
public Account getAccountById(int account_id);
}
