# SpotChecker

Este Projeto foi desenvolvido para atender ao desafio da Projuris. 

## Instalação

```sh
mvn clean package && docker build -t br.com.projuris.challenge/spotchecker .
```


## Execução

```sh
docker rm -f spotchecker || true && docker run -d -p 8080:8080 -p 4848:4848 --name spotchecker br.com.projuris.challenge/spotchecker
```

## Autor

* **Francisco Cardoso** - [https://github.com/kicorj](https://github.com/kicorj)
