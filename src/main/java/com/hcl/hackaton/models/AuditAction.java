/**
 * Author       : Ramesh Gouru 
 * Created date : 26/3/2022
 * Description  : Entity class for table audit_action.
 */

package com.hcl.hackaton.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="audit_action")
public class AuditAction {
    @Id
    @GeneratedValue
    private Long id;
    private String actionType;
    @OneToOne(cascade = CascadeType.ALL)
    private Portfolio portfolio;
    private Date actionTS;
    private String description;
    private Date lastUpdatedPriceDate;
}
