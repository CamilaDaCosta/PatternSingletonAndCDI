# Problema ocorrido com a alteração do método updateConfig()

A primeira versão do código mostrado na videoaula, utilizando a seguinte lógica no método citado para instanciação do objeto singleton:
```sh
    @PUT
    public void updateConfig(Config newConfig){
        config.setFormatoRelatorios(newConfig.getFormatoRelatorios());
        config.setFormatoGraficos(newConfig.getFormatoGraficos());
    }
```
Fazia com que a cada requisição PUT em, independente de qual classe fosse passado o valor, fosse inserido o mesmo objeto em ambas as classes. Se fosse alterado o valor ele seria alterado em ambas as classes. Isso sendo o princípio fundamental do Padrão Singleton onde é criada apenas uma instancia, no caso, da classe Config (gerênciada pelo CDI) e utilizada a mesma em ambas as classes.

Já na segunda implementação:
```sh  
    @PUT
    public void updateConfig(Config newConfig){
        this.config = newConfig;
    }
```

O parâmetro newConfig não era mais gerenciado pelo CDI, e sim um novo objeto Config criado, não sendo mais a estrutura e lógica do Singleton. Assim as requisições PUT não seriam mais únicas nas duas classes, fazendo que a instanciação do objeto fosse feita em cada classe particularmente. 
