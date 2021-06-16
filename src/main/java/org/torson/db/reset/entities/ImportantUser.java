package org.torson.db.reset.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Table(schema = "DB1", name = "ImportantUsers")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportantUser {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;
}
