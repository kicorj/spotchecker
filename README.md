# SpotChecker

Este Projeto foi desenvolvido para atender ao desafio da Projuris.


## Testes unitários

```sh
mvn test
```

## Instalação (Build do pacote e container)

```sh
mvn clean package && docker build -t br.com.projuris.challenge/spotchecker .
```


## Execução

```sh
docker rm -f spotchecker || true && docker run -d -p 8080:8080 -p 4848:4848 --name spotchecker br.com.projuris.challenge/spotchecker
```

## Exemplos de chamadas e respostas

Chamada:

```sh
curl --location --request POST "http://localhost:8080/spotchecker/spot_check" --header "Content-Type: application/json" --data "[[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]"
```
Resultado esperado no response:

```sh
{"biggest_spot_area":0,"number_of_spots":0,"spots_average_area":0.0,"total_area":0}
```
Chamada:

```sh
curl --location --request POST "http://localhost:8080/spotchecker/spot_check" --header "Content-Type: application/json" --data "[[1,1,0,0],[1,1,0,0],[0,0,1,1],[0,0,1,1]]"
```
Resultado esperado no response:

```sh
{"biggest_spot_area":4,"number_of_spots":2,"spots_average_area":4.0,"total_area":4}
```
Chamada:

```sh
curl --location --request POST "http://localhost:8080/spotchecker/spot_check" --header "Content-Type: application/json" --data "[[1,0,0,0],[0,0,1,0],[0,0,0,1],[0,0,1,1]]"
```
Resultado esperado no response:

```sh
{"biggest_spot_area":3,"number_of_spots":3,"spots_average_area":1.6666666666666667,"total_area":5}
```
Chamada:

```sh
curl --location --request GET "http://localhost:8080/spotchecker/spot_check" --header "Content-Type: application/json" --data "[[1,0,0,0],[0,0,1,0],[0,0,0,1],[0,0,1,1]]"
```
Resultado esperado no response:

```sh
Invalid Method
```
Chamada:

```sh
curl --location --request POST "http://localhost:8080/spotchecker/spot_check" --header "Content-Type: application/json" --data "[[1,0,0,0],[0,0,1,0],[0,0,0,1],[0,0,1,1,1,0,1,1,0]]"
```
Resultado esperado no response:

```sh
Invalid Matrix Format
```

## Autor

* **Francisco Cardoso** - [https://github.com/kicorj](https://github.com/kicorj)
