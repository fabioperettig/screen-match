![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Static Badge](https://img.shields.io/badge/Alura-%23001738?style=for-the-badge)


# Screen-Match 🎬

Este projeto é o resultado final do curso ["Consumindo uma API"](https://github.com/jacqueline-oliveira/2944-java-screenmatch-consumindo-webservice) da Escola de tecnologia Alura. Após a conclusão do curso, este projeto continuou crescendo, recebendo novas APIs, injeção de dependência, classes de serviço e testes padronizados.

O projeto se trata da criação de listas/backlog de filmes e métodos de consultas onde, apenas com o título do filme, o usuário tem acesso a informações extras sobre o filme como: ano de lançamento, tempo de filme, gênero, diretor, etc., através da integração de APIs externas. Para este projeto, as APIs integradas são OMDB e TMDB.

### Features do projeto 🚀
- Criar um catálogo de filmes
- Marcar quais filmes foram assistidos
- Adicionar filme a listas dedicadas
- Resgatar informações adicionais de um filme de APIs externas e conhecidas
- Mudar de API através da Injeção de Dependência
- Realizar testes dedicados através do JUnit

## Arquitetura do projeto 🏛️
<details>
  <summary>Estrutura completa do projeto</summary>

    src/main/java/screenmatch
    ├── controller
    │   └── MovieController
    ├── dao
    │   └── MovieDAO
    ├── models
    │   ├── Movie
    │   └── Title
    ├── records
    │   └── OMDBTitle
    ├── services
    │   ├── record
    │   │   ├── MovieData
    │   │   └── OMDBMovieData
    │   ├── MovieApiServiceInterface
    │   ├── OMDBservice
    │   └── TMDBservice
    └── Main

    src/test/java
    ├── TestDAO
    ├── TestRequest
    └── TestSuite
    
</details>

### Injeção de Dependência (DI) 🔀
A aplicação recebe as informações através de uma interface de serviços ao invés de uma API específica. Isso permite alternar entre as APIs OMDB e TMDB sem alterar a camada de controle do projeto e permitindo agregar novas APIs futuramente.

````java
/// Swap implementation: Dependency Injection
/// MovieApiServiceInterface service = new OMDBservice();
MovieApiServiceInterface service = new TMDBservice();
MovieDAO dao = new MovieDAO();

MovieController controller = new MovieController(service, dao);
````


### Classe DAO 📖
O projeto conta com um sistema bastante intuitivo da criação de uma instância *'Movie'* que, automaticamente, já é adicionada à lisa ***'movieBacklogg'***

````java
public class MovieDAO {

    private static ArrayList<Movie> movieBacklogg = new ArrayList<>();
    private static ArrayList<Movie> movieWatched = new ArrayList<>();

    public Movie newMovie(MovieData data){
        Movie movie = Movie.fromData(data);
        movieBacklogg.add(movie);
        return movie;
    }

    public static ArrayList<Movie> getMovieBacklogg() {
        return movieBacklogg;
    }

    public void setWatched(Movie movie){
        if(!movieBacklogg.contains(movie)){
            throw new IllegalArgumentException("This movie is not in backlog.");
        }
        movie.setWatched(true);
        movieWatched.add(movie);
    }

    public static ArrayList<Movie> getMovieWatched() {
        return movieWatched;
    }
}
````

A classe Movie, por sua vez, foi aprimorada com a pattern ***'Factory'*** de criação, protegendo a instanciação em um construtor privado, acessado apenas através do método create(), acessado através do método fromData()

````java
///CTOR
private Movie(String name, int releaseYear) {
    super(name, releaseYear);
    watched = false;
}

public static Movie create(String name, int releaseYear){
    return new Movie(name, releaseYear);
}

public static Movie fromData(MovieData data){
    Movie movie = create(data.title(), data.year());

    movie.setDirector(data.director());
    movie.setCategory(data.genre());

    return movie;
}
````

### Integração API 🛰️

Durante o curso, a escolha de API do projeto foi a OMDB, resultando em uma camada de serviços com requisição e retorno clássicos de HTTP.

````java
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

String json = response.body();
Gson gson = new GsonBuilder().setPrettyPrinting().create();
````

Após a conclusão do curso (e como um desafio pessoal), foi integrada ao projeto a API da TMDB, que apresentou uma estrutura mais robusta, servindo como estudo para diferentes tipos de API de consulta.

````java
HttpRequest detailsRequest = HttpRequest.newBuilder()
        .uri(URI.create(detailsUrl))
        .GET()
        .header("accept", "application/json")
        .header("Authorization", "Bearer " + token).build();

HttpResponse<String> detailsResponse = client.send(detailsRequest, HttpResponse.BodyHandlers.ofString());
JsonObject detailsJson = gson.fromJson(detailsResponse.body(), JsonObject.class);
String movieName = detailsJson.get("title").getAsString();
String releaseDate = detailsJson.get("release_date").getAsString();
int year = Integer.parseInt(releaseDate.substring(0, 4));
String runtime = detailsJson.get("runtime").getAsInt() + " min";

JsonArray genresJson = detailsJson.getAsJsonArray("genres");
StringBuilder genresBuilder = new StringBuilder();
````

### Variáveis de Ambiente 🔐

Para garantir a máxima segurança dos dados do usuário, o projeto contém Variáveis de Ambiente integradas em um arquivo **.env** e inicializadas na camada de serviços através da API **Dotenv**.

````
OMDB_API_KEY=your_omdb_key
TMDB_API_KEY=your_tmdb_key
TMDB_TOKEN=your_tmdb_bearer_token
````

> 💡 O arquivo .env é incorporado ao .gitignore, permanecendo apenas na máquina do usuário e impedindo vazamentos.


### Testes ✅
Para que se possa criar novas features, sem comprometer ou depender da sincronia completa do projeto, a implementação consta com classes de testes dedicadas via JUnit

````java
@Test
public void testOMDBResquet() throws IOException, InterruptedException {

    String titleRequest = "Toy Story";
    MovieData result = omdBservice.searchByTitle(titleRequest);
    dao.newMovie(result);

    Assertions.assertNotNull(result.title());
    Assertions.assertEquals(titleRequest, MovieDAO.getMovieBacklogg().get(0).getName());
}

@Test
public void testTMDBResquet() throws IOException, InterruptedException {

    String titleRequest = "Matrix";
    MovieData result = tmdBservice.searchByTitle(titleRequest);
    dao.newMovie(result);

    Assertions.assertNotNull(result.title());
}
````

---

Este projeto começou como um simples exercício sobre consumo de API e se tornou um projeto de estudo focado em arquitetura de software, injeção de dependência, integração de múltiplas APIs de consulta e testes automatizados.

O projeto receberá atualizações futuramente, mas sua primeira fase de implementação já serviu como um bom material de estudos de projetos complexos, que exigem otimização, compreensão clara e baixo acoplamento, sem abrir mão da segurança e gestão de responsabilidades.

**Projeto Alura 'Consumindo uma API' | Formação JAVA | Maio de 2026**
<br>👨‍💻 Fabio Peretti Guimarães | @fabioperettig
