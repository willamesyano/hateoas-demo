package com.yanolabs.hateoas_demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.yanolabs.hateoas_demo.model.FinancialAssetModel;
import com.yanolabs.hateoas_demo.service.FinancialAssetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/financial-assets")
public class FinancialAssetController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    FinancialAssetService financialAssetService;

    @GetMapping
    public ResponseEntity<List<FinancialAssetModel>> listAll() {
        
        log.info("Getting list of financial assets.");
        List<FinancialAssetModel> financialAssetsList = financialAssetService.listAll();
        
        if(financialAssetsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            for(FinancialAssetModel financialAsset : financialAssetsList) {
                financialAsset.add(linkTo(methodOn(FinancialAssetController.class).findById(financialAsset.getId())).withSelfRel());
            }
            return new ResponseEntity<List<FinancialAssetModel>>(financialAssetsList, HttpStatus.OK);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FinancialAssetModel> findById(@PathVariable(value="id") int id) {
        
        try {
            log.info("Getting asset details.");
            
            Optional<FinancialAssetModel> financialAssetOp = financialAssetService.findById(id);
            
            if(!financialAssetOp.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else {
                financialAssetOp.get().add(linkTo(methodOn(FinancialAssetController.class).listAll()).withRel("Financial Assets List"));
                return new ResponseEntity<FinancialAssetModel>(financialAssetOp.get(), HttpStatus.OK);
            }
        } catch (Exception e) {
            if(e.getMessage().equals("Asset not found"))
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
            else
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    
    @PostMapping()
    public ResponseEntity<FinancialAssetModel> saveFinancialAsset(@RequestBody @Valid FinancialAssetModel financialAsset) {
        try {
            log.info("Saving financial asset");
            return new ResponseEntity<FinancialAssetModel>(financialAssetService.save(financialAsset), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<FinancialAssetModel> deleteFinancialAsset(@PathVariable(value="id") int id) throws Exception {
        log.info("Deleting financial asset");
        Optional<FinancialAssetModel> financialAssetOp = financialAssetService.findById(id);
        
        if(!financialAssetOp.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else {
            financialAssetService.delete(financialAssetOp.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FinancialAssetModel> updateFinancialAsset(@PathVariable(value="id") int id, @RequestBody @Valid FinancialAssetModel financialAssetModel) {
        
        try {
            log.info("Updating financial asset");
            Optional<FinancialAssetModel> financialAssetOp = financialAssetService.findById(id);
            
            if(!financialAssetOp.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else {
                financialAssetModel.setId(financialAssetOp.get().getId());
                return new ResponseEntity<FinancialAssetModel>(financialAssetService.save(financialAssetModel), HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}