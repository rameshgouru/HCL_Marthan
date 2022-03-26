/**
 * Author       : Ramesh Gouru
 * Created date : 26/3/2022
 * Description  : Entity class for table order_details.
 */
package com.hcl.hackaton.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="order_details")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    @NotNull
    private String transactionType;
    @OneToOne(cascade = CascadeType.ALL)
    private Asset asset;
    @OneToOne(cascade = CascadeType.ALL)
    private Portfolio portfolio;
    @NotNull
    private Date orderDate;
    @NotNull
    private String orderStatus;
    @NotNull
    @Positive(message = "value must be positive")
    private Integer quantity;
    @Positive(message = "value must be positive")
    @NotNull
    private BigDecimal orderValue;
}