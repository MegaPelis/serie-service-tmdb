
# Lambda Serie TMDB

Servicio que permite consulta al api [TMDB](https://www.themoviedb.org/?language=es)
 - Consultar serie por Id
 - Consulatr serie por Id y Temporada
 - Consultar serie por Id, Temporada y Episodio
 - Consultar todas las series populares




## Formato Request
  | Nombre     | Tipo            | Descripción                  | Requerido |
  |------------|-----------------|------------------------------|-----------|
  | traceId    | String          | Identificador                |Si         |
  | dateTime   | String          | Fecha y hora                 |Si         |
  | service    | String          | Servicio                     |Si         |
  | operation  | String          | Operación a ejecutar         |Si         |
  | properties | List<Property>  | Propiedades Adiccionales     |No         |
  | data       | Object          | Cuerpo de la petición        |Si         |

  **Property**
  ```sh
  {
    "name" : String,
    "value" : String
  }
  ```

## Formato Response
  | Nombre     | Tipo            | Descripción                  |
  |------------|-----------------|------------------------------|
  | traceId    | String          | Identificador                |
  | dateTime   | String          | Fecha y hora                 |
  | service    | String          | Servicio                     |
  | operation  | String          | Operación a ejecutar         |
  | status     | Status          | Estado de la respuesta       |
  | data       | Object          | Cuerpo de la respuesta       |

**Status**
  ```sh
  {
    "code" : String,
    "messageBackend" : String,
    "messageFrontend" : String
  }
  ```

---
# Operaciones

## Operación: findById

Servicio que permite consultar una serie por su id

  | Nombre     | Tipo            | Descripción                  | Requerido |
  |------------|-----------------|------------------------------|-----------|
  | idSerie    | String          | Id Serie                     |Si         |

**Request**
  ```sh
  {
    "traceId" : String,
    "dateTime" : String,
    "service" : String,
    "operation" : String,
    "properties" : String [],
    "data": {
        "idSerie": String
    }
  }
  ```

**Ejemplo Request**
  ```sh
  {
    "traceId": "9826-A72S-9273-0000",
    "dateTime": "2022/10/23 09:09:00",
    "service": "SerieTMDB",
    "operation": "findById",
    "properties": [],
    "data": {
        "idSerie": "1402"
    }
  }
  ```

## Operación: findByIdAndSeason

Servicio que permite consultar una serie por su id y temporada

  | Nombre     | Tipo            | Descripción                  | Requerido |
  |------------|-----------------|------------------------------|-----------|
  | idSerie    | String          | Id Serie                     |Si         |
  | season     | String          | Id Temporada                 |Si         |

**Request**
  ```sh
  {
    "traceId" : String,
    "dateTime" : String,
    "service" : String,
    "operation" : String,
    "properties" : String [],
    "data": {
        "idSerie": String,
        "season": String
    }
  }
  ```

**Ejemplo Request**
  ```sh
  {
    "traceId": "9826-A72S-9273-0000",
    "dateTime": "2022/10/23 09:09:00",
    "service": "SerieTMDB",
    "operation": "findByIdAndSeason",
    "properties": [],
    "data": {
        "idSerie": "1402",
        "season": "1"
    }
  }
  ```

## Operación: findByIdAndSeasonAndEpisode

Servicio que permite consultar una serie por su id, temporada y episodio

  | Nombre     | Tipo            | Descripción                  | Requerido |
  |------------|-----------------|------------------------------|-----------|
  | idSerie    | String          | Id Serie                     |Si         |
  | season     | String          | Id Temporada                 |Si         |
  | episode    | String          | Id Episodio                  |Si         |

**Request**
  ```sh
  {
    "traceId" : String,
    "dateTime" : String,
    "service" : String,
    "operation" : String,
    "properties" : String [],
    "data": {
        "idSerie": String,
        "season": String,
        "episode": String
    }
  }
  ```

**Ejemplo Request**
  ```sh
  {
    "traceId": "9826-A72S-9273-0000",
    "dateTime": "2022/10/23 09:09:00",
    "service": "SerieTMDB",
    "operation": "findByIdAndSeasonAndEpisode",
    "properties": [],
    "data": {
        "idSerie": "1402",
        "season": "1",
        "episode": "1"
    }
  }
  ```

## Operación: findAllByPopular

Servicio que permite consultar todas las series populares

  | Nombre     | Tipo            | Descripción                  | Requerido |
  |------------|-----------------|------------------------------|-----------|
  | page       | int             | Pagina a consultar           |No         |

**Request**
  ```sh
  {
    "traceId" : String,
    "dateTime" : String,
    "service" : String,
    "operation" : String,
    "properties" : String [],
    "data": {
        "page": int
    }
  }
  ```

**Ejemplo Request**
  ```sh
  {
    "traceId": "9826-A72S-9273-0000",
    "dateTime": "2022/10/23 09:09:00",
    "service": "SerieTMDB",
    "operation": "findAllByPopular",
    "properties": [],
    "data": {
        "page": 1
    }
  }
  ```