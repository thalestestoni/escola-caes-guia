package hkeller.escolacaesguia.user.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil")
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    public Role(Long id) {
        this.id = id;
    }
}
