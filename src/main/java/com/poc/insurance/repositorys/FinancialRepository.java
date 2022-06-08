package com.poc.insurance.repositorys;

import com.poc.insurance.models.Financial;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FinancialRepository extends CrudRepository<Financial, Integer> {

    List<Financial> findAll();

    Financial findByClientIdAndContractId(Integer idClient, Integer idContract);
}
