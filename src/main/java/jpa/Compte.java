package jpa;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@TableGenerator(name = "compte", table = "compteSpe", allocationSize = 1, initialValue = 1)
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "compte")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "solde", nullable = false)
    private Double solde;

    @ManyToMany(mappedBy = "comptes")
    private Set<Client> clients;
    public Compte() {}

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", solde=" + solde +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }
}
