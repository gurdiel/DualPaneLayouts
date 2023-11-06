# DualPaneLayouts

Ejemplo del uso de fragmentos para mostrar la implementación de paneles duales en pantallas grandes, usando fragmentos estáticos que se comunican entre ellos

Se trata de una aplicación que muestra una lista de signos del zodicado, y al hacer click en uno de ellos, muestra el detalle de dicho signo. 


1. Si la aplicación se ejecuta en una pantalla de tamaño normal, entonces se cargará el diseño con un único fragmento, y al hacer click en un signo, carga otra actividad (DetailActivity) que contiene el otro fragmento mediante un intent explícito. 
2. Para aprovechar pantallas grandes en dispositivos como tabletas, la actividad principal contiene directamente ambos fragmentos. En este caso no se usa la actividad DetailActivity para nada, ya que los dos fragmentos que nos interesan están presentes en la activity_main cargada.

   Por ejemplo, en una tablet Nexus 10:

    ![Ejemplo en un Nexus 10](imagenes/tablet.png)

En el activity_main por defecto sólo hay un fragment, pero se añade un layout adicional para usar con pantallas grandes

Esto se hace desde la vista Android del proyecto, sobre res/layout  seleccionamos New->Layout Resource File
![insertar layout](imagenes/img.png)
 - En la ventana que se muestra, podemos añadir un layout con el  mismo nombre activity_main, pero seleccionamos la propiedad "Smallest Screen Width" y le damos un valor de 600. Así, este layout se aplicará automáticamente en pantallas con al menos 600dp de ancho:
![propiedad smallest screen width.png](imagenes/img_1.png)
 - Este layout adicional tiene dos fragment en lugar de uno. Así sacamos provecho de su espacio adicional. 

De este modo, tendremos dos layouts, controlados ambos desde el mismo _MainActivity.kt._

En este proyecto se puede observar una forma de comunicar distintos fragmentos entre sí (para el caso de la tableta). En este caso se hace a través de las actividad que las contiene. 
 - Definimos una clase de tipo interface, que simplemente tiene una función que hace de Listener
