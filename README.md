# Cordova Plugin Trialtime

Plugin para verificar quantos dias restam do tempo trial definido.

## Como utilizar

Crie um novo projeto Cordova em seu diretório padrão:

    $ cordova create trialtime br.com.trialtime Trialtime
    
Instalação:

    $ cordova plugin add https://github.com/CesarBalzer/cordova-plugin-trialtime.git
    
Preparando o plugin para utilização:

    $ cordova plugin prepare

Edite seu arquivo `www/js/index.js` e adicione o seguinte código para pegar a data de instalação, depois da função de chamada `app.initialize()`

```js
app.initialize();
//
document.getElementById("getTrialTime").addEventListener("click", getTrialTime);
    function getTrialTime() {
        var sucesso = function (mensagem) {
            alert(mensagem+" dias passados");
        }

        var falha = function () {
            alert("Erro na chamada do plugin");
        }
        //Informamos 30 dias para verificaçao
        Trialtime.verificatrial(30, sucesso, falha);
}

```
Se os dias de uso estiverem finalizados, retornará uma mensagem informando que:
    "O período de utilização gratuíta expirou!"
    "Faça seu registro para continuar utilizando o aplicativo!"

Caso contrário será a quantidade de dias restantes do tempo trial.

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
