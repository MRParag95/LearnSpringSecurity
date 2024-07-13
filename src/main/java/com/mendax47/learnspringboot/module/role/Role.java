package com.mendax47.learnspringboot.module.role;

import com.mendax47.learnspringboot.module.base.BaseEntity;
import com.mendax47.learnspringboot.module.role.enums.RoleType;
import com.mendax47.learnspringboot.module.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.proxy.HibernateProxy;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@SQLRestriction( "is_active = TRUE" )
@SQLDelete( sql = "UPDATE _user SET is_active = TRUE WHERE id = ?" )
@Entity
public class Role extends BaseEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Enumerated( EnumType.STRING )
    @Column( nullable = false )
    private RoleType roleType = RoleType.USER;

    @ManyToMany(
            mappedBy = "roles",
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH }
    )
    private Set< User > users = new LinkedHashSet<>();

    @Override
    public final boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null ) return false;
        Class< ? > oEffectiveClass = o instanceof HibernateProxy ?
                ( ( HibernateProxy ) o ).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();
        Class< ? > thisEffectiveClass = this instanceof HibernateProxy ?
                ( ( HibernateProxy ) this ).getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();
        if ( thisEffectiveClass != oEffectiveClass ) return false;
        Role role = ( Role ) o;
        return getId() != null && Objects.equals( getId(), role.getId() );
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ?
                ( ( HibernateProxy ) this ).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}