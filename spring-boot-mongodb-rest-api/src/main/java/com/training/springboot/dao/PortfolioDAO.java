package com.training.springboot.dao;

import com.training.springboot.model.PortfolioModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioDAO extends MongoRepository<PortfolioModel, Long> {
}
