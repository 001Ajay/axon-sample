package com.cts.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.dto.QuotationDTO;

@Repository("springManagedQuotationRepository")
public interface QuotationRepository extends JpaRepository<QuotationDTO, String> {

}
