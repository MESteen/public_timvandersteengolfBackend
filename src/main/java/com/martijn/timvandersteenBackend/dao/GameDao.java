package com.martijn.timvandersteenBackend.dao;

import com.martijn.timvandersteenBackend.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDao extends JpaRepository<Game, Integer> {
}
