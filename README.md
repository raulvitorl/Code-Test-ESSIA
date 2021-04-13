[![jdkversions](https://img.shields.io/badge/Java-11%2B-yellow.svg)]()
[![springversions](https://img.shields.io/badge/Spring-v2.3.4-green)]()
[![vueversions](https://img.shields.io/badge/vue.js-2.2.x-brightgreen.svg)]()
[![es2015](https://img.shields.io/badge/ECMAScript-6-green.svg)]()

## Overview

Lembrando da nossa conversa sobre que o que me motivava era aprender coisas novas, decidi fazer
o teste justamente com as coisas que eu não conhecia direito até nossa conversa, fiz testes unitários no controlador, e o front utilizando Vue(Vúe).


## Demonstração

[![demo-image](https://github.com/boylegu/SpringBoot-vue/blob/master/images/demo.gif?raw=true)]()

### Funcionalidades (v0.1)
- Spring Boot (Back-end) 

  -API RestFul no SpringBoot with com lógica do CRUD

  - CORS para integração com o front

  - Testes Unitários no Controller

  - [Swagger](http://localhost:8000/file-api/swagger-ui.html)

  - Implementação de paginação da API RestFul com JPA e SpringBoot

- VueJS & webpack (front-end)

  - Seguindo ECMAScript 6

  - Codificação por componentes de arquivo único no vueJS
  
  - Comunicação simples: non parent-child communication and parent-child communication
  
  - Implementação de Paginação
  
  - Componentes Reutilizáveis
  
     - DbHeader.vue
     - DbFooter.vue 
     - DbFilterinput.vue
     - DbModal.vue
     - DbSidebar.vue
     - DbTable.vue

### Stack que eu usei

- Java 11
- Spring Boot 2.3.4
- Maven
- vueJS 2.x
- webpack 2.x
- element ui
- axios
- MySQL

### Como rodar a aplicação completa

### Dados do MySQL que a API usa:
    
    url: jdbc:mysql://localhost:3306/file_structure
    username: root
    password: 12345
*Você precisa criar esta base e este usuário

- Por favor ter a versão 11 do JAVA por favor
- instalar o Node.js / NPM
- Clonar o Repositorio

        git clone https://github.com/raulvitorl/Code-Test-ESSIA.git
        
        cd Code-Test-ESSIA


### Intalação  
        
- Subir o ambiente do front-end

        cd essia-file-system-api-frontend

        npm install 

### Uso

- Rodar o servidor back-end

        cd essia-file-system-api/target/
        
        java -jar file-0.0.1-SNAPSHOT.jar

[![](https://github.com/boylegu/SpringBoot-vue/blob/master/images/spring_run.png?raw=true)]()

- Rodar o Front-end

        cd essia-file-system-api-frontend

        npm run dev


## Para Fazer o Front em Vue, usei este projeto como base:

- [SpringBoot-vue](https://github.com/boylegu/SpringBoot-vue)
