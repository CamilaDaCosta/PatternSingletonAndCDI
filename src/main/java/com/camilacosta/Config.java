package com.camilacosta;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author camila
 */

@ApplicationScoped //torna a classe em singleton - o objeto só é criado se for utilizado
public class Config {
    @ConfigProperty(name = "formatoRelatorios")
    private String formatoRelatorios = "pdf";
    
    @ConfigProperty(name = "formatoGraficos")
    private String formatoGraficos = "barras";

    public String getFormatoRelatorios() {
        return formatoRelatorios;
    }

    public void setFormatoRelatorios(String formatoRelatorios) {
        this.formatoRelatorios = formatoRelatorios;
    }

    public String getFormatoGraficos() {
        return formatoGraficos;
    }

    public void setFormatoGraficos(String formatoGraficos) {
        this.formatoGraficos = formatoGraficos;
    }
    
    
}
