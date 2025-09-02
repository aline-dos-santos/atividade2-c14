# Exercicio1_c14

## Descrição do Projeto
Este projeto em **Java** tem como objetivo realizar o **cadastro de pessoas** via entrada do usuário e converter os dados para o formato **JSON**, utilizando a biblioteca [Gson](https://github.com/google/gson).  

O programa solicita ao usuário:
- A quantidade de pessoas a serem cadastradas  
- Nome e idade de cada pessoa  

Ao final, a lista de pessoas é exibida em formato JSON no terminal.  

---

## Tecnologias Utilizadas
- **Java 23**  
- **Maven** para gerenciamento de dependências e build  
- **Gson (2.10.1)** para conversão de objetos Java em JSON  

---

## Configuração e Instalação

### 1. Clonar o Repositório
```bash
git clone https://github.com/seu-usuario/atividade2-c14.git
cd atividade2-c14/Exercicio1_c14
```

### 2. Verificar Dependências
O projeto utiliza **Maven** e já possui o `pom.xml` configurado. A dependência principal é:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

Maven baixará automaticamente a dependência durante o build.  

---

## Resolução de Conflitos no Git

Durante o desenvolvimento, ocorreu um conflito de merge entre as branches `main` e `nova`.  
O processo de resolução foi feito no **Visual Studio Code**, conforme os passos abaixo:

1. Estando na branch principal (`main`), foi feito o pull para garantir que estava atualizada:  
   ```bash
   git checkout main
   git pull origin main
   ```

2. Foi iniciado o merge da branch `nova` na `main`:  
   ```bash
   git merge nova
   ```

3. Em seguida, abri o Visual Studio Code para visualizar os conflitos:  
   ```bash
   code .
   ```

4. No VS Code, os arquivos em conflito apareceram destacados. O editor ofereceu opções como:  
   - **Accept Current Change** (manter o código da `main`)  
   - **Accept Incoming Change** (manter o código da `nova`)  
   - **Accept Both Changes** (mesclar os dois trechos)  

   Foram escolhidas as opções adequadas em cada caso, ajustado o código manualmente e salvos os arquivos.

5. Após a resolução, o commit e o push foram realizados diretamente pelo próprio **Visual Studio Code**, utilizando a aba de controle de versão.

## Histórico de Erros/Regressões
Regressão em `ContaBancaria.sacar()`;
Erro introduzido: removida a verificação de saldo, fazendo com que o teste `sacarexceptionTest()` falhe.
Correção aplicada: restaurada verificação de `valor > 0 && valor <= saldo` e lançamento de exceção para valores inválidos;
Resultado: O teste passou novamente.
