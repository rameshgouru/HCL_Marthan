/**
 * Author       : Ramesh Gouru
 * Created date : 26/3/2022
 * Description  : Entity class for table assest_details.
 */
package com.hcl.hackaton.models;


import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Entity
@Table(name = "asset_details")
public class Asset {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String securityName;
    @Positive(message = "value must be positive")
    private Integer availableQuantity;
    @NotNull
    private String description;
    @NotNull
    @Positive(message = "value must be positive")
    private Integer unitPrice;
    @NotNull
    private Date lastUpdatedPriceDate;
}