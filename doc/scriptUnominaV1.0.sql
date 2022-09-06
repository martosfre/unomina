CREATE TABLE public.nom_empleado (
	emp_id serial NOT NULL,
	empl_nombres varchar(50) NOT NULL,
	empl_apellido_paterno varchar(25) NOT NULL,
	empl_apellido_materno varchar(25) NULL,
	empl_identificacion varchar(16) NOT NULL,
	empl_fecha_ingreso date NOT NULL,
	empl_fecha_salida date NULL,
	empl_fecha_reingreso date NULL,
	empl_foto bytea NULL,
	CONSTRAINT pk_nom_empleado PRIMARY KEY (emp_id)
);
COMMENT ON TABLE public.nom_empleado IS 'Tabla para almacenar los empleados';

-- Column comments

COMMENT ON COLUMN public.nom_empleado.emp_id IS 'Identificador de empleado';
COMMENT ON COLUMN public.nom_empleado.empl_nombres IS 'Nombres del empleado';
COMMENT ON COLUMN public.nom_empleado.empl_apellido_paterno IS 'Apellido paterno empleado';
COMMENT ON COLUMN public.nom_empleado.empl_apellido_materno IS 'Apellido materno del empleado';
COMMENT ON COLUMN public.nom_empleado.empl_identificacion IS 'Idenificación del empleado';
COMMENT ON COLUMN public.nom_empleado.empl_fecha_ingreso IS 'Fecha de ingreso empleado';
COMMENT ON COLUMN public.nom_empleado.empl_fecha_salida IS 'Fecha de salida empleado';
COMMENT ON COLUMN public.nom_empleado.empl_fecha_reingreso IS 'Fecha de reingreso empleado';
COMMENT ON COLUMN public.nom_empleado.empl_foto IS 'Foto del empleado';


CREATE TYPE genero AS ENUM ('M', 'F', 'I');
ALTER TABLE public.nom_empleado ADD empl_genero public.genero NOT NULL;
COMMENT ON COLUMN public.nom_empleado.empl_genero IS 'Género del empleado';

CREATE TABLE public.nom_cargo (
	carg_id serial NOT NULL,
	carg_nombre varchar(100) NOT NULL,
	carg_descripcion varchar(300) NULL,
	CONSTRAINT pk_nom_cargo PRIMARY KEY (carg_id)
);
COMMENT ON TABLE public.nom_cargo IS 'Cargo del empleado';

-- Column comments

COMMENT ON COLUMN public.nom_cargo.carg_id IS 'Identificador de cargo';
COMMENT ON COLUMN public.nom_cargo.carg_nombre IS 'Nombre del cargo';
COMMENT ON COLUMN public.nom_cargo.carg_descripcion IS 'Descripción del cargo';

ALTER TABLE public.nom_empleado ADD carg_id int4 NOT NULL;
COMMENT ON COLUMN public.nom_empleado.carg_id IS 'Identificador de cargo';
ALTER TABLE public.nom_empleado ADD CONSTRAINT nom_empleado_fk FOREIGN KEY (carg_id) REFERENCES public.nom_cargo(carg_id);

CREATE TABLE public.nom_empresa (
	empr_id serial NOT NULL,
	empr_ruc varchar(13) NOT NULL,
	empr_razon_social varchar(100) NOT NULL,
	empr_nombre_comercial varchar(100) NOT NULL,
	CONSTRAINT pk_nom_empresa PRIMARY KEY (empr_id)
);
COMMENT ON TABLE public.nom_empresa IS 'Tabla para almacenar los datos de la compañía';

-- Column comments

COMMENT ON COLUMN public.nom_empresa.empr_id IS 'Identificador de la empresa';
COMMENT ON COLUMN public.nom_empresa.empr_ruc IS 'RUC de la empresa';
COMMENT ON COLUMN public.nom_empresa.empr_razon_social IS 'Razon social de la empresa';
COMMENT ON COLUMN public.nom_empresa.empr_nombre_comercial IS 'Nombre comercial de la empresa';


CREATE TABLE public.nom_sucursal (
	suc_id serial NOT NULL,
	suc_nombre varchar(100) NOT NULL,
	suc_direccion varchar(300) NOT NULL,
	suc_telefono_conv varchar(9) NOT NULL,
	suc_correo varchar(50) NULL,
	loca_id int4 NOT NULL,
	empr_id int4 NOT NULL,
	CONSTRAINT pk_nom_sucursal PRIMARY KEY (suc_id),
	CONSTRAINT nom_sucursal_fk FOREIGN KEY (empr_id) REFERENCES public.nom_empresa(empr_id)
);
COMMENT ON TABLE public.nom_sucursal IS 'Tabla para almacenar las sucursales de la empresa';

-- Column comments

COMMENT ON COLUMN public.nom_sucursal.suc_id IS 'Identificador de la sucursal';
COMMENT ON COLUMN public.nom_sucursal.suc_nombre IS 'Nombre de la sucursal';
COMMENT ON COLUMN public.nom_sucursal.suc_direccion IS 'Dirección sucursal';
COMMENT ON COLUMN public.nom_sucursal.suc_telefono_conv IS 'Número de teléfono convencional';
COMMENT ON COLUMN public.nom_sucursal.suc_correo IS 'Correo sucursal';
COMMENT ON COLUMN public.nom_sucursal.loca_id IS 'Identificador de la localidad';
COMMENT ON COLUMN public.nom_sucursal.empr_id IS 'Identificador de la empresa';


CREATE TABLE public.nom_departamento (
	depa_id serial NOT NULL,
	depa_nombre varchar(100) NOT NULL,
	depa_descripcion varchar(300) NULL,
	suc_id int4 NOT NULL,
	CONSTRAINT pk_nom_departamento PRIMARY KEY (depa_id),
	CONSTRAINT nom_departamento_fk FOREIGN KEY (suc_id) REFERENCES public.nom_sucursal(suc_id)
);
COMMENT ON TABLE public.nom_departamento IS 'Tabla para almacenar los departamentos de una sucursal';

-- Column comments

COMMENT ON COLUMN public.nom_departamento.depa_id IS 'Identificador de departamento';
COMMENT ON COLUMN public.nom_departamento.depa_nombre IS 'Nombre del departamento';
COMMENT ON COLUMN public.nom_departamento.depa_descripcion IS 'Descripción del departamento';
COMMENT ON COLUMN public.nom_departamento.suc_id IS 'Identificador de sucursal';


ALTER TABLE public.nom_empleado RENAME CONSTRAINT nom_empleado_fk TO carg_nom_empleado_fk;

