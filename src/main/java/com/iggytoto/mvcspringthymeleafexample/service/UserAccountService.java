package com.iggytoto.mvcspringthymeleafexample.service;

import com.iggytoto.mvcspringthymeleafexample.model.Account;
import com.iggytoto.mvcspringthymeleafexample.model.UserAccount;
import com.iggytoto.mvcspringthymeleafexample.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService implements UserDetailsService {

    @Autowired
    AccountRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new UserAccount(userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with given email not found")));
    }

    public Account registerNewUser(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return userRepository.save(account);
    }
}
