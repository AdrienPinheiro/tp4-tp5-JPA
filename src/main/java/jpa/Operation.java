package jpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@TableGenerator(name = "operation", table = "operationSpe", initialValue = 1, allocationSize = 1)
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "operation")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_compte")
    private Compte compte;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "montant", nullable = false)
    private Double montant;

    @Column(name = "motif", nullable = false)
    private String motif;

    public Operation() {
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", compte=" + compte +
                ", date=" + date +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
}
