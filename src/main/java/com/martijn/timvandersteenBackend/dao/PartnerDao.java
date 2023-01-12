package com.martijn.timvandersteenBackend.dao;

import com.martijn.timvandersteenBackend.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerDao extends JpaRepository<Partner, Integer> {

}
