## Datomic

### O que é

O Datomic é um banco de dados imutável, escrito na linguagem Clojure, que é um dialeto de lisp que roda na JVM.

### Funcionamento

O datomic funciona em uma estrutura semelhante ao git, onde nenhum dado é excluido mas sempre é gravado um novo registro, dessa forma é possível fazer um diff e descobrir os **eventos de alteração** além da possibilidade de "voltar no tempo" e descobrir qual era o valor daquele registro em determinada data.

Os **eventos de alteração** ou FATOS são registrados na estrutura :

```
Fatos                    |Entidade       Atributo    Valor
2020-20-7T00:00:00       | conta           saldo        200
2020-20-7T00:10:00       | conta           saldo        100
```

É possível gravar no banco metadados em uma transação, ou seja podemos especificar qual o usuário fez a alteração, qual o requestId da alteração e qual a versão do sistema que foi utilizada, auxiliando a detecção de bugs relacionados a deploy, auditoria e questões de negocio que gostaríamos  de entender (mesmo que a feature não tenha sido desenvolvida por você, você tem uma "documentação" no banco).

### Concorrência

A concorrência o Datomic praticamente não existe, pois ele trabalha com versionamento de banco. Por exemplo, quando fazemos uma query passamos o db como parâmetro, ou seja passamos aquela versão do banco na qual queremos executar a query, qualquer alteração feita será em cima daquela versão, e qualquer concorrência  que queira acontecer naquele momento vai acontecer após aquela versão ou seja em outra instância do banco.

_Quando passamos o bd como parâmetro  ele devolve um ponteiro que aponta para aquela versão(como se fosse um commit) daquele banco_

---

## Datomic standart 

- Criação de conta 
- Pedir licença

### Transactor (servidor)

O transactor é um programa que tem a permissão de gravar arquivos no banco.

__Configuração do transactor__

Em `config/samples`  localizar arquivo `dev-transactor-template.properties`. Em `licence-key` colar sua licença e mover o arquivo para fora da pasta `samples`;

__Rodando o Transactor__

Na pasta raiz rodamos `bin/transactor config/dev-transactor-template.properties`
Teremos essa resposta:

```sh
Launching with Java options -server -Xms1g -Xmx1g -XX:+UseG1GC -XX:MaxGCPauseMillis=50
Starting datomic:dev://localhost:4334/<DB-NAME>, storing data in: data ...
System started datomic:dev://localhost:4334/<DB-NAME>, storing data in: data
```

*Os dados serão salvos do diretório /data*

---

## Baixando dependências

__Maven__

No arquivo ~/.m2/settings.xml, adicione a config:
```xml
  <servers>
    …
    <server>
      <id>my.datomic.com</id>
      <username>luca.lopes97@hotmail.com</username>
      <password>30500859-8707-4d02-b47b-da938c096638</password>
    </server>
    …
  </servers>
```
Dependencia: 
```xml
  <repositories>
    ...
    <repository>
      <id>my.datomic.com</id>
      <url>https://my.datomic.com/repo</url>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
      <releases>
        <enabled>true</enabled>
      </releases>
    </repository>
	...
  </repositories>
  ...
  <dependencies>
    ...
	<dependency>  
	 <groupId>com.datomic</groupId>  
	 <artifactId>datomic-pro</artifactId>  
	 <version>1.0.6165</version>  
	</dependency>
	...
  </dependencies>
```
---
## Integração via Peer Library

Logo após baixar as dependências devemos rodar a biblioteca do datomic rodando o seguinte comando na pasta raiz contendo o `jar`

```
bin/maven-install
```

#### Criando um database

Inicie Clojure REPL que inclua o Datomic Peer library no classpath:

```
bin/repl
```

Usando o Datomic Peer API, crie um database:

```sh
(require '[datomic.api :as d])
(def db-uri "datomic:dev://localhost:4334/poc")
(d/create-database db-uri)
```

