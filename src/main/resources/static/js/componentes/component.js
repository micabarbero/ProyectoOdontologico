// Elementos donde me va a mostrar los datos. Es el querySelector de DONDE va a poner los datos que le pida.
const title = document.querySelector("#SeccionTitulo")
const accion = document.querySelector("#SeccionAccion")
const contenido = document.querySelector("#SeccionContenido")

// Botones del Menú. Selecciono los botones para despues decirles que hacer
const btnMenuCrearOdontologo = document.querySelector("#btnMenuCrearOdontologo")
const btnMenuListarOdontologos = document.querySelector("#btnMenuListarOdontologos")
const btnMenuCrearPaciente = document.querySelector("#btnMenuCrearPaciente")
const btnMenuListarPacientes = document.querySelector("#btnMenuListarPacientes")
const btnMenuCrearTurno = document.querySelector("#btnMenuCrearTurno")
const btnMenuListarTurnos = document.querySelector("#btnMenuListarTurnos")

// Son los componentes que van a decir que hacer.
// Es un array de objetos que tienen un titulo, una acción, contenido (formulario para crear y una lista para listar)
// Titulo: Es el titulo de mi selección (y de la opcion del menú)
// Acción: Subtitulo de la acción que seleccioné dentro de Paciente/Turno/Odonto
// Contenido: Es el form (si es crear), la lista (si es listar) + el boton que ejecuta el post/get

const Menu = [
{titulo:'Odontólogo',accion:btnMenuCrearOdontologo, contenido:form_crearOdontologo},
{titulo:'Paciente',accion:btnMenuCrearPaciente, contenido:form_crearPaciente},
{titulo:'Turno',accion:btnMenuCrearTurno, contenido:form_crearTurno},
{titulo:'Odontólogo',accion:btnMenuListarOdontologos, contenido:verOdontologos},
{titulo:'Paciente',accion:btnMenuListarPacientes, contenido:verPacientes},
{titulo:'Turno',accion:btnMenuListarTurnos, contenido:verTurnos}
]

