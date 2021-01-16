package com.training.springboot.controller;

import com.training.springboot.dao.PortfolioDAO;
import com.training.springboot.model.PortfolioModel;
import com.training.springboot.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    PortfolioDAO portfolioDAO;

    @Autowired
    SequenceGeneratorService seqGeneratorService;

    @PostMapping("/create")
    public PortfolioModel create(@RequestBody PortfolioModel newPortfolioObject) {
        newPortfolioObject.setId(seqGeneratorService.generateSequence(PortfolioModel.SEQUENCE_NAME));
        return portfolioDAO.save(newPortfolioObject);
    }

    @GetMapping("/read")
    public List<PortfolioModel> read(){
        return portfolioDAO.findAll();
    }

    @GetMapping("/read/{id}")
    public PortfolioModel read(@PathVariable Long id) {
        Optional<PortfolioModel> portfolioObj = portfolioDAO.findById(id);
        if(portfolioObj.isPresent()) {
            return portfolioObj.get();
        }else {
            throw new RuntimeException("Portfolio not found with id "+id);
        }
    }

    @PutMapping("/update")
    public PortfolioModel update(@RequestBody PortfolioModel modifiedPortfolioObject) {
        return portfolioDAO.save(modifiedPortfolioObject);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Optional<PortfolioModel> portfolioObj = portfolioDAO.findById(id);
        if(portfolioObj.isPresent()) {
            portfolioDAO.delete(portfolioObj.get());
            return "Portfolio deleted with id "+id;
        }else {
            throw new RuntimeException("Portfolio not found for id "+id);
        }
    }

}
