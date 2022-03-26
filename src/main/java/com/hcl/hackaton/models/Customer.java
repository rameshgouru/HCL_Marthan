/**
 * Author       : Ramesh Gouru
 * Created date : 26/3/2022
 * Description  : Entity class for table assest_details.
 */

package com.hcl.hackaton.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="customers")
public class Customer {

    @Id
    private Long customerId;
    private String firstName;
    private String lastName;
}
