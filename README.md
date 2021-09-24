### Maven

Install Apache Maven on Ubuntu 20.04

sudo apt update
sudo apt install maven

mvn -version

Creating a Project


mvn archetype:generate -DgroupId=com.nestor.app -DartifactId=example-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false


#### compile the project and generate target folder

mvn compile

### generar .jar , deploy

.war , artifecto web

mvn package

## Guarda una version del proyecto (Compilar y empaquetar)
mvn install


## Limpiar memoria cache -> Remueve la carpeta target

mvn clean

### Limpiar, compilar y empaquetar

mvn clean install


### No generar pruebas

mvn clean install -Dmaven.test.skip=true

### Archivo de configuracion

pom.xml

### Dependencias con Maven

https://mvnrepository.com

Todas son alojadas localmente en

cd  /home/nestor/.m2/repository


#### JSF  (Patron de diseno)
Framework basado en MVC

Proporciona un conjunto de componentes en forma de etiqueras definidas en paginas XHTML

Antes de la especificacion actual se utilizava JSP para la creacion de nuestras pantallas.

Patron de diseno MVC
Modelo Vista Controlador
Gran cantidade de componentes

Configuracion

Solo hay que agregar las dependencias en el archivo pom.xml
Agregar en el archivo web.xml el mapeo de las paginas de las pantallas

Se debe crear un archivo con extension xhtml.
El controlador se encargada de comunicar las propiedades y metodos con la pantalla xhtml.




### How to link Tomcat server config in Intellij IDEA?

/usr/share/tomcat9 in Tomcat_Home.
/var/lib/tomcat9 in Tomcat base directory.


https://blog.csdn.net/pan_junbiao/article/details/89639004