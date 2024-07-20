# Estado del Proyecto

_La última versión es 1.0. Este archivo se actualizó por última vez el 20 de julio de 2024._

# El Sistema de Gestión de Inventario y Ventas

El Sistema de Gestión de Inventario y Ventas permite el control y seguimiento detallado de los productos disponibles, facilita la realización de ventas de manera rápida y precisa, y mantiene un historial completo de todas las transacciones.

1. [Inicio Rápido](#inicio-rápido)
2. [Funcionamiento](#funcionamiento)
3. [Consideraciones](#consideraciones)
4. [Impedimentos](#impedimentos)
5. [Hoja de Ruta](#hoja-de-ruta)
6. [Capturas de Pantalla](#capturas-de-pantalla)
7. [Contribución](#contribución)
8. [Agradecimientos](#agradecimientos)
9. [Licencia](#licencia)

## Inicio Rápido

1. Ejecuta el archivo [Main.java](src/sistemaInventario) de `src/sistemaInventario`.
2. Se te solicitará que elijas una opción entre `Agregar producto al inventario`, `Realizar una venta`, `Ver inventario`, `Ver historial de ventas`, o `Salir`.
3. Dependiendo de la opción escogida, podrás:
  * Ingresar manualmente los detalles de un nuevo producto, incluyendo su ID único, nombre, precio unitario y cantidad inicial en stock.
  * Buscar rápidamente un producto específico utilizando su identificador único.
  * Ver una lista detallada de todos los productos actualmente en el inventario.
  * Seleccionar productos del inventario, especificar la cantidad que deseas vender y generar automáticamente un recibo detallado.
  * Después de cada venta exitosa, generar un recibo que detalla los productos vendidos, las cantidades, los precios unitarios y el total de la venta.
  * Acceder a un registro cronológico de todas las transacciones de ventas anteriores.
  * Terminar la ejecución del código.

## Funcionamiento

El funcionamiento del sistema se detalla paso a paso en nuestro [Informe]([TRABAJO FINAL] Sistema de Gestión de Inventario y Ventas).

## Consideraciones
1. El tamaño de diversos arrays es ajustable, como el número máximo de inventario, ventas, entre otros.

## Impedimentos
1. Este sistema ha sido diseñado siguiendo el formato utilizado por la Universidad Tecnológica del Perú para organizar su Plan de Estudios y Récord de Notas. La conversión a formato de texto plano (.txt) es específica para estos formatos, lo que significa que archivos de Plan de Estudios y/o Récord de Notas provenientes de otras universidades podrían tener dificultades de formato y escalabilidad para ser analizados.
2. La [base de datos de libros](base_datos_libros.txt) contiene únicamente 36 libros seleccionados de la sección `Libros Base por Carrera` de la carrera de Ingeniería, obtenidos de la biblioteca virtual de la Universidad Tecnológica del Perú. Estos libros abarcan diversas áreas de Ingeniería, entre las que se incluyen: Sistema e Informática, Biomédica, Electrónica, Económica y Empresarial, Mecatrónica, Eléctrica y de Potencia, Seguridad Industrial y Minera, Telecomunicaciones, Seguridad Laboral y Ambiental, Industrial, Textil y de Confecciones, Minas, y Empresarial.

## Hoja de Ruta
1. El sistema enfrenta dificultades con la similitud exacta de palabras, las cuales se han abordado en gran medida mediante el archivo de texto [stopwords (proporcionado por Alir3z4)](stopwords.txt). Este archivo permite excluir preposiciones, artículos y conectores comunes, evitando que se consideren como sinónimos. Sin embargo, persisten problemas en casos de palabras generales como, justamente, "general", donde un libro que contiene esta palabra puede ser recomendado para un curso que también la incluye, como por ejemplo, el libro `Química GENERAL` recomendado para el curso de `Teoría GENERAL de Sistemas`. Además, el diccionario de sinónimos creado manualmente es demasiado general y no es escalable para considerar todos los posibles cursos de Ingeniería. Por lo tanto, Bibliia actualmente solo funciona bien para cursos generales, ya que no se dispone de información sobre los cursos específicos de todas las ingenierías.

   Para abordar estas limitaciones, se propone el uso de procesamiento de lenguaje natural (NLP) mediante bibliotecas como Stanford NLP Library o Apache OpenNLP, que ofrecen modelos en español y funcionalidades como tokenización y segmentación de oraciones. Aunque se ha estado probando internamente, aún se requiere obtener resultados confiables para su implementación.

2. Me gustaría que este proyecto se expanda en varios aspectos en el futuro. Primero, aumentar la cantidad de libros disponibles en la base de datos. Esto podría lograrse recolectando información manualmente, aunque el proceso consume mucho tiempo. Sería ideal obtener una muestra más amplia por parte de la misma Universidad Tecnológica del Perú.

   Segundo, ampliar la utilidad del proyecto para beneficiar a estudiantes de todas las carreras, no solo de Ingeniería. Esto requeriría la creación de un diccionario más extenso y una base de datos con una variedad más amplia de libros.

## Capturas de Pantalla

![Bibliia .exe](imagenes/bibliia-exe.png)

## Contribución

¡Las contribuciones de código son bienvenidas! Por favor, confirma cualquier _pull request_ en la rama `main`. Obten más información sobre cómo contribuir leyendo las [Pautas de contribución](https://contributing.bitwarden.com/contributing/). Consulta la [Documentación de contribución](https://contributing.bitwarden.com/) para saber cómo comenzar con tu primera contribución.

La forma más sencilla de contribuir es utilizando Bibliia y enviando cualquier comentario que tengas a mi correo electrónico. Me interesa conocer cómo se utiliza Bibliia en diferentes contextos y estaré encantado de incluir capturas de pantalla en el [README.md](README.md) si las posees. Además, las contribuciones de código son bienvenidas en cualquier forma, desde correcciones ortográficas hasta la implementación de nuevas funciones.

Para obtener más detalles, consulta el archivo [CONTRIBUTING.md](CONTRIBUTING.md).

## Agradecimientos

* Gracias a Alir3z4 por proporcionar una lista de _stopwords_ comunes del Español. Su repositorio está disponible [aquí](https://github.com/Alir3z4/stop-words).

## Licencia

GNU General Public License, versión 3 o posterior.
