package com.daejja.backend.repository;

import com.daejja.backend.domain.TokenPair;
import com.daejja.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenPairRepository extends JpaRepository<TokenPair, Long> {

    Optional<TokenPair> findByUser(User user);
}
