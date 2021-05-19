package org.hillel.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hillel.persistence.entity.util.YesNoConverter;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@MappedSuperclass
public abstract class AbstractModifyEntity<D extends Serializable> implements Persistable<D> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private D id;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "active")
    @Convert(converter = YesNoConverter.class)
    private boolean active = true;

    @Override
    public boolean isNew() {
//        return (boolean) (id = null);
        return id == null;
    }



}