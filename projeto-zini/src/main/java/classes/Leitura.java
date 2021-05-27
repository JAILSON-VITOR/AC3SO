package classes;
public class Leitura {
    private Integer idComputador;
    private Double cpu;
    private Double memoria;
    private Double disco;
    private Double hora;
    private Double dia;
    private String nomeComputador;
    private String tipoSistemaOperacional;
    private String fabricanteSO;
    private String ultimaVerificacaoComponentes;
    private String tempoAtividade;
    private Integer fkEquipe;
    private Integer fkUsuario;

    public Integer getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(Integer idComputador) {
        this.idComputador = idComputador;
    }
    

    public String getUltimaVerificacaoComponentes() {
        return ultimaVerificacaoComponentes;
    }

    public void setUltimaVerificacaoComponentes(String ultimaVerificacaoComponentes) {
        this.ultimaVerificacaoComponentes = ultimaVerificacaoComponentes;
    }

    public String getTempoAtividade() {
        return tempoAtividade;
    }

    public void setTempoAtividade(String tempoAtividade) {
        this.tempoAtividade = tempoAtividade;
    }

    public Integer getFkEquipe() {
        return fkEquipe;
    }

    public void setFkEquipe(Integer fkEquipe) {
        this.fkEquipe = fkEquipe;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }
    
    

    public String getNomeComputador() {
        return nomeComputador;
    }

    public void setNomeComputador(String nomeComputador) {
        this.nomeComputador = nomeComputador;
    }

    public String getTipoSistemaOperacional() {
        return tipoSistemaOperacional;
    }

    public void setTipoSistemaOperacional(String tipoSistemaOperacional) {
        this.tipoSistemaOperacional = tipoSistemaOperacional;
    }

    public String getFabricanteSO() {
        return fabricanteSO;
    }

    public void setFabricanteSO(String fabricanteSO) {
        this.fabricanteSO = fabricanteSO;
    }

    public String getUltimaVerificacao() {
        return ultimaVerificacaoComponentes;
    }

    public void setUltimaVerificacao(String ultimaVerificacao) {
        this.ultimaVerificacaoComponentes = ultimaVerificacao;
    }

    
    
    public Double getHora() {
        return hora;
    }

    public void setHora(Double hora) {
        this.hora = hora;
    }

    public Double getDia() {
        return dia;
    }

    public void setDia(Double dia) {
        this.dia = dia;
    }
        

    public Double getCpu() {
        return cpu;
    }

    public void setCpu(Double cpu) {
        this.cpu = cpu;
    }

    public Double getMemoria() {
        return memoria;
    }

    public void setMemoria(Double memoria) {
        this.memoria = memoria;
    }

    public Double getDisco() {
        return disco;
    }

    public void setDisco(Double disco) {
        this.disco = disco;
    }
    
    
}
