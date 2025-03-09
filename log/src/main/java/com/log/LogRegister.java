package com.log;

/**
 *
 * @author lara_
 */
public class LogRegister {
    private String operacao;
    private String nome;
    private String usuario;
    boolean sucesso;
    private String mensagem;

    public LogRegister(String operacao, String nome, String usuario, boolean sucesso, String mensagem) {
        this.operacao = operacao;
        this.nome = nome;
        this.usuario = usuario;
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}