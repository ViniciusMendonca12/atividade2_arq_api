package application.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogos")
public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String plataforma;

    @Column(nullable = false)
    private Boolean gostei;

    @Column(nullable = false)
    private Boolean zerado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Boolean getGostei() {
        return gostei;
    }

    public void setGostei(Boolean gostei) {
        this.gostei = gostei;
    }

    public Boolean getZerado() {
        return zerado;
    }

    public void setZerado(Boolean zerado) {
        this.zerado = zerado;
    }

}
