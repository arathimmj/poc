package com.ibm.report.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.report.report.domain.Details;

@Repository
public interface DetailRepository extends JpaRepository<Details, String> {

}
