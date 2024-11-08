# SpaceShip API

## Descripción
La API **SpaceShip** permite gestionar naves espaciales con operaciones CRUD. Puedes realizar acciones como crear, leer, actualizar y eliminar naves, y filtrar por nombre. Además, se incluye un **Aspecto** que registra los accesos a naves con un ID negativo.

## Endpoints de la API

### 1. **Obtener todas las naves**
- **Método**: `GET`
- **URL**: `/api/spaceships`
- **Descripción**: Obtiene una lista de todas las naves espaciales con paginación.
- **Parámetros de consulta**:
    - `page`: Número de página (opcional)
    - `size`: Tamaño de página (opcional)

- **Ejemplo de petición en Postman**:
    - URL: `http://localhost:9191/api/spaceships?page=0&size=10`
    - Método: `GET`

---

### 2. **Obtener una nave por su ID**
- **Método**: `GET`
- **URL**: `/api/spaceships/{id}`
- **Descripción**: Obtiene los detalles de una nave espacial por su ID.

- **Ejemplo de petición en Postman**:
    - URL: `http://localhost:9191/api/spaceships/1`
    - Método: `GET`

---

### 3. **Buscar naves por nombre**
- **Método**: `GET`
- **URL**: `/api/spaceships/search`
- **Descripción**: Busca naves espaciales que contienen el nombre proporcionado en el parámetro `name`.

- **Parámetros de consulta**:
    - `name`: Nombre o parte del nombre a buscar.
    - `page`: Número de página (opcional)
    - `size`: Tamaño de página (opcional)

- **Ejemplo de petición en Postman**:
    - URL: `http://localhost:9191/api/spaceships/search?name=Enterprise
    - Método: `GET`

---

### 4. **Crear una nueva nave**
- **Método**: `POST`
- **URL**: `/api/spaceships`
- **Descripción**: Crea una nueva nave espacial.
- **Cuerpo de la solicitud (JSON)**:
   ```json
   {
       "name": "Millennium Falcon",
       "series": "Star Wars",
       "origin": "Corellia"
   }
