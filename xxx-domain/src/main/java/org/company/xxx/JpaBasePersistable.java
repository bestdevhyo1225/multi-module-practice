package org.company.xxx;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;import javax.sound.sampled.AudioFileFormat;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = "id", callSuper = false)
@Getter
public abstract class JpaBasePersistable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "deleted", nullable = false, columnDefinition = "BIT default 0")
    protected Boolean deleted = false;

    public void delete() {
        deleted = true;
    }
}
