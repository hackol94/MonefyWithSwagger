# ![Serenity BDD](https://www.seekpng.com/png/detail/352-3521980_serenity-logo-serenity-bdd-logo.png "Logo Title Text 1")

# tyba Metrocuadrado Test

[![gradle](https://img.shields.io/badge/gradle-v6.5.X-yellow.svg)](https://gradle.org/install/)


>Este es un simple proyecto de Gradle que contiene un framework de pruebas UI y API que ejecuta un test base sobre metro cuadrado.com 
>
>Este framework ha sido desarrollado por Brayan Orlando Martinez Rodriguez con el fin de demostrar el manejo de un par de herramientas de automatización

## Prerequisites

Para poder clonar y usar este framework requiere que su computadora tenga las siguientes herramientas.

* [Git](http://git-scm.com/)
* [Gradle](https://gradle.org)


## Instalación

Usamos [Gradle](http://www.gradle.org), un gestor de proyectos multiplataforma que nos permite gestionar las dependencias necesarias para usar y operar el framework
Puedes instalar Gradle, en el siguiente sitio encuentras el paso a paso para hacerlo [install Gradle](http://www.gradle.org/installation) o use un [Gradle wrapper](http://www.gradle.org/docs/current/userguide/gradle_wrapper.html).

* ´git clone git@github.com:hackol94/tyba_MetroCuadrado.git` this repository
* Ingrese al directorio `cd tyba_MetroCuadrado`

##  Ejecución de pruebas

El parametro **-Denvironment** puede tener los valores:

* dev
- stg
+ pro

Por defecto se usa Chrome driver si requiere agregar otros web drivers debe hacerlo en el archivo sernity.conf

```bash
./gradlew clean test aggregate -Denvironment=pro
```
o 
```bash
 mvn clean verify -Denvironment=stg 
```

en caso de agregar mas webdrivers puede ejecutarlos con el siguiente comando plantilla

```bash
 mvn clean verify -Denvironment=stg  -Dwebdriver.driver=firefox
```
El resultado de las pruebas se encutra alojado en el siguente espacio `target/site/serenity` directory.

## Configuración simplificada de WebDriver y otros extras de Serenity
Los proyectos de muestra utilizan algunas funciones de Serenity que facilitan la configuración de las pruebas. En particular, Serenity usa el archivo `serenity.conf` en el directorio` src / test / resources` para configurar las opciones de ejecución de la prueba.

### Configuraciones específicas del entorno
También podemos configurar propiedades y opciones específicas del entorno, de modo que las pruebas se puedan ejecutar en diferentes entornos. Aquí, configuramos tres entornos, __dev__, _stg_ y _pro_, con diferentes URL de inicio para cada uno:
```json
serenity {
        project.name = "com.training.api"
                logging = VERBOSE
        }

        feature.file.encoding = iso-8859-1
                enable.markdown=story narrative scenario step

        serenity.include.actor.name.in.consequences = true
        feature.file.encoding = iso-8859-1
        enable.markdown = story narrative scenario step



environments{
  default {
    rest.base.url = "http://localhost:8080/api/v3/"
    rest.store.path.inventory = "store/inventory"
    rest.store.path.order = "store/order"
  }

  stg {
    rest.base.url = "http://localhost:8080/api/v3/"
    rest.store.path.inventory = "store/inventory"
    rest.store.path.order = "store/order"
  }

  dev {
    rest.base.url = "http://localhost:8080/api/v3/"
    rest.store.path.inventory = "store/inventory"
    rest.store.path.order = "store/order"
  }
}

```

Utiliza la propiedad del sistema `environment` para determinar en qué entorno ejecutar. Por ejemplo, para ejecutar las pruebas en el entorno de ensayo, puede ejecutar:
json
$ mvn clean verify -Denvironment=stg
```

### Estructura del proyecto y sus direcctorios
El proyecto tiene scripts de compilación para Gradle, y sigue la estructura de directorio estándar utilizada en la mayoría de los proyectos de Serenity:
`` Gherkin
src
  + main                                  | Origen
    + java                                | Sección de codigo java
      + tyba.test.metrocuadrado           | Package base
        + models                          | Modelos de las entidades
        + task                            | Task de usuario sobre el SUT
        + ui                              | Representa las paginas y sus objjetos
  + test                                  |
    + java                                | Test y soporte de las pruebas
      + tyba.test.metrocuadrado           | Package base
        + cast                            | Sección personalizada de codigo para seteo de los escenarios y usar variables de Environments 
        + enviroments                     | Modelo de control de variables del Serenity.conf para uso en pruebas
        + NavigateTo                      | Sección de paginas y navegación
          + pages                         | Paginas usables para navegación en UI
        + runners                         | Clases para ejecutar las pruebas
        + stepDefinitions                 | Glue sección de definicion de pruebas
          + {feature_name}Definition.java | Definicion de clases para las caractiristicas y pasos de las pruebas sobre el SUT 
    + resources                           |
      + features                          | Directorio de archivos Feature 
         + {feature_name}                 | Archivo Feature en especifico
             {feature_name}.feature       | Sub Archivo Feature en especifico (Opcional depende de la estructuración de las pruebas)
      + serenity.conf                     | Archivo de configuración de serenity
serenity.properties                       | Propiedades generales de serenity
```


## Instalar web driver local

```bash
brew tap homebrew/cask && brew cask install chromedriver

```

dentro del los recursos del proyecto hay una carpeta llamada web driver puede hacer uso manual del webdriver descargalo ponerlo ahi y en serenity.conf agregar la definicion del webdriver incluyendo el sistema operativo necesario


## ¿Querer aprender más?
Para obtener más información sobre Serenity BDD, puede leer el [**Serenity BDD Book**](https://serenity-bdd.github.io/theserenitybook/latest/index.html), la fuente de documentación oficial en línea de Serenity. Otras fuentes incluyen:
* **[Byte-sized Serenity BDD](https://www.youtube.com/channel/UCav6-dPEUiLbnu-rgpy7_bw/featured)** : consejos y trucos sobre Serenity BDD
* [**Serenity BDD Blog**](https://johnfergusonsmart.com/category/serenity-bdd/) : artículos habituales sobre Serenity BDD
* [**The Serenity BDD Dojo**](https://serenitydojo.teachable.com)  - Capacitación en línea sobre Serenity BDD y sobre automatización de pruebas y BDD en general.


# Docker-k6-grafana-influxdb
Demonstrates how to run load tests with containerised instances of K6, Grafana and InfluxDB.

#### Article
This is the accompanying source code for the following article. Please read for a detailed breakdown of the code and how K6, Grafana and InfluxDB work together using Docker Compose:

https://medium.com/swlh/beautiful-load-testing-with-k6-and-docker-compose-4454edb3a2e3

#### Dashboards
The dashboard in /dashboards is adapted from the excellent K6 / Grafana dashboard here:
https://grafana.com/grafana/dashboards/2587

There are only two small modifications:
* the data source is configured to use the docker created InfluxDB data source
* the time period is set to now-15m, which I feel is a better view for most tests

#### Scripts
The script here is an example of a low Virtual User (VU) load test of the excellent Star Wars API:
https://swapi.dev/

If you're tinkering with the script, it is just a friendly open source API, be gentle!
