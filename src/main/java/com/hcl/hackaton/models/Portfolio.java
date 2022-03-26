/**
 * Author       : Ramesh Gouru
 * Created date : 26/3/2022
 * Description  : Entity class for table portfolio_details.
 */

package com.hcl.hackaton.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="portfolio_details")
public class Portfolio {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;
}
