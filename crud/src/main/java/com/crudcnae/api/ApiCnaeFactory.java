package com.crudcnae.api;

public class ApiCnaeFactory {

    public ApiCnaeStrategy criarEstrategia(String tipoConsulta) {
        switch (tipoConsulta.toLowerCase()) {
            case "classe": return new ApiCnaeClasseStrategy();
            case "grupo": return new ApiCnaeGrupoStrategy();
            case "divisao": return new ApiCnaeDivisaoStrategy();
            case "secao": return new ApiCnaeSecaoStrategy();
            default: return new ApiCnaeSubclasseStrategy();
        }
    }

    /**
     * Deduz o tipo de estratégia com base na entrada do usuário.
     * Ex: "G" -> secao, "47" -> divisao, "471" -> grupo, "47116" -> classe, "4711301" -> subclasse
     */
    public String detectarTipo(String entrada) {
        if (entrada == null || entrada.isEmpty()) return "subclasse";

        entrada = entrada.trim().toUpperCase();

        if (entrada.matches("^[A-Z]$")) return "secao";
        if (entrada.matches("^\\d{2}$")) return "divisao";
        if (entrada.matches("^\\d{3}$")) return "grupo";
        if (entrada.matches("^\\d{5}$")) return "classe";
        if (entrada.matches("^\\d{7}$")) return "subclasse";

        return "subclasse"; // fallback
    }
}
