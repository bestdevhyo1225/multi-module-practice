package org.company.xxx.member.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.company.xxx.JpaBasePersistable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@Getter
@Setter
@Entity
@Table(name = "Member")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@AttributeOverride(name = "id", column = @Column(name = "member_id"))
public class Member extends JpaBasePersistable {

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;
}
