# proyecto-borrachinfc
# Manual Tecnico de AppEllas
- Jose Roberto Nasser Sanchez
## Introduccion
El manual tecnico tiene como objevito describir el diseno de la aplicacion y cada una de sus fases necesarias para la correcta utilidad de la aplicacion. Este manual describe los pasos necesarios para cualquier persona que tenga los requerimientos necesarios pueda realizar la instalación de la aplicacion en su dispositivo movil.
Es importante tener en cuenta que en el presente manual se hace mención a las especificaciones mínimas de hardware y software para la correcta instalación del aplicativo.
## Requerimientos tecnicos
### Requerimientos minimos de hardware    
- Memoria RAM: Se recomiendan 2 GB 
- Espacio en disco duro minimo: 500 MB de espacio en disco duro disponible para su instalación
### Requrimientos minimos de software
- Version de Android: 4.4 en adelante
- Navegador/Internet: Esta aplicación ha sido diseñada para trabajar con conexión. 
## Herramientas utilizadas para el desarrollo
### Android Studio version(4.2.2 for Ubuntu)
Es el entorno de desarrollo integrado (IDE) oficial para el desarrollo de apps para Android y está basado en IntelliJ IDEA. Además del potente editor de códigos y las herramientas para desarrolladores de IntelliJ, Android Studio ofrece incluso más funciones que aumentan tu productividad cuando desarrollas apps para Android, como las siguientes:
- Un sistema de compilación flexible basado en Gradle
- Un emulador rápido y cargado de funciones
- Integración con GitHub y plantillas de código para ayudarte a compilar funciones de apps comunes y también importar código de muestra
- Un entorno unificado donde puedes desarrollar para todos los dispositivos Android
### Visual Studio Code (version 1.57)
Es un editor de código fuente desarrollado por Microsoft para Windows, Linux y macOS. Incluye soporte para la depuración, control integrado de Git, resaltado de sintaxis, finalización inteligente de código, fragmentos y refactorización de código. En nuestra aplicacion fue usado para la creacion de la API.
 ### Heroku (version 7.56.0)
Es una plataforma en la nube que permite a las empresas construir, entregar, supervisar aplicaciones y alojarlas en la nube.
El hecho de que sea una plataforma en la nube significa que como desarrolladores no nos tenemos que preocupar por la infraestructura, sino que solamente nos tenemos   que centrar en el desarrollo de la aplicación, lo que nos evita todos los problemas que puede suponer llevar nuestra idea a la URL.
Heroku a diferencia de otras plataformas permite desarrollar prácticamente con cualquier lenguaje de programación: Ruby, Java, PHP, NodeJS.
### Mongo DB (version 4.4)
Es el servicio de base de datos global en la nube para aplicaciones modernas.
Implementa MongoDB completamente administrado en AWS, Google Cloud y Azure con la mejor automatización de su clase y prácticas comprobadas que garantizan la disponibilidad, escalabilidad y cumplimiento de los estándares de privacidad y seguridad de datos más exigentes.
### Click UP 
Es donde cada persona puede trabajar en diferentes cosas. Más que solo gestión de tareas: ClickUp ofrece documentos, recordatorios, objetivos, calendarios, planificación de horarios e incluso una bandeja de entrada. Totalmente personalizable, ClickUp funciona para todos los tipos de equipo, así que todos los equipos pueden usar la misma aplicación para planificar, organizar y colaborar.
### MVVM
Es un patrón de arquitectura de software. Se caracteriza por tratar de desacoplar lo máximo posible la interfaz de usuario de la lógica de la aplicación. 
Esta conformado por el modelo, representa la capa de datos y/o la lógica de negocio, también denominado como el objeto del dominio. El modelo contiene la información, pero nunca las acciones o servicios que la manipulan. Le sigue la vista que representa la información a través de los elementos visuales que la componen. Las vistas en MVVM son activas, contienen comportamientos, eventos y enlaces a datos que, en cierta manera, necesitan tener conocimiento del modelo subyacente. Por ultimo el modelo de vista es un actor intermediario entre el modelo y la vista, contiene toda la lógica de presentación y se comporta como una abstracción de la interfaz.
### LiveData
Es una clase de contenedor de datos observable. A diferencia de un observable regular, LiveData está optimizado para ciclos de vida, lo que significa que respeta el ciclo de vida de otros componentes de las apps, como actividades, fragmentos o servicios. Esta optimización garantiza que LiveData solo actualice observadores de componentes de apps que tienen un estado de ciclo de vida activo.
### RoomDatabase
Room proporciona una capa de abstracción sobre SQLite que permite acceder a la base de datos sin problemas y, al mismo tiempo, aprovechar toda la potencia de SQLite.
Las apps que controlan grandes cantidades de datos estructurados pueden beneficiarse con la posibilidad de conservar esos datos localmente. El caso práctico más común es almacenar en caché datos relevantes. De esa manera, cuando el dispositivo no puede acceder a la red, el usuario de todos modos puede explorar ese contenido mientras está desconectado.
### Databinding
Vincula los componentes de la IU en tus diseños con las fuentes de datos de tu app mediante un formato declarativo. 

### Diagrama relacional normalizado de bases de datos utilizada

![Diagrama de datos relacional](https://user-images.githubusercontent.com/54814932/124679076-07539e00-de81-11eb-8fa2-d7241bde7112.png)


###  Plataforma base
| Sistema Operativo | Windows 10  |  
|-------------------|-------------|
| Tecnologias   | Android Studio, Visual Studio Code| 
| Lenguaje        |  Kotlin, Node.js       |
| Gestor de BD | SQLLite | 
