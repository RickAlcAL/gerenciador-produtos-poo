package Entities.Enums;

public enum Avisos {
    CONCEDIDO("» [SUCESSO] Produto cadastrado e salvo no sistema!"),
    AGUARDE("» [PROCESSANDO] Inicializando o sistema de cadastro, por favor aguarde..."),
    ERRO("» [ERRO] Operação inválida! Verifique os dados digitados e tente novamente.");

    // encapsulando atributado para o construtor
    private final String msgFinal;

    // Construtor do Enum
    Avisos(String msgFinal) {
        this.msgFinal = msgFinal;
    }

    // Getter para recuperar a mensagem no Menu
    public String getMsgFinal() {
        return msgFinal;
    }
}