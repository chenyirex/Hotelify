package com.ubc.cpsc304.hotelify.entity;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The entity class for Administrator
 * Created by Rex on 2018-11-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Administrator extends User {

}
