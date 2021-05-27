package classes;
public class Componentes {
    private Integer idComponente;
    private String nomeComputador;
    private String tipoComponente;
    private Double minTempComponentes;
    private Double maxTempComponentes;
    private Integer fkComputador;

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public String getNomeComputador() {
        return nomeComputador;
    }

    public void setNomeComputador(String nomeComputador) {
        this.nomeComputador = nomeComputador;
    }

    public String getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(String tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    public Double getMinTempComponentes() {
        return minTempComponentes;
    }

    public void setMinTempComponentes(Double minTempComponentes) {
        this.minTempComponentes = minTempComponentes;
    }

    public Double getMaxTempComponentes() {
        return maxTempComponentes;
    }

    public void setMaxTempComponentes(Double maxTempComponentes) {
        this.maxTempComponentes = maxTempComponentes;
    }

    public Integer getFkComputador() {
        return fkComputador;
    }

    public void setFkComputador(Integer fkComputador) {
        this.fkComputador = fkComputador;
    }
    
}
