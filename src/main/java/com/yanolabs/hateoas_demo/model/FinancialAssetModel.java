package com.yanolabs.hateoas_demo.model;

import java.io.Serializable;
import java.sql.Timestamp;
import org.springframework.hateoas.RepresentationModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper=false)
@Getter
@Setter
@Entity
@Table(name = "FINANCIAL_ASSET")
public class FinancialAssetModel extends RepresentationModel<FinancialAssetModel> implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq_generator", sequenceName = "FINANCIAL_ASSET_SEQ", allocationSize=1, initialValue=11)
    @Column(name = "id")
    private int id;
    
    @NotBlank(message = "Name is required")
    @Column(name = "name")
    private String name;
    
    @NotNull(message = "Market value code is required")
    @Column(name = "marketvaluecode")
    private int marketValueCode;
    
    @NotBlank(message = "Type is required")
    @Column(name = "type")
    private String type;

    @NotNull(message = "Initial total offering quantity is required")
    @Column(name = "initialtotalofferingquantity")
    private long initialTotalOfferingQuantity;
    
    @NotNull(message = "Issue date is required")
    @Column(name = "issuedate")
    private Timestamp issueDate;
    
    @NotNull(message = "Maturity date is required")
    @Column(name = "maturitydate")
    private Timestamp maturityDate;
    
    @Column(name = "quantity")
    @NotNull(message = "Quantity is required")
    private long quantity;
}