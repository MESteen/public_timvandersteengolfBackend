package com.martijn.timvandersteenBackend.dao;

import com.martijn.timvandersteenBackend.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachDao extends JpaRepository<Coach, Integer> {
}
