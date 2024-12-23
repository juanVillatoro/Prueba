Esta es una prueba técnica, donde se plantea la creación de una aplicación dedicada a la creación de cotizaciones en base a tipos de productos y el total de estos.
La aplicación debía estar compuesta por un formulario de registro e inicio de sesión, además de un formulario para que los usuarios pudieran ingresar sus datos para la realización de la cotización.

Por errores técnicos no se pudo completar la prueba técnica para bien, pero se tomó a bien realizar la entrega de lo desarrollado hasta el momento.

-----------------------------------------------------------------------
Se tenía pensado que los endpoints fueran los siguientes:
- [GET] /api/product-types: Para obtener los tipos de productos de forma dinámica y pintarlos dentro del formulario de cotización.
- [POST] /api/product-types: Únicamente disponible para los administradores, este endpoint es para agregar nuevos tipos de productos y que se muestren automáticamente dentro de los formularios.
- [GET] /api/quotes: Para obtener las cotizaciones personales en caso de ser un usuario común.
- [POST] /api/quotes: Para agregar nuevas cotizaciones a la base de datos.
- [POST] /api/users: Para iniciar sesión dentro del aplicativo.
-----------------------------------------------------------------------

=======================================================================

Script de base de datos:

-- Crear la base de datos
CREATE DATABASE quotation;

USE quotation;

-- Crear la tabla de usuarios (clientes)
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,         -- Identificador único del usuario
    name VARCHAR(255) NOT NULL,                 -- Nombre del usuario
    email VARCHAR(255) NOT NULL UNIQUE,         -- Correo electrónico único del usuario
    password VARCHAR(255) NOT NULL UNIQUE, -- Contraseña usuario

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Fecha de creación del usuario
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Crear la tabla de tipos de productos
CREATE TABLE IF NOT EXISTS product_types (
    id INT AUTO_INCREMENT PRIMARY KEY,             -- Identificador único del tipo de producto
    name VARCHAR(255) NOT NULL,                     -- Nombre del tipo de producto
    freight_percentage DECIMAL(5,2) NOT NULL,      -- Porcentaje de flete
    import_fee_percentage DECIMAL(5,2) NOT NULL,   -- Porcentaje de la tarifa de importación
    insurance_percentage DECIMAL(5,2) NOT NULL,    -- Porcentaje del seguro
    tax_percentage DECIMAL(5,2) NOT NULL           -- Porcentaje de impuestos
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Crear la tabla de cotizaciones
CREATE TABLE IF NOT EXISTS quotes (
    id INT AUTO_INCREMENT PRIMARY KEY,                   -- Identificador único de la cotización
    user_id INT NOT NULL,                                 -- Referencia al usuario (cliente)
    product_type_id INT NOT NULL,                         -- Referencia al tipo de producto
    weight DECIMAL(10,2) NOT NULL,                        -- Peso del producto
    product_cost DECIMAL(10,2) NOT NULL,                 -- Costo base del producto
    freight_cost DECIMAL(10,2) NOT NULL,                 -- Costo del flete
    import_fee DECIMAL(10,2) NOT NULL,                   -- Costo de la tarifa de importación
    insurance_cost DECIMAL(10,2) NOT NULL,               -- Costo del seguro
    tax_cost DECIMAL(10,2) NOT NULL,                     -- Costo de impuestos
    total_import_cost DECIMAL(10,2) NOT NULL,            -- Costo total de importación
    total_cost DECIMAL(10,2) NOT NULL,                   -- Costo total (producto + otros costos)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,      -- Fecha de creación de la cotización
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- Fecha de última actualización
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE, -- Relación con la tabla de usuarios
    FOREIGN KEY (product_type_id) REFERENCES product_types(id) ON DELETE CASCADE -- Relación con la tabla de tipos de productos
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

=======================================================================