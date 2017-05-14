# Cordova Plugin Trialtime

Plugin para pegar a data de instalação verificar com o parâmetro de entrada do tempo desejado que deseja verificar,
quantos dias restam de tempo de utilização baseado na quantidade de dias utilizados desde a instalação do aplicativo em seu aparelho Android, com base da captura de data de instalação do aplicativo via Java.

## Como utilizar

Crie um novo projeto Cordova em seu diretório padrão:

    $ cordova create trialtime br.com.trialtime Trialtime
    
Instalação:

    $ cordova plugin add https://github.com/CesarBalzer/cordova-plugin-trialtime.git
    
Preparando o plugin para utilização:

    $ cordova plugin prepare

Edite seu arquivo `www/js/index.js` e adicione o seguinte código para pegar a data de instalação, depois da função de chamada `app.initialize()`

```js
document.getElementById("getDateTime").addEventListener("click", getTrialTime);
    function getTrialTime() {
        var sucesso = function (mensagem) {
            alert(mensagem);
        }

        var falha = function () {
            alert("Erro na chamada do plugin");
        }

    TrialTime.verificatrial(30, sucesso, falha);
}

```


Adicione em seu arquivo `index.html` o seguinte código dos botões que vão fazer a chamada das funções:

```html
	   <div>
            <p><button id="getTrialTime">Data de instalação</button></p>
       </div>
```

Instale a plataforma Android em seu projeto

    cordova platform add android
    
Execute seu código

    cordova run 

## Mais Informações

Para mais informações de como configurar o Apache Cordova acesse a documentação [Documentação Apache Cordova](http://cordova.apache.org/docs/en/latest/guide/cli/index.html)

Para mais informações dos plugins acesse [Guia de desenvolvimento de plugins](http://cordova.apache.org/docs/en/latest/guide/hybrid/plugins/index.html)
