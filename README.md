# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

# Spring Boot REST API Development Basics - Important Annotations
## O que é um Controller?

Um Controller em Spring Boot é uma classe Java que é responsável por receber as requisições HTTP do cliente e retornar a resposta apropriada. É uma parte crucial do desenvolvimento de APIs RESTful, pois conecta as camadas de front-end e back-end da aplicação.

Em Spring Boot, os Controllers são identificados pela anotação '@Controller'. Essa anotação informa ao Spring que a classe é um controlador e deve ser gerenciada pelo contêiner de injeção de dependência.

Outra anotação importante é '@RequestMapping'. Essa anotação é usada para mapear uma URL específica para um método em um Controller. Por exemplo, se a URL for 'http://localhost:8080/api/users', o método no Controller que lida com essa requisição pode ser mapeado com '@RequestMapping("/api/users")'.

Existem outras anotações úteis em Spring Boot para Controllers, como '@PostMapping', '@GetMapping', '@PutMapping' e '@DeleteMapping'. Essas anotações são usadas para mapear métodos HTTP específicos para ações CRUD (Create, Read, Update, Delete) em um Controller.

Em resumo, um Controller em Spring Boot é uma classe Java que gerencia as requisições HTTP do cliente e retorna as respostas apropriadas. As anotações '@Controller', '@RequestMapping' e outras são usadas para configurar o comportamento do Controller e mapear URLs específicas para métodos em um Controller.

## Diferenças entre as anotações @RestController e @Controller

Além da anotação '@Controller', o Spring Boot também fornece a anotação '@RestController'. A principal diferença entre essas duas anotações é que '@RestController' é uma combinação de '@Controller' e '@ResponseBody'. Isso significa que todos os métodos em uma classe anotada com '@RestController' retornam diretamente objetos que serão serializados em JSON ou XML, em vez de serem renderizados em uma visualização.

Por exemplo, se um método em um Controller anotado com '@Controller' retornar um objeto User, o Spring tentará renderizar esse objeto em uma visualização. Já em um Controller anotado com '@RestController', o objeto User será serializado em JSON ou XML e retornado diretamente como uma resposta HTTP.

Portanto, a anotação '@RestController' é uma escolha melhor para construir APIs RESTful, enquanto a anotação '@Controller' é mais adequada para construção de aplicativos web tradicionais.

## O que é um Java Bean?

Um Java Bean é uma classe Java que segue um conjunto de convenções para que possa ser facilmente reutilizada em diferentes contextos. Conforme definido pela especificação JavaBeans, uma classe Java é um Java Bean se atender aos seguintes requisitos:

- Possui um construtor padrão sem parâmetros
- Possui propriedades acessíveis por meio de métodos getter e setter
- Implementa a interface Serializable, se necessário

Os Java Beans são frequentemente utilizados em frameworks de desenvolvimento de software para simplificar a criação de componentes reutilizáveis. Eles podem ser usados em aplicações desktop, web e móveis para representar dados de forma estruturada e consistente.

Em resumo, um Java Bean é uma classe Java que segue um conjunto de convenções para ser facilmente reutilizada em diferentes contextos. Ele possui um construtor padrão sem parâmetros, propriedades acessíveis por meio de métodos getter e setter, e pode implementar a interface Serializable, se necessário.

## O que é a anotação @PathVariable?

A anotação '@PathVariable' em Spring Boot é usada para mapear variáveis de caminho em uma URL para parâmetros em um método de um Controller. Por exemplo, se a URL for 'http://localhost:8080/api/users/123', onde '123' é o ID do usuário, o método no Controller que lida com essa requisição pode ser mapeado com '@GetMapping("/api/users/{userId}")' e o parâmetro 'userId' pode ser anotado com '@PathVariable'.

Essa anotação é útil quando há uma necessidade de passar dados dinâmicos em uma URL para um método em um Controller. Por exemplo, em uma aplicação de blog, o ID do post pode ser passado como uma variável de caminho na URL e, em seguida, usado para recuperar as informações do post do banco de dados.

Em resumo, a anotação '@PathVariable' é usada em Spring Boot para mapear variáveis de caminho em uma URL para parâmetros em um método de um Controller. Isso é útil quando há uma necessidade de passar dados dinâmicos em uma URL para um método em um Controller.

## O que é a anotação @RequestParam?

A anotação '@RequestParam' em Spring Boot é usada para mapear parâmetros de consulta em uma URL para parâmetros em um método de um Controller. Por exemplo, se a URL for 'http://localhost:8080/api/users?name=john&age=30', onde 'name' e 'age' são os parâmetros de consulta, o método no Controller que lida com essa requisição pode ser mapeado com '@GetMapping("/api/users")' e os parâmetros 'name' e 'age' podem ser anotados com '@RequestParam'.

Essa anotação é útil quando há uma necessidade de passar dados em uma URL para um método em um Controller. Por exemplo, em uma aplicação de busca de produtos, os parâmetros de consulta podem ser usados para filtrar os resultados de busca com base em critérios específicos.

Em resumo, a anotação '@RequestParam' é usada em Spring Boot para mapear parâmetros de consulta em uma URL para parâmetros em um método de um Controller. Isso é útil quando há uma necessidade de passar dados em uma URL para um método em um Controller.

## Anotações CRUD de uma API

Em uma API RESTful, geralmente são necessárias operações CRUD (Create, Read, Update, Delete) em recursos. Em Spring Boot, existem anotações específicas que podem ser usadas para mapear essas operações para métodos em um Controller.

- '@PostMapping': usado para criar um novo recurso
- '@GetMapping': usado para recuperar um ou mais recursos
- '@PutMapping': usado para atualizar um recurso existente
- '@DeleteMapping': usado para excluir um recurso existente

Essas anotações são usadas em conjunto com a anotação '@RequestMapping' para mapear URLs específicas para operações CRUD. Por exemplo, um método que cria um novo usuário pode ser mapeado com '@PostMapping("/api/users")', enquanto um método que retorna todos os usuários pode ser mapeado com '@GetMapping("/api/users")'.

Em resumo, as anotações '@PostMapping', '@GetMapping', '@PutMapping' e '@DeleteMapping' são usadas em Spring Boot para mapear operações CRUD em recursos em uma API RESTful. Essas anotações são usadas em conjunto com a anotação '@RequestMapping' para mapear URLs específicas para operações CRUD.

## O que é o ResponseEntity?

O ResponseEntity em Spring Boot é uma classe que representa a resposta HTTP de uma API RESTful. Ele é usado para retornar dados juntamente com o código de status HTTP apropriado e os cabeçalhos HTTP.

Em vez de retornar apenas o objeto de dados, como é o caso com a anotação '@ResponseBody', o ResponseEntity permite que você retorne o objeto de dados juntamente com o código de status HTTP e os cabeçalhos HTTP. Isso é útil quando você precisa controlar o código de status HTTP retornado pela API, como quando um recurso não é encontrado ou quando ocorre um erro de servidor.

Por exemplo, se você quiser retornar um objeto User juntamente com o código de status HTTP 200 (OK), você pode criar um ResponseEntity<User> e definir o objeto de dados e o código de status HTTP apropriado.

```
@GetMapping("/api/users/{id}")
public ResponseEntity<User> getUser(@PathVariable Long id) {
    User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    return ResponseEntity.ok(user);
}

```

Em resumo, o ResponseEntity em Spring Boot é usado para retornar dados juntamente com o código de status HTTP apropriado e os cabeçalhos HTTP em uma API RESTful. Ele é útil quando você precisa controlar o código de status HTTP retornado pela API, como quando um recurso não é encontrado ou quando ocorre um erro de servidor.

### Anotação @RequestMapping

A anotação '@RequestMapping' em Spring Boot é usada para mapear uma URL específica para um método em um Controller. Isso é útil quando você precisa definir o comportamento de um método em relação a uma determinada URL. Por exemplo, se a URL for 'http://localhost:8080/api/users', o método no Controller que lida com essa requisição pode ser mapeado com '@RequestMapping("/api/users")'. Além disso, a anotação '@RequestMapping' pode ser usada com diferentes métodos HTTP, como '@RequestMapping(value = "/api/users", method = RequestMethod.GET)', para mapear uma URL específica para um método HTTP específico.