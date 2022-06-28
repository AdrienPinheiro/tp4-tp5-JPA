package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class AssuranceVie extends Compte{
    @Column(name = "taux", nullable = false)
    private Double taux;

    @Column(name = "dateFin", nullable = false)
    private LocalDate dateFin;

    public AssuranceVie() {}

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
}
