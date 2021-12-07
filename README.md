# Problema ocorrido com a alteração do método updateConfig()

A primeira versão do código mostrado na videoaula, utilizando a seguinte lógica no método citado no título para instanciação do objeto singleton:
```sh
    @PUT
    public void updateConfig(Config newConfig){
        config.setFormatoRelatorios(newConfig.getFormatoRelatorios());
        config.setFormatoGraficos(newConfig.getFormatoGraficos());
    }
```
Fazia com que a cada requisição PUT em, independente de qual classe fosse passado o valor, seria inserido o mesmo objeto em ambas as classes. Se fosse alterado o valor ele também seria alterado em ambas as classes. Isso sendo o princípio fundamental do Padrão Singleton onde é criada apenas uma instância, no caso, da classe Config (gerenciada pelo CDI através da anotação @Inject) e utilizada a mesma em ambas as classes.

Já na segunda implementação:
```sh  
    @PUT
    public void updateConfig(Config newConfig){
        this.config = newConfig;
    }
```

O parâmetro newConfig não é gerenciado pelo CDI, apenas a instância config da classe Config que é, newConfig é um novo objeto Config que foi criado, não seguindo mais a estrutura e lógica do Singleton. Assim as requisições PUT não seriam mais de uma única instância nas duas classes, fazendo que a instanciação do objeto fosse feita em cada classe particularmente. Em consequência, isso faz com que as alterações não sejam simultâneas em ambas as classes. 
