package com.camilacosta;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/config")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConfigResouce {
    @Inject
    Config config;
    
    @GET
    public Config getConfig() {
        return config;
    }
    
    @PUT
    public void updateConfig(Config newConfig){
        this.config = newConfig;
        //config.setFormatoRelatorios(newConfig.getFormatoRelatorios());
        //config.setFormatoGraficos(newConfig.getFormatoGraficos());
    }
}