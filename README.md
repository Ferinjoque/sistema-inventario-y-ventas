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
1. Este sistema ha sido diseñado para que el usuario ingrese manualmente el stock que desea registrar; es decir, no está vinculado a una base de datos.
2. El historial de ventas no se exporta como archivo .txt; la implementación de esta opción sería idónea.

## Hoja de Ruta
Para abordar las limitaciones actuales del sistema, se propone:
1. Implementar un módulo que permita registrar y gestionar información de proveedores. Esto incluiría detalles como nombre, contacto, productos suministrados y precios negociados. Facilitaría una mejor coordinación de compras y actualización automática de inventarios al recibir nuevas existencias.
2. Integrar un sistema para registrar información básica de clientes, como nombre, dirección y preferencias de compra. Esto podría personalizar la experiencia de venta, permitiendo ofrecer recomendaciones de productos basadas en el historial de compras y facilitando la gestión de devoluciones o cambios.
3. Implementar funcionalidades para rastrear pedidos desde la recepción hasta la entrega final al cliente. Esto incluiría actualizar automáticamente el estado del pedido en el sistema y notificar al cliente sobre el progreso de su entrega.
4. Desarrollar herramientas para generar informes periódicos sobre ventas realizadas, ingresos generados y análisis de inventarios. Estos informes podrían incluir gráficos y estadísticas que ayuden a identificar productos más vendidos, estacionalidades y niveles de stock críticos. 
5. Vincular el código a una base de datos para que cualquier cambio sea registrado, incluso después de terminar la ejecución del código.

## Capturas de Pantalla

![Sistema de Gestión de Inventario y Ventas](imagenes/sistema-inventario-y-ventas.png)

## Contribución

¡Las contribuciones de código son bienvenidas! Por favor, confirma cualquier _pull request_ en la rama `main`. Obten más información sobre cómo contribuir leyendo las [Pautas de contribución](https://contributing.bitwarden.com/contributing/). Consulta la [Documentación de contribución](https://contributing.bitwarden.com/) para saber cómo comenzar con tu primera contribución.

La forma más sencilla de contribuir es utilizando el Sistema de Gestión de Inventario y Ventas y enviando cualquier comentario que tengas a mi correo electrónico. Me interesa conocer cómo se utiliza el sistema en diferentes contextos y estaré encantado de incluir capturas de pantalla en el [README.md](README.md) si las posees. Además, las contribuciones de código son bienvenidas en cualquier forma, desde correcciones ortográficas hasta la implementación de nuevas funciones.

Para obtener más detalles, consulta el archivo [CONTRIBUTING.md](CONTRIBUTING.md).

## Agradecimientos

* Gracias a mis compañeros, quienes me permitieron compartir nuestro trabajo.

## Licencia

GNU General Public License, versión 3 o posterior.
