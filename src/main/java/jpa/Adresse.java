package jpa;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
    private Integer numero;
    private String rue;
    private Integer codePostal;
    private String ville;
    public Adresse() {
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "numero=" + numero +
                ", rue='" + rue + '\'' +
                ", codePostal=" + codePostal +
                ", ville='" + ville + '\'' +
                '}';
    }

    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }

    public Integer getCodePostal() {
        return codePostal;
    }
    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
}
